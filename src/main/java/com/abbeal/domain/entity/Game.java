package com.abbeal.domain.entity;

import java.time.LocalDateTime;

public record Game(Player winner, Player loser, LocalDateTime date) {

}
