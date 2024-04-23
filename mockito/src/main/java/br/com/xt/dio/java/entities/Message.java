package br.com.xt.dio.java.entities;

import java.util.UUID;

public class Message {

    private String id;
    private String message;

    public Message(final String message) {
        this.id = UUID.randomUUID().toString();;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
