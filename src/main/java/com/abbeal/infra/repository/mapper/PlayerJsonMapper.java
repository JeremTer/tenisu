package com.abbeal.infra.repository.mapper;

import com.abbeal.domain.entity.*;
import com.abbeal.infra.repository.model.PlayerJson;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlayerJsonMapper {

    public List<Player> mapPlayersJsonToPlayers(List<PlayerJson> playerJsons) {
        return playerJsons.stream()
                .map(this::mapOnePlayerJsonToPlayer)
                .collect(Collectors.toList());
    }

    private Player mapOnePlayerJsonToPlayer(PlayerJson playerJson) {
        final var playerJsonData = playerJson.getData();
        final var player = new Player(
                new PlayerId(playerJson.getId()),
                playerJson.getFirstname(),
                playerJson.getLastname(),
                playerJson.getShortname(),
                playerJson.getSex(),
                mapCountry(playerJson),
                playerJson.getPicture(),
                playerJsonData.getRank(),
                playerJsonData.getPoints(),
                playerJsonData.getWeight(),
                playerJsonData.getHeight(),
                playerJsonData.getAge(),
                playerJsonData.getLast()
        );

        final List<Game> games = mapGames(playerJson, player);
        player.setGames(games);
        return player;
    }

    private List<Game> mapGames(PlayerJson playerJson, Player player) {
        return playerJson.getData().getLast().stream()
                .map(gameState -> {
                    if (gameState == 0) {
                        return new Game(null, player, null);
                    }
                    return new Game(player, null, null);
                }).collect(Collectors.toList());
    }

    private Country mapCountry(PlayerJson playerJson) {
        final var country = playerJson.getCountry();
        return new Country(new CountryId(country.getCode()), country.getPicture());
    }
}
