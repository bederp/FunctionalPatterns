package strategy.gof;

interface MathematicalStrategy {
    int execute(int num1, int num2);
}

class Addition implements MathematicalStrategy {
    @Override
    public int execute(int num1, int num2) {
        return num1 + num2;
    }
}

class Subtraction implements MathematicalStrategy {
    @Override
    public int execute(int num1, int num2) {
        return num1 - num2;
    }
}
class MathematicalJob {
    private MathematicalStrategy strategy;

    MathematicalJob(MathematicalStrategy strategy){
        this.strategy = strategy;
    }

    int doTheJob(int num1, int num2){
        return strategy.execute(num1, num2);
    }

    void setStrategy(MathematicalStrategy strategy) {
        this.strategy = strategy;
    }
}

class MathematicalJobExample {
    public static void main(String[] args) {
        MathematicalJob mathematicalJob = new MathematicalJob(new Addition());
        System.out.println("Addition Strategy: " + mathematicalJob.doTheJob(5, 7));

        mathematicalJob.setStrategy(new Subtraction());
        System.out.println("Subtraction strategy " + mathematicalJob.doTheJob(5, 7));
    }
}