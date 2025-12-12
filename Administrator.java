public class Administrator extends User {

    public Administrator(String id, String username, String password) {
        super(id, username, password);
    }

    public void initSystem() {
        System.out.println("System initialized.");
    }

    public void manageAccounts() {
        System.out.println("Managing system accounts...");
    }
}
