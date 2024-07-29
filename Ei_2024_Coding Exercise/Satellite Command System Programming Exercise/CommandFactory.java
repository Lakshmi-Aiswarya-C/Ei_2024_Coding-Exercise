public class CommandFactory {
    public static Command createCommand(String type, Satellite satellite, String direction) {
        switch (type) {
            case "rotate":
                return new RotateCommand(satellite, direction);
            case "activatePanels":
                return new ActivatePanelsCommand(satellite);
            case "deactivatePanels":
                return new DeactivatePanelsCommand(satellite);
            case "collectData":
                return new CollectDataCommand(satellite);
            default:
                throw new IllegalArgumentException("Invalid command type");
        }
    }
}
