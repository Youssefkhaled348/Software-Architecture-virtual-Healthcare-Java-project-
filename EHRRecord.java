import java.io.Serializable;
import java.time.LocalDateTime;

public class EHRRecord implements Serializable {
    public String id;
    public String patientId;
    public String providerId;
    public String notes;
    public String diagnosis;
    public LocalDateTime created;
    public String data;
    public EHRRecord(String id, String patientId, String providerId, String diagnosis, String notes) {
        this.id = id;
        this.patientId = patientId;
        this.providerId = providerId;
        this.diagnosis = diagnosis;
        this.notes = notes;
        this.created = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return String.format("EHR %s for Patient:%s by Provider:%s - %s - %s", 
            id, patientId, providerId, diagnosis, notes);
    }
    public void addRecord(String id, String patientId, String providerId, String diagnosis, String notes){
        data =data+patientId+diagnosis+notes;
    }
    public void updateRecord(String pid, String diagnosis){
        if (id==pid){
            data =data+patientId+diagnosis;
        }
    }
    }

