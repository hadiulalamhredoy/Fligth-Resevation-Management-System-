public class Booking {
    private String bookingId;
    private String userId;
    private String flightId;
    private String seatNumber;
    private String status;
    private double price;

    public Booking(String bookingId, String userId, String flightId, String seatNumber, double price) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.flightId = flightId;
        this.seatNumber = seatNumber;
        this.status = "Confirmed";
        this.price = price;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getUserId() {
        return userId;
    }

    public String getFlightId() {
        return flightId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public String getStatus() {
        return status;
    }

    public double getPrice() {
        return price;
    }

    public void cancelBooking() {
        this.status = "Cancelled";
        System.out.println("Booking " + bookingId + " has been cancelled.");
    }
}
