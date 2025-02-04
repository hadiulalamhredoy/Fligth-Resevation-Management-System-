public class Admin extends User {

    public Admin(String userId, String name, String email, String password) {
        super(userId, name, email, password, "Admin");
    }

    public void addFlight() {
        System.out.println("Flight added by admin: " + getName());
    }

    public void updateFlight() {
        System.out.println("Flight updated by admin: " + getName());
    }

    public void deleteFlight() {
        System.out.println("Flight deleted by admin: " + getName());
    }

    public void viewAllFlights() {
        System.out.println("Viewing all flights.");
    }

    public void viewAnalytics() {
        System.out.println("Viewing analytics.");
    }
}
