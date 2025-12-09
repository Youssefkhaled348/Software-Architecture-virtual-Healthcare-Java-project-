import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Appointment implements Serializable {
    public String id;
    public String patientId;
    public String providerId;
    public LocalDateTime dateTime;
    public boolean completed = false;
    public String allAppointment;
    public String assignmentDoctor;
    public Appointment(String id, String patientId, String providerId, LocalDateTime dateTime) {
        this.id = id;
        this.patientId = patientId;
        this.providerId = providerId;
        this.dateTime = dateTime;
    }

    public String getId() { return id; }
    public String getPatientId() { return patientId; }
    public String getProviderId() { return providerId; }
    public LocalDateTime getDateTime() { return dateTime; }
    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }

    @Override
    public String toString() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return String.format("Appointment %s - Patient:%s Provider:%s at %s %s",
                id, patientId, providerId, dateTime.format(f), completed ? "(done)" : "");
    }
    public void shcedule(String id, String patientId, String providerId, LocalDateTime dateTime){
        allAppointment = allAppointment+id +  patientId;
    }
    public void assignDoctor (String doctorName){
        assignmentDoctor=doctorName;
    }
}
