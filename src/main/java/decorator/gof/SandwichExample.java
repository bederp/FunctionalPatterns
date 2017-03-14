package decorator.gof;

interface Sandwich {
    String prepare();
}

class PlainSandwich implements Sandwich {

    @Override
    public String prepare() {
        return "Sandwich";
    }
}


abstract class SandwichDecorator implements Sandwich {
    Sandwich decoratedSandwich;
}

class SausageDecorator extends SandwichDecorator {

    SausageDecorator(Sandwich sandwich) {
        this.decoratedSandwich = sandwich;
    }

    @Override
    public String prepare() {
        return decoratedSandwich.prepare() + " with sausage";
    }
}

class CheeseDecorator extends SandwichDecorator {

    CheeseDecorator(Sandwich sandwich) {
        this.decoratedSandwich = sandwich;
    }

    @Override
    public String prepare() {
        return decoratedSandwich.prepare() + " with cheese";
    }
}

class SandwichExample {
    public static void main(String[] args) {
        final PlainSandwich plainSandwich = new PlainSandwich();
        final SausageDecorator sausageSandwich = new SausageDecorator(plainSandwich);
        final CheeseDecorator cheeseSausageSandwich = new CheeseDecorator(sausageSandwich);

        System.out.println(cheeseSausageSandwich.prepare());

    }
}
