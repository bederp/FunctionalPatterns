package iterator.functional;

import java.util.Arrays;
import java.util.List;

class IteratorExample {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        integers.stream().forEach(i -> System.out.println(i));

        integers.stream().forEach(System.out::println);

        //careful this is different semantically
        integers.forEach(System.out::println);
    }
}
