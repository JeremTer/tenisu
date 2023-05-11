package com.abbeal.infra.repository;

import com.abbeal.domain.entity.Player;
import com.abbeal.domain.entity.PlayerId;
import com.abbeal.domain.repository.PlayerRepository;
import com.abbeal.infra.repository.mapper.PlayerJsonMapper;
import com.abbeal.infra.repository.parser.PlayerJsonParser;
import com.abbeal.usecase.exceptions.UnknownPlayerException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class PlayerJsonRepository implements PlayerRepository {

    private final PlayerJsonMapper playerJsonMapper;
    private final PlayerJsonParser playerJsonParser;

    public PlayerJsonRepository(PlayerJsonMapper playerJsonMapper, PlayerJsonParser playerJsonParser) {
        this.playerJsonMapper = playerJsonMapper;
        this.playerJsonParser = playerJsonParser;
    }

    @Override
    public List<Player> getAllPlayers() {
        final var playerJsons = playerJsonParser.parseToPlayerJson();
        return playerJsonMapper.mapPlayersJsonToPlayers(playerJsons);
    }

    @Override
    public Player getPlayer(PlayerId id) {
        final var playerJsons = playerJsonParser.parseToPlayerJson();
        final var playerJson = playerJsons.stream()
                .filter(player -> Objects.equals(player.getId(), id.id()))
                .findFirst()
                .orElseThrow(UnknownPlayerException::new);

        return playerJsonMapper.mapOnePlayerJsonToPlayer(playerJson);
    }


}
