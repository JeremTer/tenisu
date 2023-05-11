package com.abbeal.usecase.exceptions;

public class UnknownPlayerException extends RuntimeException {
    public UnknownPlayerException() {
        super("This player does not exist.");
    }
}
