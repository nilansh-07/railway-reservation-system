public class Train {
    private int trainNumber;
    private String trainName;
    private String source;
    private String destination;
    private int availableSeats;

    public Train(int trainNumber, String trainName, String source, String destination, int availableSeats) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.availableSeats = availableSeats;
    }

    // Getters and Setters
    public int getTrainNumber() {
        return trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public boolean bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
            return true;
        }
        return false;
    }

    public void cancelSeat() {
        availableSeats++;
    }

    @Override
    public String toString() {
        return trainNumber + "," + trainName + "," + source + "," + destination + "," + availableSeats;
    }

    public static Train fromString(String trainStr) {
        String[] parts = trainStr.split(",");
        return new Train(
            Integer.parseInt(parts[0]),
            parts[1],
            parts[2],
            parts[3],
            Integer.parseInt(parts[4])
        );
    }
} 