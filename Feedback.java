import java.io.Serializable;

public class Feedback implements Serializable {
    public String id;
    public String patientId;
    public String providerId;
    public int rating;
    public String comment;

    public String allFeedback;
    public Feedback(String id, String patientId, String providerId, int rating, String comment) {
        this.id = id;
        this.patientId = patientId;
        this.providerId = providerId;
        this.rating = rating;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return String.format("Feedback %s Provider:%s Rating:%d Comment:%s", id, providerId, rating, comment);
    }
    public void addFeedback (String id, String patientId, String providerId, int rating, String comment){
        allFeedback  =allFeedback + comment;
    }
    public void viewFeedback(){
      //  "all Patient feedback "
      System.out.print("all Patient feedback ");
      System.out.print(allFeedback);
    }
    
}
