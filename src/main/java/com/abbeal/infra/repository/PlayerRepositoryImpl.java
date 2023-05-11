package com.abbeal.infra.repository;

import com.abbeal.domain.entity.Player;
import com.abbeal.domain.repository.PlayerRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlayerRepositoryImpl implements PlayerRepository {
    @Override
    public List<Player> getAllPlayers() {
        return null;
    }
}
