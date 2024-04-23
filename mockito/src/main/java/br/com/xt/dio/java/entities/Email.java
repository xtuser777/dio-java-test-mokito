package br.com.xt.dio.java.entities;

import br.com.xt.dio.java.enums.EmailFormat;

public class Email {

    private String address;
    private String message;
    private EmailFormat format;

    public Email(String address, String message, EmailFormat format) {
        this.address = address;
        this.message = message;
        this.format = format;
    }

    public String getAddress() {
        return address;
    }

    public String getMessage() {
        return message;
    }

    public EmailFormat getFormat() {
        return format;
    }
}
