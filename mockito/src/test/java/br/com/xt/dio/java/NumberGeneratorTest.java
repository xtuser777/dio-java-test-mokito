package br.com.xt.dio.java;

import br.com.xt.dio.java.utilities.NumberGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
public class NumberGeneratorTest {

    @Test
    void numberListGenerationValidate() {
        MockedStatic<NumberGenerator> gerador = Mockito.mockStatic(NumberGenerator.class);
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        gerador.when(() -> NumberGenerator.generate(anyInt()))
                .thenReturn(integers);
        Assertions.assertEquals(integers, NumberGenerator.generate(8));
    }

    @Test
    void numberListGenerationValidateWithoutLength() {
        MockedStatic<NumberGenerator> gerador = Mockito.mockStatic(NumberGenerator.class);
        List<Integer> integers = List.of(10, 9, 8, 6);
        gerador.when(NumberGenerator::generate).thenReturn(integers);
        Assertions.assertEquals(integers, NumberGenerator.generate());
    }
}
