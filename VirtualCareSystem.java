import java.util.*;

public class VirtualCareSystem {

    private ArrayList<Patient> patients = new ArrayList<>();
    private ArrayList<HealthProvider> providers = new ArrayList<>();
    private ArrayList<Appointment> appointments = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    public VirtualCareSystem() {
        // Sample data
        providers.add(new HealthProvider("PR1", "Dr. Smith", "123", "Cardiology", true));
        providers.add(new HealthProvider("PR2", "Nurse Lucy", "123", "Chronic Care", true));
    }

    public void registerPatient() {
        System.out.print("Enter username: ");
        String u = sc.nextLine();
        System.out.print("Enter password: ");
        String p = sc.nextLine();
        System.out.print("Enter phone: ");
        int phone = sc.nextInt();
        sc.nextLine();

        Patient newp = new Patient("P" + (patients.size()+1), u, p, "R1", phone);
        patients.add(newp);

        System.out.println("Registered successfully! ID: " + newp.getId());
    }

    public Patient loginPatient() {
        System.out.print("Enter username: ");
        String u = sc.nextLine();
        System.out.print("Enter password: ");
        String p = sc.nextLine();

        for (Patient pa : patients) {
            if (pa.login(u, p)) {
                System.out.println("Login successful!");
                return pa;
            }
        }
        System.out.println("Invalid login.");
        return null;
    }

    public void listProviders() {
        System.out.println("\n--- AVAILABLE PROVIDERS ---");
        for (HealthProvider hp : providers) {
            System.out.println(hp.getId() + " | " + hp.getUsername() + " | Specialty: " + hp.getSpecialty());
        }
    }

    public void bookAppointment(Patient p) {
        listProviders();
        System.out.print("Enter Provider ID: ");
        String pid = sc.nextLine();
        System.out.print("Enter date: ");
        String dt = sc.nextLine();

        Appointment a = new Appointment("A" + (appointments.size()+1), dt, p.getId(), pid);
        appointments.add(a);

        System.out.println("Appointment booked!");
        a.showAppointment();
    }
}
