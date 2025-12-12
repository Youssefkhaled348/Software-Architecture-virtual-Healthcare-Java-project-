public class Patient extends User {

    private String recordID;
    private int phone;

    public Patient(String id, String username, String password, String recordID, int phone) {
        super(id, username, password);
        this.recordID = recordID;
        this.phone = phone;
    }

    public void viewProviders() {
        System.out.println("Listing providers...");
    }

    public void bookAppointment() {
        System.out.println("Appointment booked.");
    }

    public void giveFeedback() {
        System.out.println("Feedback submitted.");
    }
}
