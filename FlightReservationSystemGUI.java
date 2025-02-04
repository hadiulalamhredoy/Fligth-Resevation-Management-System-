import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class FlightReservationSystemGUI {
    private static List<Flight> flights = new ArrayList<>();
    private static List<Booking> bookings = new ArrayList<>();
    private static List<User> users = new ArrayList<>();
    private static String currentUserId = null; // Logged-in user ID

    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Flight Reservation System");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400, 300);
        mainFrame.setLayout(new GridLayout(3, 1));

        JButton adminButton = new JButton("Admin Options");
        JButton userButton = new JButton("User Options");
        JButton exitButton = new JButton("Exit");

        mainFrame.add(adminButton);
        mainFrame.add(userButton);
        mainFrame.add(exitButton);

        adminButton.addActionListener(e -> showAdminMenu());
        userButton.addActionListener(e -> showUserMenu());
        exitButton.addActionListener(e -> System.exit(0));

        mainFrame.setVisible(true);
    }

    private static void showAdminMenu() {
        JFrame adminFrame = new JFrame("Admin Menu");
        adminFrame.setSize(400, 300);
        adminFrame.setLayout(new GridLayout(3, 1));

        JButton addFlightButton = new JButton("Add Flight");
        JButton viewFlightsButton = new JButton("View All Flights");
        JButton backButton = new JButton("Back");

        adminFrame.add(addFlightButton);
        adminFrame.add(viewFlightsButton);
        adminFrame.add(backButton);

        addFlightButton.addActionListener(e -> showAddFlightForm());
        viewFlightsButton.addActionListener(e -> showViewFlights());
        backButton.addActionListener(e -> adminFrame.dispose());

        adminFrame.setVisible(true);
    }

    private static void showUserMenu() {
        JFrame userFrame = new JFrame("User Menu");
        userFrame.setSize(400, 300);
        userFrame.setLayout(new GridLayout(5, 1));

        JButton registerButton = new JButton("Register");
        JButton viewFlightsButton = new JButton("View Flights");
        JButton bookFlightButton = new JButton("Book a Flight");
        JButton viewBookingHistoryButton = new JButton("View Booking History");
        JButton backButton = new JButton("Back");

        userFrame.add(registerButton);
        userFrame.add(viewFlightsButton);
        userFrame.add(bookFlightButton);
        userFrame.add(viewBookingHistoryButton);
        userFrame.add(backButton);

        registerButton.addActionListener(e -> showUserRegistrationForm());
        viewFlightsButton.addActionListener(e -> showViewFlights());
        bookFlightButton.addActionListener(e -> showBookFlightForm());
        viewBookingHistoryButton.addActionListener(e -> showViewBookingHistory());
        backButton.addActionListener(e -> userFrame.dispose());

        userFrame.setVisible(true);
    }

    private static void showAddFlightForm() {
        JFrame addFlightFrame = new JFrame("Add Flight");
        addFlightFrame.setSize(400, 400);
        addFlightFrame.setLayout(new GridLayout(9, 2));

        JLabel flightIdLabel = new JLabel("Flight ID:");
        JTextField flightIdField = new JTextField();
        JLabel airlineLabel = new JLabel("Airline:");
        JTextField airlineField = new JTextField();
        JLabel sourceLabel = new JLabel("Source:");
        JTextField sourceField = new JTextField();
        JLabel destinationLabel = new JLabel("Destination:");
        JTextField destinationField = new JTextField();
        JLabel departureLabel = new JLabel("Departure Time:");
        JTextField departureField = new JTextField();
        JLabel arrivalLabel = new JLabel("Arrival Time:");
        JTextField arrivalField = new JTextField();
        JLabel totalSeatsLabel = new JLabel("Total Seats:");
        JTextField totalSeatsField = new JTextField();
        JLabel priceLabel = new JLabel("Price Per Seat:");
        JTextField priceField = new JTextField();

        JButton addButton = new JButton("Add Flight");
        JButton cancelButton = new JButton("Cancel");

        addFlightFrame.add(flightIdLabel);
        addFlightFrame.add(flightIdField);
        addFlightFrame.add(airlineLabel);
        addFlightFrame.add(airlineField);
        addFlightFrame.add(sourceLabel);
        addFlightFrame.add(sourceField);
        addFlightFrame.add(destinationLabel);
        addFlightFrame.add(destinationField);
        addFlightFrame.add(departureLabel);
        addFlightFrame.add(departureField);
        addFlightFrame.add(arrivalLabel);
        addFlightFrame.add(arrivalField);
        addFlightFrame.add(totalSeatsLabel);
        addFlightFrame.add(totalSeatsField);
        addFlightFrame.add(priceLabel);
        addFlightFrame.add(priceField);
        addFlightFrame.add(addButton);
        addFlightFrame.add(cancelButton);

        addButton.addActionListener(e -> {
            String flightId = flightIdField.getText();
            String airline = airlineField.getText();
            String source = sourceField.getText();
            String destination = destinationField.getText();
            String departureTime = departureField.getText();
            String arrivalTime = arrivalField.getText();
            int totalSeats;
            double price;

            try {
                totalSeats = Integer.parseInt(totalSeatsField.getText());
                price = Double.parseDouble(priceField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(addFlightFrame, "Invalid input. Please enter numeric values for Total Seats and Price.");
                return;
            }

            flights.add(new Flight(flightId, airline, source, destination, departureTime, arrivalTime, totalSeats, price));
            JOptionPane.showMessageDialog(addFlightFrame, "Flight added successfully!");
            addFlightFrame.dispose();
        });

        cancelButton.addActionListener(e -> addFlightFrame.dispose());

        addFlightFrame.setVisible(true);
    }

    private static void showUserRegistrationForm() {
        JFrame registerFrame = new JFrame("User Registration");
        registerFrame.setSize(400, 300);
        registerFrame.setLayout(new GridLayout(4, 2));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();
        JButton registerButton = new JButton("Register");
        JButton cancelButton = new JButton("Cancel");

        registerFrame.add(nameLabel);
        registerFrame.add(nameField);
        registerFrame.add(emailLabel);
        registerFrame.add(emailField);
        registerFrame.add(registerButton);
        registerFrame.add(cancelButton);

        registerButton.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String userId = "U" + (users.size() + 1);

            users.add(new User(userId, name, email, "password", "Passenger"));
            currentUserId = userId; // Log in the newly registered user
            JOptionPane.showMessageDialog(registerFrame, "Registration successful! Your User ID is: " + userId);
            registerFrame.dispose();
        });

        cancelButton.addActionListener(e -> registerFrame.dispose());

        registerFrame.setVisible(true);
    }

    private static void showViewFlights() {
        JFrame viewFlightsFrame = new JFrame("Available Flights");
        viewFlightsFrame.setSize(400, 300);
        viewFlightsFrame.setLayout(new BorderLayout());

        JTextArea flightsArea = new JTextArea();
        flightsArea.setEditable(false);

        if (flights.isEmpty()) {
            flightsArea.setText("No flights available.");
        } else {
            StringBuilder flightDetails = new StringBuilder();
            for (Flight flight : flights) {
                flightDetails.append("Flight ID: ").append(flight.getFlightId()).append("\n");
                flightDetails.append("Airline: ").append(flight.getAirline()).append("\n");
                flightDetails.append("Source: ").append(flight.getSource()).append("\n");
                flightDetails.append("Destination: ").append(flight.getDestination()).append("\n");
                flightDetails.append("Departure: ").append(flight.getDepartureTime()).append("\n");
                flightDetails.append("Arrival: ").append(flight.getArrivalTime()).append("\n");
                flightDetails.append("Total Seats: ").append(flight.getTotalSeats()).append("\n");
                flightDetails.append("Price Per Seat: $").append(flight.getPricePerSeat()).append("\n");
                flightDetails.append("-------------------------\n");
            }
            flightsArea.setText(flightDetails.toString());
        }

        JScrollPane scrollPane = new JScrollPane(flightsArea);
        JButton closeButton = new JButton("Close");

        viewFlightsFrame.add(scrollPane, BorderLayout.CENTER);
        viewFlightsFrame.add(closeButton, BorderLayout.SOUTH);

        closeButton.addActionListener(e -> viewFlightsFrame.dispose());

        viewFlightsFrame.setVisible(true);
    }

    private static void showBookFlightForm() {
        if (currentUserId == null) {
            JOptionPane.showMessageDialog(null, "Please register first.");
            return;
        }

        if (flights.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No flights available for booking.");
            return;
        }

        JFrame bookFlightFrame = new JFrame("Book a Flight");
        bookFlightFrame.setSize(400, 400);
        bookFlightFrame.setLayout(new GridLayout(flights.size() + 2, 1));

        ButtonGroup flightGroup = new ButtonGroup();
        JPanel flightPanel = new JPanel(new GridLayout(flights.size(), 1));

        for (Flight flight : flights) {
            JRadioButton flightButton = new JRadioButton(flight.getFlightId() + " - " + flight.getAirline());
            flightGroup.add(flightButton);
            flightPanel.add(flightButton);
        }

        JButton bookButton = new JButton("Book Flight");
        JButton cancelButton = new JButton("Cancel");

        bookFlightFrame.add(flightPanel);
        bookFlightFrame.add(bookButton);
        bookFlightFrame.add(cancelButton);

        bookButton.addActionListener(e -> {
            String selectedFlightId = null;

            // Iterate over ButtonGroup elements using Enumeration
            Enumeration<AbstractButton> buttons = flightGroup.getElements();
            while (buttons.hasMoreElements()) {
                AbstractButton button = buttons.nextElement();
                if (button.isSelected()) {
                    selectedFlightId = button.getText().split(" - ")[0];
                    break;
                }
            }

            if (selectedFlightId == null) {
                JOptionPane.showMessageDialog(bookFlightFrame, "Please select a flight to book.");
                return;
            }

            bookings.add(new Booking("B" + (bookings.size() + 1), currentUserId, selectedFlightId, "12A", 100));
            JOptionPane.showMessageDialog(bookFlightFrame, "Booking successful!");
            bookFlightFrame.dispose();
        });

        cancelButton.addActionListener(e -> bookFlightFrame.dispose());

        bookFlightFrame.setVisible(true);
    }

    private static void showViewBookingHistory() {
        if (currentUserId == null) {
            JOptionPane.showMessageDialog(null, "Please register first.");
            return;
        }

        JFrame bookingHistoryFrame = new JFrame("Booking History");
        bookingHistoryFrame.setSize(400, 300);
        bookingHistoryFrame.setLayout(new BorderLayout());

        JTextArea bookingArea = new JTextArea();
        bookingArea.setEditable(false);

        StringBuilder bookingDetails = new StringBuilder();

        for (Booking booking : bookings) {
            if (booking.getUserId().equals(currentUserId)) {
                bookingDetails.append("Booking ID: ").append(booking.getBookingId()).append("\n");
                bookingDetails.append("Flight ID: ").append(booking.getFlightId()).append("\n");
                bookingDetails.append("Seat Number: ").append(booking.getSeatNumber()).append("\n");
                bookingDetails.append("Price: $").append(booking.getPrice()).append("\n");
                bookingDetails.append("-------------------------\n");
            }
        }

        if (bookingDetails.isEmpty()) {
            bookingArea.setText("No bookings found.");
        } else {
            bookingArea.setText(bookingDetails.toString());
        }

        JScrollPane scrollPane = new JScrollPane(bookingArea);
        JButton closeButton = new JButton("Close");

        bookingHistoryFrame.add(scrollPane, BorderLayout.CENTER);
        bookingHistoryFrame.add(closeButton, BorderLayout.SOUTH);

        closeButton.addActionListener(e -> bookingHistoryFrame.dispose());

        bookingHistoryFrame.setVisible(true);
    }
}
