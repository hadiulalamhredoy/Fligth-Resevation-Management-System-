public class Flight {
    private String flightId;
    private String airline;
    private String source;
    private String destination;
    private String departureTime;
    private String arrivalTime;
    private int totalSeats;
    private int availableSeats;
    private double pricePerSeat;

    public Flight(String flightId, String airline, String source, String destination,
                  String departureTime, String arrivalTime, int totalSeats, double pricePerSeat) {
        this.flightId = flightId;
        this.airline = airline;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        this.pricePerSeat = pricePerSeat;
    }

    public String getFlightId() {
        return flightId;
    }

    public String getAirline() {
        return airline;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public double getPricePerSeat() {
        return pricePerSeat;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public void displayFlightDetails() {
        System.out.println("Flight ID: " + flightId);
        System.out.println("Airline: " + airline);
        System.out.println("Source: " + source);
        System.out.println("Destination: " + destination);
        System.out.println("Departure: " + departureTime);
        System.out.println("Arrival: " + arrivalTime);
        System.out.println("Total Seats: " + totalSeats);
        System.out.println("Available Seats: " + availableSeats);
        System.out.println("Price Per Seat: $" + pricePerSeat);
    }
}
