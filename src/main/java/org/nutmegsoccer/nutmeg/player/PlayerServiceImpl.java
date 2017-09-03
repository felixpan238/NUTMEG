package org.nutmegsoccer.nutmeg.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public void updatePlayer(Player player) {

    }

    @Override
    public void deletePlayer(int id) {

    }
}
