public class Payment {
    private String paymentId;
    private String bookingId;
    private String paymentMethod;
    private double amount;
    private String status;

    public Payment(String paymentId, String bookingId, String paymentMethod, double amount) {
        this.paymentId = paymentId;
        this.bookingId = bookingId;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.status = "Pending";
    }

    public boolean processPayment() {
        this.status = "Completed";
        System.out.println("Payment of $" + amount + " for booking " + bookingId + " is completed.");
        return true;
    }

    public String getStatus() {
        return status;
    }
}
