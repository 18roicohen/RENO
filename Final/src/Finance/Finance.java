package Finance;

import Cafeteria.Item;
import Enum.ClientType;

/**
 * This class define the income and outcome of cinema
 */
public class Finance {

    private int numberTicketsBought;
    private int numberFoodBought;
    private int ticketPrice;
    private int ticketsIncomeTotal;
    private int foodIncomeTotal;
    private IncomeOutcome incomeOutcome;

    /**
     * Constructor
     *
     * @param ticketPrice ticket Price
     */
    public Finance(int ticketPrice) {
        this.numberTicketsBought = 0;
        this.numberFoodBought = 0;
        // check the input from user
        if (ticketPrice <= 0) {
            ticketPrice = 5;
        }
        this.ticketPrice = ticketPrice;
        this.incomeOutcome = new IncomeOutcome();
    }

    /**
     * @return int return the foodPrice
     */
    public int getFoodIncomeTotal() {
        return foodIncomeTotal;
    }

    /**
     * change ticket price
     * must greater then then 0
     *
     * @param ticketPrice ticket Price
     */
    public void setTicketPrice(int ticketPrice) {
        if (ticketPrice > 0) {
            this.ticketPrice = ticketPrice;
        }
    }

    /**
     * change food Price - the price for buy food for cinema
     * must greater then then 0
     * @param foodIncomeTotal set food Price
     */
    public void setFoodIncomeTotal(int foodIncomeTotal) {
        if (foodIncomeTotal > 0) {
            this.foodIncomeTotal = foodIncomeTotal;
        }
    }

    /**
     * function private that calculate Price by type client
     * @param discountType - type of client
     * @return the discount for client Type
     */
    private double calculatePriceByType(ClientType discountType, int price) {
        switch (discountType) {
            case VeteranResident:
                return price * 0.5;//15
            case Solider:
                return price * 0.6;//18
            case Student:
                return price * 0.8;//24
            case Regular:
            default:
                return price;//30
        }
    }

    public void boughtItemFromCafeteria(Item item, int numOfItems){
        // price for client of cola is 5 and I want to buy 2 = 10
        int value = numOfItems * item.getItemPriceForClient();
        foodIncomeTotal += value;
        incomeOutcome.earn(value);
        // price for cinema of cola is 2 and I want to buy 2 = 4
        value = numOfItems * item.getItemPriceForCinema();
        incomeOutcome.spend(value);
    }

    /**
     * number of ticket * ticketPrice
     * calculate after discount
     *
     * @param amount     - number food to buy
     * @param clientType - the discount for client Type
     */
    public double buyTickets(int amount, ClientType clientType) {
        if (amount > 0) {
            double priceForClient = this.calculatePriceByType(clientType, this.ticketPrice);
            ticketsIncomeTotal += amount * priceForClient;
            // income
            this.incomeOutcome.earn(amount * priceForClient);
            // outcome
            this.numberTicketsBought += amount;
            return priceForClient;
        }
        return -1;
    }

    public IncomeOutcome getIncomeOutcome() {
        return incomeOutcome;
    }

    public void setIncomeOutcome(IncomeOutcome incomeOutcome) {
        this.incomeOutcome = incomeOutcome;
    }

    /**
     * @return string to Finance class
     */
    @Override
    public String toString() {
        return "Finance \n" +
                "number tickets bought = " + numberTicketsBought +
                "\nnumber food bought = " + numberFoodBought +
                "\nticket price for cinema = " + ticketPrice +
                "\ntotal tickets income for cinema = " + ticketsIncomeTotal +
                "\ntotal cafeteria items income for cinema = " + foodIncomeTotal +
                "\n ";
    }

    /**
     * return the price list
     * @return string
     */
    public String priceList() {
        double adultTicket = calculatePriceByType(ClientType.Regular, this.ticketPrice);
        double studentTicket = calculatePriceByType(ClientType.Student, this.ticketPrice);
        double soliderTicket = calculatePriceByType(ClientType.Solider, this.ticketPrice);
        double veteranResidentTicket = calculatePriceByType(ClientType.VeteranResident, this.ticketPrice);

        return  "Ticket Prices: \n" +
                "Regular = " + adultTicket + " \n" +
                "Student = " + studentTicket + " \n" +
                "Solider = " + soliderTicket + " \n" +
                "Veteran Resident  = " + veteranResidentTicket + " \n" +
                "Enjoy! :)";
    }
}
