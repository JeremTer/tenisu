package com.abbeal.usecase;


import com.abbeal.domain.entity.Player;
import com.abbeal.domain.entity.PlayerId;
import com.abbeal.domain.repository.PlayerRepository;
import com.abbeal.usecase.exceptions.UnknownPlayerException;
import org.springframework.stereotype.Service;


@Service
public class RetrieveOnePlayerInformations {
    private final PlayerRepository playerRepository;

    public RetrieveOnePlayerInformations(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player execute(Long id) {
        final var playerId = new PlayerId(id);
        final var player = playerRepository.getPlayer(playerId);
        if (player == null) {
            throw new UnknownPlayerException();
        }
        return player;

    }
}
