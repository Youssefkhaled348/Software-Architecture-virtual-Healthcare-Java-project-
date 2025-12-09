import java.io.Serializable;

public class Prescription implements Serializable {
    private String id;
    private String patientId;
    private String providerId;
    private String medication;
    private String instructions;

    public Prescription(String id, String patientId, String providerId, String medication, String instructions) {
        this.id = id;
        this.patientId = patientId;
        this.providerId = providerId;
        this.medication = medication;
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return String.format("Rx %s Patient:%s Medication:%s (%s)", id, patientId, medication, instructions);
    }
}
