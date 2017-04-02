package strategy.functional;

@FunctionalInterface
interface MathematicalStrategy {
    //IntBinaryOperation
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

class MathematicalJob {
    public static void main(String[] args) {
        Context context = new Context((x, y) -> x + y);
        System.out.println("Addition Strategy: " + context.execute(5, 7));

        context.setStrategy((x, y) -> x - y);
        System.out.println("Subtraction strategy " + context.execute(5, 7));
    }
}
