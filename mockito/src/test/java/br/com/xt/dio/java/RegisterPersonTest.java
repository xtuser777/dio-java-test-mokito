package br.com.xt.dio.java;

import br.com.xt.dio.java.entities.LocationData;
import br.com.xt.dio.java.entities.Person;
import br.com.xt.dio.java.services.MailApi;
import br.com.xt.dio.java.services.RegisterPerson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
public class RegisterPersonTest {

    @Mock
    private MailApi mailApi;

    @InjectMocks
    private RegisterPerson service;

    @Test
    void register() {
        LocationData address = new LocationData(
            "MG", "Uberaba", "Rua Castro Alves", "Casa", "Nova Floresta"
        );
        Mockito.when(mailApi.searchLocationDataByPostalCode(anyString())).thenReturn(address);
        Person john = service
            .register(
                "John", "28578527976", LocalDate.of(1947, 1, 15), "69317300"
            );
        LocationData johnAddress = john.getAddress();
        assertEquals(address.getNeighborhood(), johnAddress.getNeighborhood());
        assertEquals(address.getCity(), johnAddress.getCity());
        assertEquals(address.getState(), johnAddress.getState());
    }

    @Test
    void registerTentativeWithMailApiFail() {
        Mockito.when(mailApi.searchLocationDataByPostalCode(anyString())).thenThrow(RuntimeException.class);
        Assertions.assertThrows(
                RuntimeException.class,
                () -> service
                    .register(
                        "John", "28578527976", LocalDate.of(1947, 1, 15), "69317300"
                    )
        );
    }
}
