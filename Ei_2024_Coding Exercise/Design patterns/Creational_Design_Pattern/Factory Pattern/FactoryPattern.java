import java.util.Scanner;

// Product Interface
interface HealthMonitor {
    void monitor();
}

// Concrete Products
class HeartRateMonitor implements HealthMonitor {
    @Override
    public void monitor() {
        System.out.println("Monitoring heart rate...");
    }
}

class BloodPressureMonitor implements HealthMonitor {
    @Override
    public void monitor() {
        System.out.println("Monitoring blood pressure...");
    }
}

class GlucoseMonitor implements HealthMonitor {
    @Override
    public void monitor() {
        System.out.println("Monitoring glucose levels...");
    }
}

// Creator (Factory)
abstract class HealthMonitorFactory {
    public abstract HealthMonitor createHealthMonitor();
}

// Concrete Creators
class HeartRateMonitorFactory extends HealthMonitorFactory {
    @Override
    public HealthMonitor createHealthMonitor() {
        return new HeartRateMonitor();
    }
}

class BloodPressureMonitorFactory extends HealthMonitorFactory {
    @Override
    public HealthMonitor createHealthMonitor() {
        return new BloodPressureMonitor();
    }
}

class GlucoseMonitorFactory extends HealthMonitorFactory {
    @Override
    public HealthMonitor createHealthMonitor() {
        return new GlucoseMonitor();
    }
}

// Factory Creator
class HealthMonitorFactoryCreator {
    public static HealthMonitorFactory getFactory(String monitorType) {
        switch (monitorType) {
            case "HeartRate":
                return new HeartRateMonitorFactory();
            case "BloodPressure":
                return new BloodPressureMonitorFactory();
            case "Glucose":
                return new GlucoseMonitorFactory();
            default:
                throw new IllegalArgumentException("Unknown monitor type");
        }
    }
}

// Demonstration
public class FactoryPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String monitorType;

        while (true) {
            System.out.println("Enter the type of health monitor (HeartRate, BloodPressure, Glucose) or 'exit' to quit:");
            monitorType = scanner.nextLine();

            if (monitorType.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                HealthMonitorFactory factory = HealthMonitorFactoryCreator.getFactory(monitorType);
                HealthMonitor monitor = factory.createHealthMonitor();
                monitor.monitor();
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid monitor type. Please enter 'HeartRate', 'BloodPressure', or 'Glucose'.");
            }
        }

        scanner.close();
    }
}
