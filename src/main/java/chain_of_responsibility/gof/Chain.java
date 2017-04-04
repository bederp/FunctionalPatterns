package chain_of_responsibility.gof;

enum FruitType {BANANA, APPLE, PEACH, STRAWBERRY}

abstract class FruitParser {
    private FruitParser successor;

    void handleFruit(FruitType fruit){
        if (canHandle(fruit)) {
            handle(fruit);
        } else if (successor != null){
            successor.handleFruit(fruit);
        } else {
            throw new RuntimeException("No suitable handler in chain");
        }
    }

    abstract boolean canHandle(FruitType fruit);

    abstract void handle(FruitType fruit);

    void setSuccessor(FruitParser successor) {
        this.successor = successor;
    }
}

class BananaParser extends FruitParser {
    @Override
    boolean canHandle(FruitType fruit) {
        return FruitType.BANANA.equals(fruit);
    }

    @Override
    void handle(FruitType fruit) {
        System.out.println("Handled a banana");
    }
}

class AppleParser extends FruitParser {
    @Override
    boolean canHandle(FruitType fruit) {
        return FruitType.APPLE.equals(fruit);
    }

    @Override
    void handle(FruitType fruit) {
        System.out.println("Handled an apple");
    }
}

class PeachParser extends FruitParser {
    @Override
    boolean canHandle(FruitType fruit) {
        return FruitType.PEACH.equals(fruit);
    }

    @Override
    void handle(FruitType fruit) {
        System.out.println("Handled a peach");
    }
}

class Chain {
    public static void main(String[] args) {
        FruitParser apple = new AppleParser();
        FruitParser banana = new BananaParser();
        FruitParser peach = new PeachParser();

        apple.setSuccessor(banana);
        banana.setSuccessor(peach);

        banana.handleFruit(FruitType.APPLE);
//        banana.handleFruit(FruitType.STRAWBERRY);
    }
}
