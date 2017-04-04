package iterator.gof;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class IteratorExample {
    public static void main(String[] args) {
        Collection<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        for(Iterator<Integer> it = integers.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }

        //1.5
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
