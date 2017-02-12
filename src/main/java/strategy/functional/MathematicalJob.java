package strategy.functional;

/**
 * Created by kinder112 on 05.02.2017.
 */

@FunctionalInterface
interface MathematicalStrategy {
    //BinaryOperator<Integer>
    int execute(int num1, int num2);
}

class Context {
    private MathematicalStrategy strategy;

    Context(MathematicalStrategy strategy) {
        this.strategy = strategy;
    }

    int execute(int num1, int num2) {
        return strategy.execute(num1, num2);
    }

    void setStrategy(MathematicalStrategy strategy) {
        this.strategy = strategy;
    }
}

public class MathematicalJob {

    public static void main(String[] args) {
        Context context = new Context((x, y) -> x + y);
        System.out.println("Addition Strategy: " + context.execute(5, 7));

        context.setStrategy((x, y) -> x - y);
        System.out.println("Subtraction strategy " + context.execute(5, 7));
    }

}
