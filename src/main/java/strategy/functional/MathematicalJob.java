package strategy.functional;

@FunctionalInterface
interface MathematicalStrategy {
    //IntBinaryOperation
    int execute(int num1, int num2);
}

class MathematicalJob {
    private MathematicalStrategy strategy;

    MathematicalJob(MathematicalStrategy strategy) {
        this.strategy = strategy;
    }

    int execute(int num1, int num2) {
        return strategy.execute(num1, num2);
    }

    void setStrategy(MathematicalStrategy strategy) {
        this.strategy = strategy;
    }
}

class MathematicalJobExample {
    public static void main(String[] args) {
        MathematicalJob mathematicalJob = new MathematicalJob((x, y) -> x + y);
        System.out.println("Addition Strategy: " + mathematicalJob.execute(5, 7));

        mathematicalJob.setStrategy((x, y) -> x - y);
        System.out.println("Subtraction strategy " + mathematicalJob.execute(5, 7));
    }
}
