import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class VirtualCareMain {
    private static Scanner scanner = new Scanner(System.in);

    private static List<Patient> patients;
    private static List<Provider> providers;
    private static List<Administrator> admins;
    private static List<Appointment> appointments;
    private static List<EHRRecord> records;
    private static List<Prescription> prescriptions;
    private static List<Billing> bills;
    private static List<Feedback> feedbacks;

    public static void main(String[] args) {
        loadAll();
        seedIfEmpty();
        mainMenu();
        saveAll();
        System.out.println("Exiting VirtualCare 2025. Goodbye!");
    }

    private static void loadAll() {
        patients = DataStore.load("patients.dat", List.class);
        providers = DataStore.load("providers.dat", List.class);
        admins = DataStore.load("admins.dat", List.class);
        appointments = DataStore.load("appointments.dat", List.class);
        records = DataStore.load("records.dat", List.class);
        prescriptions = DataStore.load("prescriptions.dat", List.class);
        bills = DataStore.load("bills.dat", List.class);
        feedbacks = DataStore.load("feedbacks.dat", List.class);
    }

    private static void saveAll() {
        DataStore.save(patients, "patients.dat");
        DataStore.save(providers, "providers.dat");
        DataStore.save(admins, "admins.dat");
        DataStore.save(appointments, "appointments.dat");
        DataStore.save(records, "records.dat");
        DataStore.save(prescriptions, "prescriptions.dat");
        DataStore.save(bills, "bills.dat");
        DataStore.save(feedbacks, "feedbacks.dat");
    }

    private static void seedIfEmpty() {
        if (admins.isEmpty()) {
            admins.add(new Administrator("A1", "Emma Admin", "emma@virtualcare.example"));
        }
        if (providers.isEmpty()) {
            Provider p1 = new Provider("P1", "Dr. Smith", "smith@clinic", "Cardiology");
            p1.addAvailability("2025-12-10 10:00");
            p1.addAvailability("2025-12-11 14:00");
            providers.add(p1);

            Provider p2 = new Provider("P2", "Nurse Lucy", "lucy@clinic", "Chronic Care");
            p2.addAvailability("2025-12-12 09:00");
            providers.add(p2);
        }
        if (patients.isEmpty()) {
            patients.add(new Patient("PT1", "John Patient", "john@example", "Hypertension"));
        }
    }

    private static void mainMenu() {
        while (true) {
            System.out.println("\n--- VirtualCare 2025 ---");
            System.out.println("1) Register Patient");
            System.out.println("2) List Providers");
            System.out.println("3) Book Appointment");
            System.out.println("4) List Appointments");
            System.out.println("5) Conduct Consultation");
            System.out.println("6) Pay Bill");
            System.out.println("7) Give Feedback");
            System.out.println("0) Exit");
            System.out.print("Choice: ");
            String choice = scanner.nextLine().trim();
            try {
                switch (choice) {
                    case "1": registerPatient(); break;
                    case "2": listProviders(); break;
                    case "3": bookAppointment(); break;
                    case "4": listAppointments(); break;
                    case "5": conductConsultation(); break;
                    case "6": payBill(); break;
                    case "7": giveFeedback(); break;
                    case "0": return;
                    default: System.out.println("Unknown choice");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void registerPatient() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter contact: ");
        String contact = scanner.nextLine();
        System.out.print("Enter medical history: ");
        String mh = scanner.nextLine();

        String id = "PT" + (patients.size() + 1);
        patients.add(new Patient(id, name, contact, mh));
        System.out.println("Patient registered: " + id);
    }

    private static void listProviders() {
        for (Provider p : providers) {
            System.out.println(p);
            System.out.println("  Availability: " + p.getAvailability());
        }
    }

    private static Provider findProvider(String id) {
        for (Provider p : providers) if (p.getId().equals(id)) return p;
        return null;
    }

    private static Patient findPatient(String id) {
        for (Patient p : patients) if (p.getId().equals(id)) return p;
        return null;
    }

    private static void bookAppointment() {
        System.out.print("Enter patient ID: ");
        String pid = scanner.nextLine();
        Patient patient = findPatient(pid);
        if (patient == null) { System.out.println("Patient not found"); return; }

        listProviders();
        System.out.print("Enter provider ID: ");
        String prid = scanner.nextLine();
        Provider provider = findProvider(prid);
        if (provider == null) { System.out.println("Provider not found"); return; }

        System.out.println("Available slots: " + provider.getAvailability());
        System.out.print("Choose slot (YYYY-MM-DD HH:MM): ");
        String slot = scanner.nextLine();

        if (!provider.getAvailability().contains(slot)) {
            System.out.println("Slot unavailable.");
            return;
        }

        String aid = "AP" + (appointments.size() + 1);
        LocalDateTime dt = LocalDateTime.parse(slot, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        appointments.add(new Appointment(aid, pid, prid, dt));

        System.out.println("Appointment booked: " + aid);
    }

    private static void listAppointments() {
        for (Appointment a : appointments) System.out.println(a);
    }

    private static Appointment findAppointment(String id) {
        for (Appointment a : appointments) if (a.getId().equals(id)) return a;
        return null;
    }

    private static Billing findBill(String id) {
        for (Billing b : bills) if (b.toString().contains(id)) return b;
        return null;
    }

    private static void conductConsultation() {
        System.out.print("Enter appointment ID: ");
        String aid = scanner.nextLine();
        Appointment ap = findAppointment(aid);
        if (ap == null) { System.out.println("Not found"); return; }

        System.out.print("Diagnosis: ");
        String d = scanner.nextLine();
        System.out.print("Notes: ");
        String n = scanner.nextLine();

        String rid = "R" + (records.size() + 1);
        EHRRecord r = new EHRRecord(rid, ap.getPatientId(), ap.getProviderId(), d, n);
        records.add(r);

        System.out.print("Issue prescription? (y/n): ");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            System.out.print("Medication: ");
            String med = scanner.nextLine();
            System.out.print("Instructions: ");
            String ins = scanner.nextLine();
            prescriptions.add(new Prescription("RX" + (prescriptions.size() + 1), ap.getPatientId(), ap.getProviderId(), med, ins));
            bills.add(new Billing("B" + (bills.size() + 1), ap.getPatientId(), 50));
        }

        ap.setCompleted(true);
        System.out.println("Consultation complete.");
    }

    private static void payBill() {
        System.out.print("Bill ID: ");
        Billing b = findBill(scanner.nextLine());
        if (b == null) { System.out.println("Not found"); return; }
        b.pay();
        System.out.println("Paid.");
    }

    private static void giveFeedback() {
        System.out.print("Enter patient ID: ");
        String pid = scanner.nextLine();
        System.out.print("Enter provider ID: ");
        String prid = scanner.nextLine();
        System.out.print("Rating (1-5): ");
        int rate = Integer.parseInt(scanner.nextLine());
        System.out.print("Comment: ");
        String com = scanner.nextLine();
        feedbacks.add(new Feedback("F" + (feedbacks.size() + 1), pid, prid, rate, com));
    }
}
