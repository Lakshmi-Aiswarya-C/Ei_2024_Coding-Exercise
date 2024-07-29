import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Subsystem 1: Scan Management
class ScanManager {
    private Map<String, String> scanData = new HashMap<>();

    public void saveScan(String patientId, String data) {
        scanData.put(patientId, data);
        System.out.println("Saving scan for patient: " + patientId);
    }

    public String getScan(String patientId) {
        return scanData.getOrDefault(patientId, "No scan data for patient: " + patientId);
    }
}

// Subsystem 2: X-Ray Management
class XRayManager {
    private Map<String, String> xRayData = new HashMap<>();

    public void saveXRay(String patientId, String data) {
        xRayData.put(patientId, data);
        System.out.println("Saving X-Ray for patient: " + patientId);
    }

    public String getXRay(String patientId) {
        return xRayData.getOrDefault(patientId, "No X-Ray data for patient: " + patientId);
    }
}

// Subsystem 3: Test Report Management
class TestReportManager {
    private Map<String, String> reportData = new HashMap<>();

    public void saveTestReport(String patientId, String data) {
        reportData.put(patientId, data);
        System.out.println("Saving test report for patient: " + patientId);
    }

    public String getTestReport(String patientId) {
        return reportData.getOrDefault(patientId, "No test report data for patient: " + patientId);
    }
}

// Facade
class PatientRecordFacade {
    private ScanManager scanManager;
    private XRayManager xRayManager;
    private TestReportManager testReportManager;

    public PatientRecordFacade() {
        this.scanManager = new ScanManager();
        this.xRayManager = new XRayManager();
        this.testReportManager = new TestReportManager();
    }

    public void saveScan(String patientId, String scanData) {
        scanManager.saveScan(patientId, scanData);
    }

    public void saveXRay(String patientId, String xRayData) {
        xRayManager.saveXRay(patientId, xRayData);
    }

    public void saveTestReport(String patientId, String reportData) {
        testReportManager.saveTestReport(patientId, reportData);
    }

    public void saveAllRecords(String patientId, String scanData, String xRayData, String reportData) {
        saveScan(patientId, scanData);
        saveXRay(patientId, xRayData);
        saveTestReport(patientId, reportData);
        System.out.println("All records saved for patient: " + patientId);
    }

    public void getAllRecords(String patientId) {
        String scan = scanManager.getScan(patientId);
        String xRay = xRayManager.getXRay(patientId);
        String report = testReportManager.getTestReport(patientId);
        System.out.println("Retrieved records for patient: " + patientId);
        System.out.println(scan);
        System.out.println(xRay);
        System.out.println(report);
    }
}

// Demonstration
public class FacadePattern {
    public static void main(String[] args) {
        PatientRecordFacade facade = new PatientRecordFacade();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option: 1) Save Records 2) Get Records 3) Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (choice == 3) {
                break;
            }

            System.out.println("Enter patient ID:");
            String patientId = scanner.nextLine();

            if (choice == 1) {
                System.out.println("Enter scan data:");
                String scanData = scanner.nextLine();

                System.out.println("Enter X-Ray data:");
                String xRayData = scanner.nextLine();

                System.out.println("Enter test report data:");
                String reportData = scanner.nextLine();

                facade.saveAllRecords(patientId, scanData, xRayData, reportData);
            } else if (choice == 2) {
                facade.getAllRecords(patientId);
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
