package Cafeteria;

import Enum.FoodTypeEnum;

public class Cafeteria {

	private Item[] arr;//����� ����
	private int counter;

	public Cafeteria(int numberOfItemsInCafeteria) {
		arr = new Item[numberOfItemsInCafeteria];
		counter = 0;
	}

	public void addItem(Item item)//������� ������ ������ �����
	{
		if (counter < 100) {
			arr[counter] = item;
			counter++;
		}
	}

	public boolean buyItemByType(FoodTypeEnum typeEnum, int amount){//������� ������� ���� ������ ������
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

	public void getOnlyRefrigeratorItems() {//������� ������ ���� ������ �� ������ �� ������ ������
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

	public void getOnlyFoodiItems()//������� ������ ���� ������ �� ������ �� ������ �����
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


	public void sumOfTotalQuantityCount()//���� ����� ���� �������
	{
		int sum = 0;
		for (int i = 0; i < counter; i++) {
			sum = sum + arr[i].getQuantity();
		}
		System.out.println("total quantity foodi + refrigerat is : " + sum);
	}

	public void priceForCinema()//����� ���� �����
	{
		int sum = 0;
		for (int i = 0; i < counter; i++) {
			sum = sum + arr[i].getItemPriceForCinema()*arr[i].getQuantity();
		}
		System.out.println("Price for cinema total is : " + sum);
	}

	public void priceForClients()//����� ���� �����
	{
		int sum = 0;
		for (int i = 0; i < counter; i++) {
			sum = sum + arr[i].getItemPriceForClient()*arr[i].getQuantity();
		}
		System.out.println("Price for clients total is : " + sum);
	}

	public int howManyCountRefrigeratedItem(FoodTypeEnum name)//�������������� ��� ��� ����� ������ ������
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

	public int howManyCountFoodi(FoodTypeEnum name)//������ ������� ��� ��� ���� ������ ������
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
