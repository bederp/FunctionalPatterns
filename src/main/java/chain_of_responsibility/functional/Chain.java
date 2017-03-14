package chain_of_responsibility.functional;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

enum FruitType {BANANA, APPLE, PEACH, STRAWBERRY}

class Chain {
    private static Optional<String> parseBanana(FruitType fruit) {
//        System.out.println("B");
//        System.err.println("B");
        if (FruitType.BANANA.equals(fruit)) {
            return Optional.of("Handled a banana");
        } else {
            return Optional.empty();
        }
    }

    private static Optional<String> parseApple(FruitType fruit) {
//        System.out.println("A");
//        System.err.println("A");
        if (FruitType.APPLE.equals(fruit)) {
            return Optional.of("Handled an apple");
        } else {
            return Optional.empty();
        }
    }

    private static Optional<String> parsePeach(FruitType fruit) {
//        System.out.println("P");
//        System.err.println("P");
        if (FruitType.PEACH.equals(fruit)) {
            return Optional.of("Handled a peach");
        } else {
            return Optional.empty();
        }
    }

    public static void main(String[] args) {


        System.out.println(handle(FruitType.APPLE));
//        System.out.println(handle(FruitType.STRAWBERRY));


    }

    private static String handle(FruitType fruit) {
        //Sequentially ordered
        return Stream.<Function<FruitType, Optional<String>>>of(
                Chain::parseApple,
                Chain::parseBanana,
                Chain::parsePeach)
                .map(f -> f.apply(fruit))
                .filter(Optional::isPresent)
                .findFirst()
                .map(Optional::get)
                .orElseThrow(() -> new RuntimeException("No suitable handler"));
    }
}
