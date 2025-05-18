import java.util.List;
import java.util.Scanner;

public class Main {
    private static BookingSystem bookingSystem;
    private static Scanner scanner;

    public static void main(String[] args) {
        bookingSystem = new BookingSystem();
        scanner = new Scanner(System.in);
        
        while (true) {
            displayMenu();
            int choice = getIntInput("Enter your choice (1-4): ");
            
            switch (choice) {
                case 1:
                    bookTicket();
                    break;
                case 2:
                    cancelTicket();
                    break;
                case 3:
                    viewAllTickets();
                    break;
                case 4:
                    System.out.println("\nThank you for using Railway Reservation System!");
                    scanner.close();
                    return;
                default:
                    System.out.println("\n❌ Invalid choice! Please enter a number between 1 and 4.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n=== 🚂 Railway Reservation System ===");
        System.out.println("1. Book a Ticket");
        System.out.println("2. Cancel a Ticket");
        System.out.println("3. View All Tickets");
        System.out.println("4. Exit");
    }

    private static void bookTicket() {
        System.out.println("\n=== Available Trains ===");
        List<Train> trains = bookingSystem.getAvailableTrains();
        for (Train train : trains) {
            System.out.printf("Train Number: %d\n", train.getTrainNumber());
            System.out.printf("Train Name: %s\n", train.getTrainName());
            System.out.printf("Route: %s → %s\n", train.getSource(), train.getDestination());
            System.out.printf("Available Seats: %d\n", train.getAvailableSeats());
            System.out.println("------------------------");
        }

        System.out.println("\n=== Passenger Details ===");
        String name = getStringInput("Enter passenger name: ");
        String candidateName = getStringInput("Enter candidate name (if different from passenger): ");
        int age = getIntInput("Enter passenger age: ");
        String gender = getStringInput("Enter passenger gender (M/F): ");
        int trainNumber = getIntInput("\nEnter train number to book: ");

        User user = new User(name, candidateName, age, gender);
        if (bookingSystem.bookTicket(user, trainNumber)) {
            System.out.println("\nTicket booked successfully!");
        } else {
            System.out.println("\nFailed to book ticket. Please check train availability.");
        }
    }

    private static void cancelTicket() {
        System.out.println("\n=== Cancel Ticket ===");
        String name = getStringInput("Enter passenger name: ");
        int trainNumber = getIntInput("Enter train number: ");

        if (bookingSystem.cancelTicket(name, trainNumber)) {
            System.out.println("\nTicket cancelled successfully!");
        } else {
            System.out.println("\nFailed to cancel ticket. Please check your details.");
        }
    }

    private static void viewAllTickets() {
        List<Ticket> tickets = bookingSystem.viewAllTickets();
        if (tickets.isEmpty()) {
            System.out.println("\nNo tickets found!");
            return;
        }

        System.out.println("\n=== Booked Tickets ===");
        for (Ticket ticket : tickets) {
            System.out.println("------------------------");
            System.out.printf("Ticket ID: %s\n", ticket.getTicketId());
            System.out.println("\nPassenger Details:");
            System.out.printf("  Name: %s\n", ticket.getUser().getName());
            if (!ticket.getUser().getCandidateName().equals(ticket.getUser().getName())) {
                System.out.printf("  Candidate: %s\n", ticket.getUser().getCandidateName());
            }
            System.out.printf("  Age: %d\n", ticket.getUser().getAge());
            System.out.printf("  Gender: %s\n", ticket.getUser().getGender());
            
            System.out.println("\nTrain Details:");
            System.out.printf("  Train: %s (%d)\n", 
                ticket.getTrain().getTrainName(), 
                ticket.getTrain().getTrainNumber());
            System.out.printf("  Route: %s → %s\n", 
                ticket.getTrain().getSource(), 
                ticket.getTrain().getDestination());
            System.out.println("------------------------");
        }
    }

    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }
    }
} 