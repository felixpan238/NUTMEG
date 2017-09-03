package org.nutmegsoccer.nutmeg.player;

import java.util.List;

public interface PlayerService {
    public List<Player> searchPlayer(String searchFilter);
    public void insertPlayer(Player player);
    public Player findById (Long id);
    public void updatePlayer(Player player);
    public void deletePlayer(int id);

}
