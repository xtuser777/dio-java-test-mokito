package br.com.xt.dio.java.services;

import br.com.xt.dio.java.entities.Message;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SendMessage {

    private List<Message> messages = new ArrayList<>();

    public void adicionarMensagem(Message message) {
        this.messages.add(message);
    }

    public List<Message> getMessages() {
        return Collections.unmodifiableList(this.messages);
    }
}
