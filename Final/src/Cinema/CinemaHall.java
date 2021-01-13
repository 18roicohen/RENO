package Cinema;

import Enum.CinemaHallType;

/**
 * This class present cinemahall in cinema
 */
public class CinemaHall implements ProductionSite {

    private final int hallNumber;
    private int availableSeatsAmount;
    private CinemaHallType type;

    /**
     * Constructor
     * @param hallNumber hall Number
     * @param numOfSeat  number Of Seat - greater/equal to 0
     * @param type       - cinema hall type
     */
    public CinemaHall(int hallNumber, int numOfSeat, CinemaHallType type) {
        this.hallNumber = hallNumber;
        this.availableSeatsAmount = Math.max(numOfSeat, 0);
        this.type = type;
    }

    /**
     * @param hallNumber hall Number
     * @param other      - CinemaHall
     */
    public CinemaHall(int hallNumber, CinemaHall other) {
        this.availableSeatsAmount = other.availableSeatsAmount;
        this.type = other.type;
        this.hallNumber = hallNumber;
    }

    /**
     * @return number of seat
     */
    public int getNumOfSeats() {
        return availableSeatsAmount;
    }

    /**
     * @return hall number
     */
    public int getHallNumber() {
        return hallNumber;
    }

    /**
     * @return type of cinema hall
     */
    public CinemaHallType getType() {
        return type;
    }

    /**
     * @param type set type of cinema hall
     */
    public void setType(CinemaHallType type) {
        this.type = type;
    }

    /**
     * @return if the cinema hall full
     */
    public boolean getIsFull() {
        return availableSeatsAmount == 0;
    }

    /**
     * @param amount - number seat to save
     * @return True if success, other return false
     */
    public boolean buySeats(int amount) {//buys seats in the hall, if can't - return false, else return true.
        if (amount > 0 && availableSeatsAmount >= amount) {
            this.availableSeatsAmount -= amount;
            return true;
        }
        return false;
    }

    public String toString() {
        String hallDescription = "==== Hall " + hallNumber + " ====";
        hallDescription += "\n Available seat amount in hall: " + this.getNumOfSeats();
        hallDescription += "\n Hall type is: " + this.type;
        hallDescription += "\n The Hall is " + (this.getIsFull() ? "full" : "not full") + "\n";
        return hallDescription;
    }

}
