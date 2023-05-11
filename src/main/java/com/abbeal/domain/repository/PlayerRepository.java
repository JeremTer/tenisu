package com.abbeal.domain.repository;

import com.abbeal.domain.entity.Player;
import com.abbeal.domain.entity.PlayerId;

import java.util.List;

public interface PlayerRepository {
    List<Player> getAllPlayers();

    Player getPlayer(PlayerId id);

}
