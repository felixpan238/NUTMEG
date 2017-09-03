package org.nutmegsoccer.nutmeg.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerDAO playerDAO;

    @Override
    public List<Player> searchPlayer(String searchFilter) {
        return null;
    }

    @Override
    public void insertPlayer(Player player) {

    }

    @Override
    public Player findById(Long id) {
        Optional<Player> player = playerDAO.findById(id.intValue());
        if (player.isPresent()) {
            return player.get();
        } else {
            throw new ResourceNotFoundException("Player " + id + " not found.");
        }
    }

    @Override
    public void updatePlayer(Player player) {

    }

    @Override
    public void deletePlayer(int id) {

    }
}
