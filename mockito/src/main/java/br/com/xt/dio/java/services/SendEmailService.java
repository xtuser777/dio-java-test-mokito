package br.com.xt.dio.java.services;

import br.com.xt.dio.java.enums.EmailFormat;
import br.com.xt.dio.java.entities.Email;

public class SendEmailService {

    private SendPlatform platform;

    public void sendEmail(String address, String message, boolean htmlFormat) {
        Email email;

        if (htmlFormat) {
            email = new Email(address, message, EmailFormat.HTML);
        } else {
            email = new Email(address, message, EmailFormat.TEXT);
        }

        platform.sendEmail(email);
    }
}
