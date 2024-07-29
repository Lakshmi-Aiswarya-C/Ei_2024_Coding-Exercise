public class DeactivatePanelsCommand implements Command {
    private Satellite satellite;

    public DeactivatePanelsCommand(Satellite satellite) {
        this.satellite = satellite;
    }

    @Override
    public void execute() {
        satellite.setSolarPanels("Inactive");
        Logger.log("Deactivated solar panels");
    }
}
