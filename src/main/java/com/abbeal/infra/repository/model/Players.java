package com.abbeal.infra.repository.model;

import java.util.List;

public class Players {
    private List<PlayerJson> players;

    public List<PlayerJson> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerJson> players) {
        this.players = players;
    }
}
