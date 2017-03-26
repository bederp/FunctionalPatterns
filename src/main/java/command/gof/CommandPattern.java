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
class SwitchOnCommand implements Command {
    private final Light theLight;

    SwitchOnCommand(final Light light) {
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
class SwitchOffCommand implements Command {
    private final Light theLight;

    SwitchOffCommand(final Light light) {
        this.theLight = light;
    }

    @Override    // Command
    public void execute() {
        theLight.turnOff();
    }
}

/**
 *The test class or client
 */
class CommandPattern {
    public static void main(final String[] arguments) {

        final Light lamp = new Light();
        final Command switchOn = new SwitchOnCommand(lamp);
        final Command switchOff = new SwitchOffCommand(lamp);
        final Switch mySwitch = new Switch();

        mySwitch.storeAndExecute(switchOn);
        mySwitch.storeAndExecute(switchOff);
    }
}