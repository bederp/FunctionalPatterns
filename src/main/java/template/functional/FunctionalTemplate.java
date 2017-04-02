package template.functional;

class FunctionalTemplate {

    private static void cook(Runnable r){
        r.run();
        cookIngredients();
        cleanUp();
    }

    private static void cleanUp() {
        System.out.println("Cleaning up the mess");
    }

    private static void cookIngredients() {
        System.out.println("Cooking prepared ingredients");
    }

    public static void main(String[] args) {
        cook(() -> System.out.println("Grabbing chicken"));
        cook(() -> System.out.println("Grabbing eggs"));

    }
}
