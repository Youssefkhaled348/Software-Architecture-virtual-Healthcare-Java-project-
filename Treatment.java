import java.io.Serializable;

public class Treatment implements Serializable {
    public String treatmentID;
    public String consatName;
    public String patientId;
    public int counter;
    public boolean shceshuled;
    public Treatment(int counter ,String treatmentID, String patientId, String consatName) {
        this.treatmentID = treatmentID;
        this.patientId = patientId;
        this.consatName = consatName;
this.counter = counter;
    }

   
    public void take (int counter ,String treatmentID, String patientId, String consatName){
       counter=counter-1;
    }
     public void shcedule(int counter ,String treatmentID, String patientId, String consatName,boolean shceshuled){
        shceshuled=true ;
    }
    
}
