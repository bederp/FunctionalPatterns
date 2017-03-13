package iterator.gof;

import java.util.Arrays;
import java.util.List;

public class IteratorExample {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        for (int i = 0; i <integers.size() ; i++) {
            System.out.println(integers.get(i));
        }

        for (Integer integer : integers) {
            System.out.println(integer);
        }


    }
}
