package br.com.xt.dio.java.utilities;

import java.util.List;
import java.util.SplittableRandom;
import java.util.stream.Collectors;

public class NumberGenerator {

    private static SplittableRandom random = new SplittableRandom();

    private NumberGenerator(){
    }

    public static List<Integer> generate(int length) {
        return random.ints().boxed().limit(length).collect(Collectors.toList());
    }

    public static List<Integer> generate() {
        return random.ints().boxed().limit(random.nextInt(10)).collect(Collectors.toList());
    }
}
