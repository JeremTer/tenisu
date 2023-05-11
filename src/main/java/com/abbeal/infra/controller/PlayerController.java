package com.abbeal.infra.controller;

import com.abbeal.infra.controller.mapper.PlayerMapper;
import com.abbeal.infra.controller.response.PlayerResponse;
import com.abbeal.usecase.FindAveragePlayerBMI;
import com.abbeal.usecase.RetrieveAllPlayersByRank;
import com.abbeal.usecase.RetrieveOnePlayerInformations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("players")
public class PlayerController {

    private final RetrieveAllPlayersByRank retrieveAllPlayersByRank;
    private final PlayerMapper playerMapper;
    private final RetrieveOnePlayerInformations retrieveOnePlayerInformations;
    private final FindAveragePlayerBMI findAveragePlayerBMI;

    public PlayerController(RetrieveAllPlayersByRank retrieveAllPlayersByRank, PlayerMapper playerMapper, RetrieveOnePlayerInformations retrieveOnePlayerInformations, FindAveragePlayerBMI findAveragePlayerBMI) {
        this.retrieveAllPlayersByRank = retrieveAllPlayersByRank;
        this.playerMapper = playerMapper;
        this.retrieveOnePlayerInformations = retrieveOnePlayerInformations;
        this.findAveragePlayerBMI = findAveragePlayerBMI;
    }

    @GetMapping("")
    public ResponseEntity<List<PlayerResponse>> getPlayersByRank() {
        final var players = retrieveAllPlayersByRank.execute();
        final List<PlayerResponse> playersResponse = playerMapper.mapToPlayersResponse(players);
        return ResponseEntity.ok(playersResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerResponse> getOnePlayerInformations(@PathVariable Long id) {
        final var player = retrieveOnePlayerInformations.execute(id);
        return ResponseEntity.ok(playerMapper.mapToOnePlayerResponse(player));
    }

    @GetMapping("/average-bmi")
    public ResponseEntity<Double> getAverageBodyMassIndex() {
        return ResponseEntity.ok(findAveragePlayerBMI.execute());
    }
}
