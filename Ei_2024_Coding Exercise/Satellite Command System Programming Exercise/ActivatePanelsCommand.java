public class ActivatePanelsCommand implements Command {
    private Satellite satellite;

    public ActivatePanelsCommand(Satellite satellite) {
        this.satellite = satellite;
    }

    @Override
    public void execute() {
        satellite.setSolarPanels("Active");
        Logger.log("Activated solar panels");
    }
}
