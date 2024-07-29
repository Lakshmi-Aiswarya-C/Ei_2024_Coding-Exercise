import java.util.Scanner;

// Target Interface
interface HealthDataAPI {
    void getHeartRateData();
    void getBloodPressureData();
}

// Adaptee 1: Third-Party API A
class ThirdPartyAPIA {
    public void fetchHeartRate() {
        System.out.println("Fetching heart rate from Third-Party API A...");
    }

    public void fetchBloodPressure() {
        System.out.println("Fetching blood pressure from Third-Party API A...");
    }
}

// Adaptee 2: Third-Party API B
class ThirdPartyAPIB {
    public void retrieveHeartRate() {
        System.out.println("Retrieving heart rate from Third-Party API B...");
    }

    public void retrieveBloodPressure() {
        System.out.println("Retrieving blood pressure from Third-Party API B...");
    }
}

// Adapter for Third-Party API A
class APIAAdapter implements HealthDataAPI {
    private ThirdPartyAPIA apiA;

    public APIAAdapter(ThirdPartyAPIA apiA) {
        this.apiA = apiA;
    }

    @Override
    public void getHeartRateData() {
        apiA.fetchHeartRate();
    }

    @Override
    public void getBloodPressureData() {
        apiA.fetchBloodPressure();
    }
}

// Adapter for Third-Party API B
class APIBAdapter implements HealthDataAPI {
    private ThirdPartyAPIB apiB;

    public APIBAdapter(ThirdPartyAPIB apiB) {
        this.apiB = apiB;
    }

    @Override
    public void getHeartRateData() {
        apiB.retrieveHeartRate();
    }

    @Override
    public void getBloodPressureData() {
        apiB.retrieveBloodPressure();
    }
}

// Demonstration
public class AdapterPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select API to fetch health data:");
        System.out.println("1. Third-Party API A");
        System.out.println("2. Third-Party API B");

        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        HealthDataAPI healthDataAPI = null;

        switch (choice) {
            case 1:
                ThirdPartyAPIA apiA = new ThirdPartyAPIA();
                healthDataAPI = new APIAAdapter(apiA);
                break;
            case 2:
                ThirdPartyAPIB apiB = new ThirdPartyAPIB();
                healthDataAPI = new APIBAdapter(apiB);
                break;
            default:
                System.out.println("Invalid choice");
                System.exit(0);
        }

        System.out.println("Fetching health data...");
        healthDataAPI.getHeartRateData();
        healthDataAPI.getBloodPressureData();

        scanner.close();
    }
}
