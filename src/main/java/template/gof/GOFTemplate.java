package template.gof;

abstract class CookingTemplate{
    void cook(){
        prepareIngredients();
        cookIngredients();
        cleanUp();
    }

    abstract void prepareIngredients();

    private void cookIngredients() {
        System.out.println("Cooking prepared ingredients");
    }

    private void cleanUp() {
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


class GOFTemplate {
    public static void main(String[] args) {

        final CookChicken chicken = new CookChicken();
        chicken.cook();

        final CookEggs eggs = new CookEggs();
        eggs.cook();
    }
}
