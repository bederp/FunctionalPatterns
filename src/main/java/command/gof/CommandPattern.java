package command.gof;

import java.util.List;
import java.util.ArrayList;

interface Command {
    void execute();
}

class Switch {
    private final List<Command> history = new ArrayList<>();

    void storeAndExecute(final Command cmd) {
        history.add(cmd); // optional
        cmd.execute();
    }
}

class Light {
    void turnOn() {
        System.out.println("The light is on");
    }
    void turnOff() {
        System.out.println("The light is off");
    }
}

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

class CommandPattern {
    public static void main(final String[] arguments) {

        final Light lamp = new Light();
        final Command switchOn = new SwitchOnCommand(lamp);
        final Command switchOff = new SwitchOffCommand(lamp);
        final Switch aSwitch = new Switch();

        aSwitch.storeAndExecute(switchOff);
        aSwitch.storeAndExecute(switchOn);
    }
}