package br.com.xt.dio.java;

import br.com.xt.dio.java.entities.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonTest {

    @Mock
    private Person person;

    @Test
    void choiceReturn() {
        when(person.getName()).thenReturn("Will");
        assertEquals("Will", person.getName());
    }

    @Test
    void choiceReturnOtherWay() {
        doReturn("Will").when(person).getName();
        assertEquals("Will", person.getName());
    }

    @Test
    void isAdult() {
        when(person.isAdult()).thenReturn(true);
        assertTrue(person.isAdult());
    }

    @Test
    void isAdultOtherWay() {
        doAnswer(invocation -> true).when(person).isAdult();
        assertTrue(person.isAdult());
    }
}
