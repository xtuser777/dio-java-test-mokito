package br.com.xt.dio.java;

import br.com.xt.dio.java.entities.Email;
import br.com.xt.dio.java.enums.EmailFormat;
import br.com.xt.dio.java.services.SendPlatform;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SendPlatformTest {

    @Mock
    private SendPlatform sendPlatform;

    @Test
    void sendEmailTentativeWithFail() {
        Mockito.doThrow(IllegalStateException.class)
                .when(sendPlatform)
                .sendEmail(Mockito.any());

        Assertions
            .assertThrows(
                IllegalStateException.class,
                () -> sendPlatform.sendEmail(
                        new Email("teste@teste.org", "Teste", EmailFormat.TEXT)
                )
            );
    }
}
