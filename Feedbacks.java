public class Feedbacks {
    private String id;
    private String patientID;
    private String content;

    public Feedbacks(String id, String patientID, String content) {
        this.id = id;
        this.patientID = patientID;
        this.content = content;
    }

    public void showFeedback() {
        System.out.println(patientID + ": " + content);
    }
}
