package com.abbeal.infra.repository.parser;

import com.abbeal.infra.repository.model.PlayerJson;
import com.abbeal.infra.repository.model.Players;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class PlayerJsonParser {

    public List<PlayerJson> parseToPlayerJson() {
        final var objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File("headtohead.json"), Players.class).getPlayers();
        } catch (IOException e) {
            throw new JsonParseErrorException();
        }
    }
}
