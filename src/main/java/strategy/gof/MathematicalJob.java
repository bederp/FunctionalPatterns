package strategy.gof;

/**
 * Created by kinder112 on 05.02.2017.
 */

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
class Context {
    private MathematicalStrategy strategy;

    Context(MathematicalStrategy strategy){
        this.strategy = strategy;
    }

    int doTheJob(int num1, int num2){
        return strategy.execute(num1, num2);
    }

    void setStrategy(MathematicalStrategy strategy) {
        this.strategy = strategy;
    }
}

public class MathematicalJob {

    public static void main(String[] args) {
        Context context = new Context(new Addition());
        System.out.println("Addition Strategy: " + context.doTheJob(5, 7));

        context.setStrategy(new Subtraction());
        System.out.println("Subtraction strategy " + context.doTheJob(5, 7));
    }

}
