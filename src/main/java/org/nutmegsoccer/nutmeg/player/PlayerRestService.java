package org.nutmegsoccer.nutmeg.player;

import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/player")
public class PlayerRestService {

    private final PlayerService playerService;

    @Autowired
    private PlayerRestService(final PlayerService playerService) {
        this.playerService = playerService;
    }

    @RequestMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            method= RequestMethod.GET)
    public ResponseEntity<List<Player>> searchPlayers(
            @RequestParam(value = "firstName", required = false) final String firstName,
            @RequestParam(value = "lastName", required = false) final String lastName,
            @RequestParam(value = "gender", required = false) final String gender,
            @RequestParam(value = "birthdayStartsWith", required = false) final LocalDate birthdayStartsWith,
            @RequestParam(value = "birthdayEndsWith", required = false) final LocalDate birthdayEndsWith,
            @RequestParam(value = "sort", required = false) final String sort,
            @RequestParam(value = "page", required = false) final Integer page,
            @RequestParam(value = "size", required = false) final Integer size) {

        final Sort requestSort = StringUtils.hasText(sort) ?
                new Sort(sort) : new Sort("firstName");
        final PageRequest pageRequest = new PageRequest(page, size, requestSort);
        final PlayerSearchCriteria searchCriteria = PlayerSearchCriteria.newBuilder()
                .withFirstName(firstName)
                .withLastName(lastName)
                .withGender(gender)
                .withBirthdayStartsWith(birthdayStartsWith)
                .withBirthdayEndsWith(birthdayEndsWith)
                .withPageable(pageRequest)
                .build();

        final Page<Player> playerList = playerService.searchPlayers(searchCriteria);

        return new ResponseEntity<>(ImmutableList.copyOf(playerList), HttpStatus.OK);
    }

    @RequestMapping(
            method= RequestMethod.GET,
            value="/{id}")
    public Player findById(@PathVariable Long id) {

        return playerService.findById(id);
    }

    @RequestMapping(
            method= RequestMethod.POST)
    public void createPlayer(@RequestBody Player player) {

        playerService.createPlayer(player);
    }

    @RequestMapping(
            method= RequestMethod.PUT)
    public void updatePlayer(@RequestBody Player player) {

        playerService.updatePlayer(player);
    }

    @RequestMapping(
            method= RequestMethod.DELETE,
            value="/{id}")
    public void deletePlayer(@PathVariable Long id) {

        playerService.deletePlayer(id);
    }
}
