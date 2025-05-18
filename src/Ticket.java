public class Ticket {
    private User user;
    private Train train;
    private String ticketId;

    public Ticket(User user, Train train) {
        this.user = user;
        this.train = train;
        this.ticketId = generateTicketId();
    }

    private String generateTicketId() {
        return "TKT" + System.currentTimeMillis();
    }

    public User getUser() {
        return user;
    }

    public Train getTrain() {
        return train;
    }

    public String getTicketId() {
        return ticketId;
    }

    @Override
    public String toString() {
        return ticketId + "," + user.toString() + "," + train.toString();
    }

    public static Ticket fromString(String ticketStr) {
        String[] parts = ticketStr.split(",");
        String ticketId = parts[0];
        User user = User.fromString(parts[1] + "," + parts[2] + "," + parts[3] + "," + parts[4]);
        Train train = Train.fromString(parts[5] + "," + parts[6] + "," + parts[7] + "," + parts[8] + "," + parts[9]);
        Ticket ticket = new Ticket(user, train);
        return ticket;
    }
} 