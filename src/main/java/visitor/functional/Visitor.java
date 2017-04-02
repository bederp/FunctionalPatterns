package visitor.functional;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.function.Function;

import static visitor.functional.ClassPattern.inCaseOf;

class Circle {
    final double radius;

    Circle(double radius) {
        this.radius = radius;
    }
}

class Rectangle {
    final double width;
    final double height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
}

interface Pattern {
    boolean matches(Object value);

    Object apply(Object value);
}

class ClassPattern<T> implements Pattern {

    private final Class<T> clazz;
    private final Function<T, Object> function;

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
    private final Pattern[] patterns;

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

class Visitor {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(2, 4);

        PatternMatching pm = new PatternMatching(
                inCaseOf(Circle.class, Visitor::circleVisitor),
                inCaseOf(Rectangle.class, Visitor::rectangleVisitor)
        );

        pm.matchFor(circle);
        pm.matchFor(rectangle);
    }

    private static PrintStream rectangleVisitor(Rectangle x) {
        return System.out.printf("Area of rectangle with width %.2f and height %.2f is %.2f%n", x.width, x.height, x.width * x.height);
    }

    private static PrintStream circleVisitor(Circle x) {
        return System.out.printf("Area of circle with radius %.2f is %.2f%n", x.radius, Math.pow(x.radius, 2.0) * Math.PI);
    }
}
