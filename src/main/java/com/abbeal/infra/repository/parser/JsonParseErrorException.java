package com.abbeal.infra.repository.parser;

public class JsonParseErrorException extends RuntimeException {
    public JsonParseErrorException(Exception e) {
        super("Error when parsing json file." + e.getMessage());
    }
}
