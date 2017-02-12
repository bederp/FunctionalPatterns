package template.functional;

/**
 * Created by kinder112 on 05.02.2017.
 */

public class FunctionalTemplate {

    static void cook(Runnable r){
        r.run();
        System.out.println("Cooking prepared ingredients");
        System.out.println("Cleaning up the mess");
    }

    public static void main(String[] args) {
        cook(() -> System.out.println("Grabbing chicken"));
        cook(() -> System.out.println("Grabbing eggs"));

    }
}
