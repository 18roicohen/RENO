package Cafeteria;

import Enum.FoodTypeEnum;

public class Cafeteria {

	private Item[] arr;//יצירת מערך
	private int counter;

	public Cafeteria(int numberOfItemsInCafeteria) {
		arr = new Item[numberOfItemsInCafeteria];
		counter = 0;
	}

	public void addItem(Item item)//פונקציה להוספת מוצרים למלאי
	{
		if (counter < 100) {
			arr[counter] = item;
			counter++;
		}
	}

	public boolean buyItemByType(FoodTypeEnum typeEnum, int amount){//פונקציה שמורידה כמות שנקנתה מהמלאי
		boolean success = false;
		if(counter != 0){
			for (int i = 0; i < counter; i++) {
				if(arr[i].name == typeEnum && arr[i].getQuantity() >= amount){
					arr[i].setQuantity(arr[i].getQuantity()-amount);
					success = true;
				}
			}
		}
		return success;
	}

	public void getOnlyRefrigeratorItems() {//פונקציה שמציגה כמות ופירוט של מוצרים רק ממחלקת הקירור
		int sum = 0;
		String str = "";
		for (int i = 0; i < counter; i++) {
			if (arr[i] instanceof RefrigeratedItem) {
				str += "\n\t";
				str += arr[i].name + ":";
				str += arr[i].getQuantity();
				sum = sum + arr[i].getQuantity();
			}
		}
		System.out.println("total amount of refrigerated items:" + sum);
		System.out.println("count of refrigerated items:" + str);
		System.out.println("***************************");
	}

	public void getOnlyFoodiItems()//פונקציה שמציגה כמות ופירוט של מוצרים רק ממחלקת האוכל
	{
		String str = "";
		int sum = 0;
		for (int i = 0; i < counter; i++) {
			if (!(arr[i] instanceof RefrigeratedItem)) {
				str += "\n\t";
				str += arr[i].name + ":";
				str += arr[i].getQuantity();
				sum = sum + arr[i].getQuantity();
			}
		}
		System.out.println("total amount of foodi:" + sum);
		System.out.println("count of foodi:" + str);
		System.out.println("***************************");
	}


	public void sumOfTotalQuantityCount()//כמות כוללת בשתי המחלקות
	{
		int sum = 0;
		for (int i = 0; i < counter; i++) {
			sum = sum + arr[i].getQuantity();
		}
		System.out.println("total quantity foodi + refrigerat is : " + sum);
	}

	public void priceForCinema()//חישוב מחיר לאולם
	{
		int sum = 0;
		for (int i = 0; i < counter; i++) {
			sum = sum + arr[i].getItemPriceForCinema()*arr[i].getQuantity();
		}
		System.out.println("Price for cinema total is : " + sum);
	}

	public void priceForClients()//חישוב מחיר לקונה
	{
		int sum = 0;
		for (int i = 0; i < counter; i++) {
			sum = sum + arr[i].getItemPriceForClient()*arr[i].getQuantity();
		}
		System.out.println("Price for clients total is : " + sum);
	}

	public int howManyCountRefrigeratedItem(FoodTypeEnum name)//פונקציההמחזירה כמה קנו ממוצר ממחלקת הקירור
	{
		int sum = 0;
		FoodItem temp;
		for (int i = 0; i < counter; i++) {
			if (arr[i] instanceof RefrigeratedItem) {
				if (arr[i].getType() == name) {
					temp = (FoodItem) arr[i];
					sum += temp.getQuantity();
				}
			}
		}
		return sum;
	}

	public int howManyCountFoodi(FoodTypeEnum name)//פונקיה המחזירה כמה קנו מוצר ממחלקת האאוכל
	{
		int sum = 0;
		FoodItem temp;
		for (int i = 0; i < counter; i++) {
			if (arr[i] instanceof FoodItem && !(arr[i] instanceof RefrigeratedItem)) {
				if (arr[i].getType() == name) {
					temp = (FoodItem) arr[i];
					sum += temp.getQuantity();
				}
			}
		}
		return sum;
	}

	public Item getItemByType(FoodTypeEnum typeEnum){
		for (int i = 0; i < counter; i++) {
			if(arr[i].getType() == typeEnum){
				return arr[i];
			}
		}
		return null;
	}

	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i < counter; i++) {
			str += arr[i].toString() + "\n";
		}
		return str;
	}
}
