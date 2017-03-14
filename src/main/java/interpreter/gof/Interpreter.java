package interpreter.gof;

import java.util.Stack;

interface MathExpression {
    int evaluate();
}

class Addition implements MathExpression {

    private final int value;

    Addition(MathExpression left, MathExpression right) {
        value = left.evaluate() + right.evaluate();
    }

    @Override
    public int evaluate() {
        return value;
    }
}

class Subtraction implements MathExpression {
    private final int value;

    Subtraction(MathExpression left, MathExpression right) {
        value = left.evaluate() - right.evaluate();
    }

    @Override
    public int evaluate() {
        return value;
    }
}

class Value implements MathExpression {
    private final int value;

    Value(int value) {
        this.value = value;
    }

    @Override
    public int evaluate() {
        return value;
    }
}

class Parser {
    private final Stack<MathExpression> stack = new Stack<>();

    int evaluate(String s) {
        for (String token : s.split(" ")) {
            operatorLookup(token);
        }
        return stack.pop().evaluate();
    }

    private void operatorLookup(String token) {
        switch (token) {
            case "+":
                stack.add(new Addition(stack.pop(), stack.pop()));
                break;
            case "-":
                stack.add(new Subtraction(stack.pop(), stack.pop()));
                break;
            default:
                stack.add(new Value(Integer.parseInt(token)));
                break;
        }
    }
}

class Interpreter {
    public static void main(String[] args) {
        String s = "1 2 3 4 - + -";
        System.out.println(new Parser().evaluate(s));
    }
}
