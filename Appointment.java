public class Appointment {
    private String appointmentID;
    private String date;
    private String patientID;
    private String providerID;

    public Appointment(String appointmentID, String date, String patientID, String providerID) {
        this.appointmentID = appointmentID;
        this.date = date;
        this.patientID = patientID;
        this.providerID = providerID;
    }

    public void showAppointment() {
        System.out.println("Appointment ID: " + appointmentID +
            " | Date: " + date +
            " | Patient: " + patientID +
            " | Provider: " + providerID);
    }
}
