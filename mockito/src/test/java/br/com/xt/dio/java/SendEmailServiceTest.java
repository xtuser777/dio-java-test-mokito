package br.com.xt.dio.java;

import br.com.xt.dio.java.entities.Email;
import br.com.xt.dio.java.enums.EmailFormat;
import br.com.xt.dio.java.services.SendEmailService;
import br.com.xt.dio.java.services.SendPlatform;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SendEmailServiceTest {

    @Mock
    private SendPlatform platform;

    @InjectMocks
    private SendEmailService service;

    @Captor
    private ArgumentCaptor<Email> emailCaptor;

    @Test
    public void validaSeEmailEstaComDadosCorretos() {

        String email = "jose.alve@provedor.com";
        String mensagem = "Mensagem de Teste 123";

        service.sendEmail(email, mensagem, true);
        Mockito.verify(platform).sendEmail(emailCaptor.capture());

        Email emailCapturado = emailCaptor.getValue();
        Assertions.assertEquals(EmailFormat.HTML, emailCapturado.getFormat());
    }
}
