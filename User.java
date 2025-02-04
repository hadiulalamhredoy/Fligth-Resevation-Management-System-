public class User {
    private String userId;
    private String name;
    private String email;
    private String password;
    private String role;

    public User(String userId, String name, String email, String password, String role) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public void register() {
        System.out.println("User registered: " + name);
    }

    public void addBooking() {
        System.out.println("Booking added for user: " + name);
    }

    public void viewBookingHistory() {
        System.out.println("Viewing booking history for user: " + name);
    }

    // Getters
    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    // Setters
    public void setPassword(String password) {
        this.password = password;
    }
}
