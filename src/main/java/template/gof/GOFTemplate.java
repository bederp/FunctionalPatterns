package template.gof;

/**
 * Created by kinder112 on 05.02.2017.
 */

abstract class CookingTemplate{
    void cook(){
        prepareIngredients();
        cookIngredients();
        cleanup();
    }

    abstract void prepareIngredients();

    private void cookIngredients() {
        System.out.println("Cooking prepared ingredients");
    }

    private void cleanup() {
        System.out.println("Cleaning up the mess");
    }
}

class CookChicken extends CookingTemplate {

    @Override
    void prepareIngredients() {
        System.out.println("Grabbing chicken");
    }
}

class CookEggs extends CookingTemplate {

    @Override
    void prepareIngredients() {
        System.out.println("Grabbing eggs");
    }
}


public class GOFTemplate {
    public static void main(String[] args) {

        final CookChicken chicken = new CookChicken();
        chicken.cook();

        final CookEggs eggs = new CookEggs();
        eggs.cook();

    }
}
