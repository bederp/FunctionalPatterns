package interpreter.functional;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.IntBinaryOperator;

interface MathExpression {
    Map<String, IntBinaryOperator> operationsMap = new HashMap<String, IntBinaryOperator>(){{
        put("+", (int a, int b) -> a+b);
        put("-", (int a, int b) -> a-b);
    }};
}

class Parser {
    private final Stack<Integer> stack = new Stack<>();

    int evaluate(String s) {
        for (String token : s.split(" ")) {
            IntBinaryOperator operation = MathExpression.operationsMap.get(token);
            if (operation != null) {
                stack.add(operation.applyAsInt(stack.pop(), stack.pop()));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}

class Interpreter {
    public static void main(String[] args) {
        String s = "1 2 3 4 - + -";
        System.out.println(new Parser().evaluate(s));
    }
}
