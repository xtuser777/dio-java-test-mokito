package br.com.xt.dio.java;

import br.com.xt.dio.java.entities.LocationData;
import br.com.xt.dio.java.services.MailApi;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class MailApiTest {

    @Mock
    private MailApi api;

    @Test
    void returnObjectWhenPassedSpecifiedValue1() {
        when(api.searchLocationDataByPostalCode(anyString())).thenReturn(null);
        LocationData data = api.searchLocationDataByPostalCode("167161");
        assertNull(data);
    }

    void returnObjectWhenPassedSpecifiedValue2() {
        when(
            api.searchLocationDataByPostalCode("78787878"))
            .thenReturn(
                new LocationData(
                    "AM", "Manaus", "Rua Grajaúna", "casa", "Lago Azul"
                )
            );
        LocationData data = api.searchLocationDataByPostalCode("78787878");
        assertEquals("AM", data.getState());
    }
}
