package visitor.functional;

import java.util.Arrays;
import java.util.function.Function;

import static visitor.functional.ClassPattern.inCaseOf;

class Circle {
    final int radius;

    Circle(int radius) {
        this.radius = radius;
    }
}

class Rectangle {
    final int width;
    final int height;

    Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
}

interface Pattern {
    boolean matches(Object value);

    Object apply(Object value);
}

class ClassPattern<T> implements Pattern {

    private Class<T> clazz;
    private Function<T, Object> function;

    private ClassPattern(Class<T> clazz, Function<T, Object> function) {
        this.clazz = clazz;
        this.function = function;
    }

    public boolean matches(Object value) {
        return clazz.isInstance(value);
    }

    public Object apply(Object value) {
        return function.apply((T) value);
    }

    static <T> Pattern inCaseOf(Class<T> clazz, Function<T, Object> function) {
        return new ClassPattern<>(clazz, function);
    }
}

class PatternMatching {
    private Pattern[] patterns;

    PatternMatching(Pattern... patterns) {
        this.patterns = patterns;
    }

    Object matchFor(Object value) {
        return Arrays.stream(patterns)
                .filter(x -> x.matches(value))
                .findFirst()
                .map(x -> x.apply(value))
                .orElseThrow(() -> new IllegalArgumentException("cannot match " + value));
    }
}

public class Visitor {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(2, 4);

        PatternMatching pm = new PatternMatching(
                inCaseOf(Circle.class, x -> System.out.printf("Area of circle with radius %d is %f\n", x.radius, Math.pow(x.radius, 2.0) * Math.PI)),
                inCaseOf(Rectangle.class, x -> System.out.printf("Area of rectangle with width %d and height %d is %d\n", x.width, x.height, x.width * x.height))
        );

        pm.matchFor(circle);
        pm.matchFor(rectangle);
    }
}
