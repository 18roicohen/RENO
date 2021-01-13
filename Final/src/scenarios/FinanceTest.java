package scenarios;
import Cafeteria.Item;
import Finance.Finance;
import Enum.ClientType;
import Enum.FoodTypeEnum;

public class FinanceTest {

	public static void main(String[] args) {
		/**
		 *
		 * How much tickets and food cost to the theater
		 */
		int ticketCost = 30;

		/**
		 * Crate finance to the theater and print price list
		 */
		Finance theaterFinance = new Finance(ticketCost);
		System.out.println("------------------Price List---------------------");
		System.out.println(theaterFinance.priceList());

		Item popCorn = new Item(123, FoodTypeEnum.Popcorn, 10,0.9);

		System.out.println("----------------Buy Food-------------------------");
		theaterFinance.boughtItemFromCafeteria(popCorn,1);
		System.out.println(theaterFinance);
		System.out.println("** Amount 0 - don't change");
		System.out.println("--------------------Buy Food---------------------");
		System.out.println("** Amount 1 - client regular");
		System.out.println("Price for client = " + popCorn.getItemPriceForClient());
		System.out.println("--------------------Buy Ticket--------------------");
		theaterFinance.buyTickets(0, ClientType.Regular);
		System.out.println("** Amount 1, vetran - don't change");
		theaterFinance.buyTickets(1, ClientType.VeteranResident);
		System.out.println(theaterFinance);

		System.out.println("** Amount 1, Student - don't change");
		theaterFinance.buyTickets(1, ClientType.Student);
		System.out.println(theaterFinance);

		System.out.println("** Amount 3, Soldier - don't change");
		theaterFinance.buyTickets(3, ClientType.Solider);
		System.out.println(theaterFinance);

		System.out.println("--------------------Buy Food-----------------------");
		theaterFinance.boughtItemFromCafeteria(popCorn,1);
		System.out.println("Price for client = " + popCorn.getItemPriceForClient());

		System.out.println("--------------------Buy Ticket---------------------");
		System.out.println("** Amount 2, regular - don't change");
		theaterFinance.buyTickets(2, ClientType.Regular);
		System.out.println(theaterFinance);
	}
}
