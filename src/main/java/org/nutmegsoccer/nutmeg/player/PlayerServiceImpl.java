package org.nutmegsoccer.nutmeg.player;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.QPDecoderStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerDAO playerDAO;

    @Override
    public Player findById(final Long id) {

        return playerDAO.findById(id.intValue())
                .orElseThrow(() -> new ResourceNotFoundException("Player with id " + id + " not found."));

//        Optional<Player> player = playerDAO.findById(id.intValue());
//        if (player.isPresent()) {
//            return player.get();
//        } else {
//            throw new ResourceNotFoundException("Player with id " + id + " not found.");
//        }
    }

    @Override
    public Page<Player> searchPlayers(final PlayerSearchCriteria searchCriteria) {

        final Predicate searchPredicate = buildPlayerSearchPredicate(searchCriteria);

        return playerDAO.findAll(searchPredicate, searchCriteria.getPageable());
    }

    private Predicate buildPlayerSearchPredicate(final PlayerSearchCriteria searchCriteria) {

        final QPlayer qPlayer = QPlayer.player;
        final BooleanBuilder builder = new BooleanBuilder();

        searchCriteria.getFirstName().ifPresent(
                firstName -> builder.and(qPlayer.firstName.startsWithIgnoreCase(firstName)));

        searchCriteria.getLastName().ifPresent(
                lastName -> builder.and(qPlayer.lastName.startsWithIgnoreCase(lastName)));

        searchCriteria.getGender().ifPresent(
                gender -> builder.and(qPlayer.gender.eq(gender)));

        searchCriteria.getBirthdayStartsWith().ifPresent(
                birthdayStart -> builder.and(qPlayer.birthday.goe(Date.valueOf(birthdayStart))));

        searchCriteria.getBirthdayEndsWith().ifPresent(
                birthdayEnd -> builder.and(qPlayer.birthday.loe(Date.valueOf(birthdayEnd.plusDays(1)))));

        return builder.getValue();
    }

    @Override
    public Long createPlayer(final Player player) {

        return saveAndFlush(player).getId();
    }

    @Override
    public Player updatePlayer(final Player player) {

        return saveAndFlush(player);
    }

    private Player saveAndFlush(final Player player) {

        return playerDAO.saveAndFlush(player);
    }

    @Override
    public void deletePlayer(final Long id) {

        playerDAO.delete(id.intValue());
    }
}