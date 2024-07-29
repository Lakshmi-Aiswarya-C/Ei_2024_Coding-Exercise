import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Prototype Interface
interface DevicePrototype {
    DevicePrototype clone();
}

// Concrete Prototype Class
class MedicalDevice implements DevicePrototype {
    private String deviceType;
    private String configuration;

    public MedicalDevice(String deviceType, String configuration) {
        this.deviceType = deviceType;
        this.configuration = configuration;
    }

    // Implementing clone method
    @Override
    public DevicePrototype clone() {
        return new MedicalDevice(deviceType, configuration);
    }

    @Override
    public String toString() {
        return "MedicalDevice{deviceType='" + deviceType + "', configuration='" + configuration + "'}";
    }

    // Additional methods to customize the device
    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }
}

// Prototype Registry
class DevicePrototypeRegistry {
    private Map<String, DevicePrototype> prototypes = new HashMap<>();

    public void addPrototype(String key, DevicePrototype prototype) {
        prototypes.put(key, prototype);
    }

    public DevicePrototype getPrototype(String key) {
        return prototypes.get(key).clone();
    }
}

// Demonstration
public class PrototypePattern {
    public static void main(String[] args) {
        DevicePrototypeRegistry registry = new DevicePrototypeRegistry();

        // Adding prototypes to the registry
        MedicalDevice heartRateMonitor = new MedicalDevice("Heart Rate Monitor", "Default HRM Configuration");
        MedicalDevice bloodPressureMonitor = new MedicalDevice("Blood Pressure Monitor", "Default BPM Configuration");

        registry.addPrototype("hrm", heartRateMonitor);
        registry.addPrototype("bpm", bloodPressureMonitor);

        // Scanner to read user input
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter device type (hrm for Heart Rate Monitor, bpm for Blood Pressure Monitor) or 'exit' to quit:");
            String deviceType = scanner.nextLine();

            if (deviceType.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.println("Enter custom configuration like[Custom HRM Configuration for Patient A]:");
            String customConfiguration = scanner.nextLine();

            MedicalDevice clonedDevice = (MedicalDevice) registry.getPrototype(deviceType);
            clonedDevice.setConfiguration(customConfiguration);

            // Displaying the cloned and customized device
            System.out.println(clonedDevice);
        }

        scanner.close();
    }
}
