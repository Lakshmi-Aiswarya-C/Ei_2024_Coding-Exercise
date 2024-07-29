import java.util.Scanner;

public class CommandLineInterface {
    private CommandManager commandManager = new CommandManager();
    private Satellite satellite = new Satellite();

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter command (rotate <direction>, activatePanels, deactivatePanels, collectData) or 'exit' to quit:");
            String input = scanner.nextLine();
            Logger.log("User input: " + input);

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            processCommand(input);
        }

        commandManager.executeCommands();
        System.out.println(satellite);
        Logger.log("Final satellite state: " + satellite);
        scanner.close();
    }

    private void processCommand(String input) {
        String[] parts = input.split(" ");
        if (parts.length == 0) {
            System.out.println("Invalid command. Please try again.");
            Logger.log("Invalid command received");
            return;
        }

        String commandType = parts[0];
        String direction = parts.length > 1 ? parts[1] : "";

        try {
            Command command = CommandFactory.createCommand(commandType, satellite, direction);
            if (command != null) {
                commandManager.addCommand(command);
            } else {
                System.out.println("Invalid command type. Please try again.");
                Logger.log("Invalid command type received: " + commandType);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            Logger.log("Exception: " + e.getMessage());
        }
    }
}
