package template.functional;

class FunctionalTemplate {

    private static void cook(Runnable r){
        r.run();
        System.out.println("Cooking prepared ingredients");
        System.out.println("Cleaning up the mess");
    }

    public static void main(String[] args) {
        cook(() -> System.out.println("Grabbing chicken"));
        cook(() -> System.out.println("Grabbing eggs"));

    }
}
