import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        VirtualCareSystem sys = new VirtualCareSystem();

        while (true) {
            System.out.println("\n===== VirtualCare 2025 =====");
            System.out.println("1. Register as Patient");
            System.out.println("2. Login as Patient");
            System.out.println("3. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                sys.registerPatient();
            }

            else if (choice == 2) {
                Patient p = sys.loginPatient();

                if (p != null) {
                    boolean logged = true;

                    while (logged) {
                        System.out.println("\n---- Patient Menu ----");
                        System.out.println("1. View Providers");
                        System.out.println("2. Book Appointment");
                        System.out.println("3. Give Feedback");
                        System.out.println("4. Logout");

                        int c = sc.nextInt();
                        sc.nextLine();

                        if (c == 1) sys.listProviders();
                        else if (c == 2) sys.bookAppointment(p);
                        else if (c == 3) p.giveFeedback();
                        else if (c == 4) logged = false;
                    }
                }
            }

            else if (choice == 3) {
                System.out.println("Goodbye!");
                break;
            }
        }
    }
}
