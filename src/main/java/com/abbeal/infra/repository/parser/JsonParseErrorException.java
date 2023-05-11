package com.abbeal.infra.repository.parser;

public class JsonParseErrorException extends RuntimeException {
    public JsonParseErrorException() {
        super("Error when parsing json file.");
    }
}
