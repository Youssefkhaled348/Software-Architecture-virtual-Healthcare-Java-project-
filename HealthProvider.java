public class HealthProvider extends User {
    private boolean availability;
    private String specialty;

    public HealthProvider(String id, String username, String password, String specialty, boolean availability) {
        super(id, username, password);
        this.specialty = specialty;
        this.availability = availability;
    }

    public void viewRecord() {
        System.out.println("Provider viewing patient records...");
    }

    public boolean isAvailable() { return availability; }

    public String getSpecialty() { return specialty; }
}
