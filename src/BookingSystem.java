import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookingSystem {
    private List<Train> trains;
    private static final String TICKETS_FILE = "tickets.txt";

    public BookingSystem() {
        trains = new ArrayList<>();
        initializeTrains();
    }

    private void initializeTrains() {
        trains.add(new Train(1001, "Express 1", "Delhi", "Mumbai", 50));
        trains.add(new Train(1002, "Express 2", "Mumbai", "Chennai", 40));
        trains.add(new Train(1003, "Express 3", "Kolkata", "Delhi", 45));
    }

    public List<Train> getAvailableTrains() {
        return trains;
    }

    public Train getTrainByNumber(int trainNumber) {
        return trains.stream()
                .filter(train -> train.getTrainNumber() == trainNumber)
                .findFirst()
                .orElse(null);
    }

    public boolean bookTicket(User user, int trainNumber) {
        Train train = getTrainByNumber(trainNumber);
        if (train == null || !train.bookSeat()) {
            return false;
        }

        Ticket ticket = new Ticket(user, train);
        return saveTicket(ticket);
    }

    public boolean cancelTicket(String userName, int trainNumber) {
        List<Ticket> tickets = loadTickets();
        boolean found = false;

        for (Ticket ticket : tickets) {
            if (ticket.getUser().getName().equals(userName) && 
                ticket.getTrain().getTrainNumber() == trainNumber) {
                ticket.getTrain().cancelSeat();
                tickets.remove(ticket);
                found = true;
                break;
            }
        }

        if (found) {
            saveAllTickets(tickets);
            return true;
        }
        return false;
    }

    public List<Ticket> viewAllTickets() {
        return loadTickets();
    }

    private boolean saveTicket(Ticket ticket) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TICKETS_FILE, true))) {
            writer.write(ticket.toString());
            writer.newLine();
            return true;
        } catch (IOException e) {
            System.err.println("Error saving ticket: " + e.getMessage());
            return false;
        }
    }

    private void saveAllTickets(List<Ticket> tickets) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TICKETS_FILE))) {
            for (Ticket ticket : tickets) {
                writer.write(ticket.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving tickets: " + e.getMessage());
        }
    }

    private List<Ticket> loadTickets() {
        List<Ticket> tickets = new ArrayList<>();
        File file = new File(TICKETS_FILE);
        
        if (!file.exists()) {
            return tickets;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(TICKETS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    tickets.add(Ticket.fromString(line));
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading tickets: " + e.getMessage());
        }
        return tickets;
    }
} 