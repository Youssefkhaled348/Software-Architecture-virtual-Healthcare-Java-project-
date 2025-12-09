import java.util.ArrayList;
import java.util.List;

public class Provider extends User {
    private String specialty;
    private List<String> availability = new ArrayList<>();

    public Provider(String id, String name, String contact, String specialty) {
        super(id, name, contact);
        this.specialty = specialty;
    }

    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }

    public List<String> getAvailability() { return availability; }
    public void addAvailability(String slot) { availability.add(slot); }

    @Override
    public String getRole() { return "Provider"; }

    @Override
    public String toString() {
        return String.format("%s (ID:%s) - %s - %s", name, id, specialty, contact);
    }
}
