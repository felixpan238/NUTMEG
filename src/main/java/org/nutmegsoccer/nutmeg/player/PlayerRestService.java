package org.nutmegsoccer.nutmeg.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerRestService {


    @Autowired
    private PlayerService playerService;

    @RequestMapping(method= RequestMethod.GET, value="/player/search")
    public List<Player> searchPlayers(@PathVariable String searchFilter) {
        return playerService.searchPlayer(searchFilter);
    }

    @RequestMapping(method= RequestMethod.GET, value="/player/{id}")
    public Player findById(@PathVariable Long id) {
        return playerService.findById(id);
    }

    @RequestMapping(method= RequestMethod.POST, value="/player")
    public void createPlayer(@RequestBody Player player) {
        playerService.insertPlayer(player);
    }

    @RequestMapping(method= RequestMethod.PUT, value="/player")
    public void updatePlayer(@RequestBody Player player) {
        playerService.updatePlayer(player);
    }

    @RequestMapping(method= RequestMethod.DELETE, value="/player/{id}")
    public void deletePlayer(@PathVariable int id) {
        playerService.deletePlayer(id);
    }
}
