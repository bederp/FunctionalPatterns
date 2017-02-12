package decorator.functional;

import java.util.function.UnaryOperator;

/**
 * Created by kinder112 on 07.02.2017.
 */

interface Sandwich {
    String prepare();
}

class PlainSandwich implements Sandwich {

    @Override
    public String prepare() {
        return "Sandwich";
    }
}

public class SandwichExample {

    private static class SandwichDecorator implements UnaryOperator<String> {
        @Override
        public String apply(String s) {
            return s;
        }
    }

    public static void main(String[] args) {
        System.out.println(
                new SandwichDecorator()
                        .andThen(s -> s + " with sausage")
                        .andThen(s -> s + " with cheese")
                        .apply(new PlainSandwich().prepare())
        );

    }
}
