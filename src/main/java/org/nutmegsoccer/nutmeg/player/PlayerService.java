package org.nutmegsoccer.nutmeg.player;

import org.springframework.data.domain.Page;

import java.util.List;

public interface PlayerService {

    Player findById (final Long id);

    Page<Player> searchPlayers(final PlayerSearchCriteria searchCriteria);

    Long createPlayer(final Player player);

    Player updatePlayer(final Player player);

    void deletePlayer(final Long id);
}
