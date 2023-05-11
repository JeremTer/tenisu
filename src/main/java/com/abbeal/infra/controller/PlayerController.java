package com.abbeal.infra.controller;

import com.abbeal.infra.controller.mapper.PlayerMapper;
import com.abbeal.infra.controller.response.PlayerResponse;
import com.abbeal.usecase.RetrieveAllPlayersByRank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("players")
public class PlayerController {

    private final RetrieveAllPlayersByRank retrieveAllPlayersByRank;
    private final PlayerMapper playerMapper;

    public PlayerController(RetrieveAllPlayersByRank retrieveAllPlayersByRank, PlayerMapper playerMapper) {
        this.retrieveAllPlayersByRank = retrieveAllPlayersByRank;
        this.playerMapper = playerMapper;
    }

    @GetMapping("")
    public ResponseEntity<List<PlayerResponse>> getPlayersByRank() {
        final var players = retrieveAllPlayersByRank.execute();
        final List<PlayerResponse> playersResponse = playerMapper.mapToPlayersResponse(players);
        return ResponseEntity.ok(playersResponse);
    }
}
