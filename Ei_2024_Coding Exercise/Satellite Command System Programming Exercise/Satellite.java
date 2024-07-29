public class Satellite {
    private String orientation = "North";
    private String solarPanels = "Inactive";
    private int dataCollected = 0;

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public void setSolarPanels(String status) {
        this.solarPanels = status;
    }

    public void collectData() {
        if ("Active".equals(solarPanels)) {
            dataCollected += 10;
        }
    }

    public int getDataCollected() {
        return dataCollected;
    }

    @Override
    public String toString() {
        return "Satellite{" +
                "orientation='" + orientation + '\'' +
                ", solarPanels='" + solarPanels + '\'' +
                ", dataCollected=" + dataCollected +
                '}';
    }
}
