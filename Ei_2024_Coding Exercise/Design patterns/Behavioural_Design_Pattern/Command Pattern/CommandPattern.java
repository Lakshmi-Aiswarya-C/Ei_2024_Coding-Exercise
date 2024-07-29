import java.util.Scanner;

// Command Interface
interface Command {
    void execute();
}

// Receiver Class
class WearableDevice {
    public void startMonitoring() {
        System.out.println("Device: Start Monitoring");
    }

    public void stopMonitoring() {
        System.out.println("Device: Stop Monitoring");
    }
}

// Concrete Command Classes
class StartMonitoringCommand implements Command {
    private WearableDevice device;

    public StartMonitoringCommand(WearableDevice device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.startMonitoring();
    }
}

class StopMonitoringCommand implements Command {
    private WearableDevice device;

    public StopMonitoringCommand(WearableDevice device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.stopMonitoring();
    }
}

// Invoker Class
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        if (command != null) {
            command.execute();
        } else {
            System.out.println("No command set");
        }
    }
}

// Demonstration
public class CommandPattern {
    public static void main(String[] args) {
        WearableDevice device = new WearableDevice();
        Command startCommand = new StartMonitoringCommand(device);
        Command stopCommand = new StopMonitoringCommand(device);

        RemoteControl remote = new RemoteControl();
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Enter a command (start, stop, exit):");
        while (true) {
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            } else if (input.equalsIgnoreCase("start")) {
                remote.setCommand(startCommand);
                remote.pressButton();
            } else if (input.equalsIgnoreCase("stop")) {
                remote.setCommand(stopCommand);
                remote.pressButton();
            } else {
                System.out.println("Invalid command. Please enter 'start', 'stop', or 'exit'.");
            }
        }

        scanner.close();
    }
}
