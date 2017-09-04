package org.nutmegsoccer.nutmeg.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

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

       return null;

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