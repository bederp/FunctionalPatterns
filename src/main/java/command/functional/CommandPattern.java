package command.functional;

import java.util.ArrayList;
import java.util.List;

/**
 * The Command functional interface.<br/>
 */
@FunctionalInterface
interface Command {
    void execute();
}

/**
 * The Invoker class
 */
class Switch {
    private final List<Command> history = new ArrayList<>();

    void storeAndExecute(final Command cmd) {
        history.add(cmd); // optional "UNDO" functionality
        cmd.execute();
    }
}

/**
 * The Receiver class
 */
class Light {

    void turnOn() {
        System.out.println("The light is on");
    }

    void turnOff() {
        System.out.println("The light is off");
    }
}

final class CommandPattern {
    public static void main(final String[] arguments) {

        final Light lamp = new Light();
        final Switch mySwitch = new Switch();

        mySwitch.storeAndExecute(lamp::turnOff);
        mySwitch.storeAndExecute(lamp::turnOn);
    }
}