import java.io.Serializable;

public class Billing implements Serializable {
    private String id;
    private String patientId;
    private double amount;
    private boolean paid = false;

    public Billing(String id, String patientId, double amount) {
        this.id = id;
        this.patientId = patientId;
        this.amount = amount;
    }

    public void pay() { paid = true; }

    @Override
    public String toString() {
        return String.format("Bill %s Patient:%s Amount:%.2f %s", id, patientId, amount, paid ? "(PAID)" : "(UNPAID)");
    }
}
