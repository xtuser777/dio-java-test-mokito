package br.com.xt.dio.java;

import br.com.xt.dio.java.entities.Message;
import br.com.xt.dio.java.services.SendMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SendMessageTest {

    @Spy
    private SendMessage sendMessage = new SendMessage();

    @Test
    void addMessage() {
        Message msg = new Message("Hello world!");
        sendMessage.adicionarMensagem(msg);
        Mockito.verify(sendMessage).adicionarMensagem(msg);
        Assertions.assertEquals(1, sendMessage.getMessages().size());
    }
}
