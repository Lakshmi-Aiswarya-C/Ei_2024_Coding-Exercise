import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Observer {
    void update(String status);
}

class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notify(String status) {
        for (Observer observer : observers) {
            observer.update(status);
        }
    }
}

class WearableDevice extends Subject {
    private String status;

    public void setStatus(String status) {
        this.status = status;
        notify(status);
    }
}

class HealthcareProvider implements Observer {
    private String name;

    public HealthcareProvider(String name) {
        this.name = name;
    }

    @Override
    public void update(String status) {
        System.out.println(name + " received status update: " + status);
    }
}

class CentralSystem implements Observer {
    @Override
    public void update(String status) {
        System.out.println("Central System received status update: " + status);
    }
}

// Demonstration
public class ObserverPattern {
    public static void main(String[] args) {
        WearableDevice device = new WearableDevice();
        HealthcareProvider doctor = new HealthcareProvider("Doctor");
        CentralSystem centralSystem = new CentralSystem();

        device.attach(doctor);
        device.attach(centralSystem);

        Scanner scanner = new Scanner(System.in);
        String input;
        
        System.out.println("Enter status updates (type 'exit' to quit):");
        while (true) {
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            device.setStatus(input);
        }

        scanner.close();
    }
}
