package command.gof;

import java.util.List;
import java.util.ArrayList;

/**
 * The Command interface
 */
interface Command {
    void execute();
}

/**
 * The Invoker class
 */
class Switch {
    private final List<Command> history = new ArrayList<>();

    void storeAndExecute(final Command cmd) {
        history.add(cmd); // optional
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

/**
 * The Command for turning on the light - ConcreteCommand #1
 */
class FlipUpCommand implements Command {
    private final Light theLight;

    FlipUpCommand(final Light light) {
        this.theLight = light;
    }

    @Override    // Command
    public void execute() {
        theLight.turnOn();
    }
}

/**
 * The Command for turning off the light - ConcreteCommand #2
 */
class FlipDownCommand implements Command {
    private final Light theLight;

    FlipDownCommand(final Light light) {
        this.theLight = light;
    }

    @Override    // Command
    public void execute() {
        theLight.turnOff();
    }
}

/* The test class or client */
class PressSwitch {
    public static void main(final String[] arguments) {

        final Light lamp = new Light();
        final Command switchUp = new FlipUpCommand(lamp);
        final Command switchDown = new FlipDownCommand(lamp);
        final Switch mySwitch = new Switch();

        mySwitch.storeAndExecute(switchUp);
        mySwitch.storeAndExecute(switchDown);
    }
}