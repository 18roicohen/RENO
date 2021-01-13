package Cinema;


public interface ProductionSite {
    /**
     * @return if the cinema hall full
     */
     boolean getIsFull();

    /**
     * @param amount - number seat to save
     * @return True if success, other return false
     */
     boolean buySeats(int amount);
}
