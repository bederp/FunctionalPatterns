package chain_of_responsibility.functional;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by kinder112 on 12.02.2017.
 */

enum FruitType {
    BANANA, APPLE, PEACH, STRAWBERRY
}

public class Chain {
    private static Optional<String> parseBanana(FruitType fruit) {
//        System.out.println("B");
        if (FruitType.BANANA.equals(fruit)) {
            return Optional.of("Handled a banana");
        } else {
            return Optional.empty();
        }
    }

    private static Optional<String> parseApple(FruitType fruit) {
//        System.out.println("A");
        if (FruitType.APPLE.equals(fruit)) {
            return Optional.of("Handled an apple");
        } else {
            return Optional.empty();
        }
    }

    private static Optional<String> parsePeach(FruitType fruit) {
//        System.out.println("P");
        if (FruitType.PEACH.equals(fruit)) {
            return Optional.of("Handled a peach");
        } else {
            return Optional.empty();
        }
    }

    public static void main(String[] args) {

        String s = Stream.<Function<FruitType, Optional<String>>>of(
                Chain::parseApple,
                Chain::parseBanana,
                Chain::parsePeach)
                .map(f -> f.apply(FruitType.APPLE))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst().orElseThrow(() -> new RuntimeException("No suitable handler"));

        System.out.println(s);


    }
}
