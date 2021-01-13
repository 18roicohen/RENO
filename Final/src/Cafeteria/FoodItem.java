package Cafeteria;

import Enum.FoodTypeEnum;

public class FoodItem extends Item {//הצהרה על הורשה של מוצר מזון בקירור שיורש תכונות ממוצרים וממוצרי מזון
    protected Date productionDate; 
    protected Date expiryDate;

    public FoodItem(int cat, FoodTypeEnum name, int qun, Date productionDate,
    		Date expiryDate, double profitPercent) {
        super(cat, name, qun, profitPercent);
        this.productionDate = productionDate;
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        String str = "";
        str = super.toString() + ",\n\tp_date:" + productionDate.ToString()
        + ",\n\texpiryDate :" + expiryDate.ToString();
        return str;
    }
}
