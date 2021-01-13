package scenarios;

import Enum.FoodTypeEnum;
import Cafeteria.FoodItem;
import Cafeteria.Cafeteria;
import Cafeteria.Date;
import Cafeteria.RefrigeratedItem;


public class CafeteriaTest {

	public static void main(String[] args) {

		FoodItem s1 = new FoodItem(500, FoodTypeEnum.Popcorn, 11, new Date(1, 3, 15),
				new Date(1, 3, 19), 0.9);
		System.out.println(s1.toString());
		System.out.println("--------------------------------------------------------------");

		RefrigeratedItem s2 = new RefrigeratedItem(501, FoodTypeEnum.Cola, 2, new Date(1, 3, 15),
				new Date(1, 3, 19), 60, 100);
		System.out.println(s2.toString());
		System.out.println("--------------------------------------------------------------");

		RefrigeratedItem s3 = new RefrigeratedItem(502, FoodTypeEnum.Magnum, 9, new Date(1, 3, 15),
				new Date(1, 3, 19), 60, 100);
		System.out.println(s3.toString());
		System.out.println("--------------------------------------------------------------");

		FoodItem s4 = new FoodItem(503, FoodTypeEnum.Kinder, 12, new Date(1, 3, 15),
				new Date(1, 3, 19), 0.25);
		System.out.println(s4.toString());
		System.out.println("--------------------------------------------------------------");

		FoodItem s5 = new FoodItem(504, FoodTypeEnum.Kitkat, 5, new Date(1, 3, 15),
				new Date(1, 3, 19), 0.25);
		System.out.println(s5.toString());
		System.out.println("--------------------------------------------------------------");
		System.out.println();

		Cafeteria d = new Cafeteria(100);

		d.addItem(s1);
		d.addItem(s2);
		d.addItem(s3);
		d.addItem(s4);
		d.addItem(s5);
		d.getOnlyFoodiItems();
		System.out.println();

		d.getOnlyRefrigeratorItems();

		System.out.println();
		d.sumOfTotalQuantityCount();
		System.out.println();
		d.priceForCinema();
		d.priceForClients();
		System.out.println();
		System.out.println("Amount of magnum left: " + d.howManyCountRefrigeratedItem(FoodTypeEnum.Magnum));
		System.out.println("Amount of kitkat left: " + d.howManyCountFoodi(FoodTypeEnum.Kitkat));
		System.out.println(  d.buyItemByType(FoodTypeEnum.Popcorn, 1));

	}
}
