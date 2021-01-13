package Cafeteria;

import Enum.FoodTypeEnum;

public class Item {
    protected double profitPercent;
    protected int catalogueNumber; //����� ����� ���� �����
    protected FoodTypeEnum name;//����� ����� ENUM ��
    protected int quantity;//����� ����� ����
    protected int itemPriceForCinema;//����� ����� ����
    protected int itemPriceForClient;//����� ����� ����

    public Item(int cat, FoodTypeEnum name, int quantity, double profitPercent)//���� �������
    {
        this.catalogueNumber = cat;
        this.name = name;
        this.quantity = quantity;
        this.profitPercent = profitPercent;
        this.itemPriceForCinema = calculatePriceForCinema();
        this.itemPriceForClient = calculatePriceForClient();
    }

    public int calculatePriceForCinema() {
        int value = calculatePriceForClient();// for 1 popcorn - client pays 25 NIS
        double valueWithoutProfit = (1 - profitPercent)*value;// for 1 popcorn - cinema pays (1-0.9)*25
        return (int) valueWithoutProfit;
    }

    public Item(Item other)//���� �����
    {
        catalogueNumber = other.catalogueNumber;
        name = other.name;
        quantity = other.quantity;
        itemPriceForCinema = other.itemPriceForCinema;
        itemPriceForClient = other.itemPriceForClient;
    }

    public FoodTypeEnum getType() {
        return name;
    }

    public void setD(FoodTypeEnum d) {//Setters
        this.name = d;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getItemPriceForCinema() {
        return itemPriceForCinema;
    }

    public int calculatePriceForClient() {//������� ������ ����
        int priceItem = 0;
        switch (this.name) {
            case Water:
                priceItem = 5;
                break;
            case AmericanIceCream:
            case Kinder:
            case Kitkat:
            case Mars:
                priceItem = 8;
                break;
            case Cola:
            case Magnum:
                priceItem = 15;
                break;
            case BenAndJerry:
                priceItem = 20;
                break;
            case Popcorn:
                priceItem = 25;
                break;
        }
        return priceItem;
    }

    public int getItemPriceForClient() {
        return itemPriceForClient;
    }

    @Override
    public String toString() {//���� ������� ������ �� �� ��������
        return "Item:\n\tcatalogueNumber = " + catalogueNumber + ",\n\tname = " + name + ",\n\tquantity = " + quantity
                + ",\n\titemPriceForCinema = " + itemPriceForCinema + ",\n\titemPriceForClient = " + itemPriceForClient + "";
    }
}
