package Cafeteria;

import Enum.FoodTypeEnum;

public class RefrigeratedItem extends FoodItem {//הצהרה על הורשה של מוצר מזון שיורש תכונות ממוצרים

    private int minTemperature;
    private int maxTemperature;
    

    public RefrigeratedItem(int cat, FoodTypeEnum name, int qun, Date productionDate, Date expiryDate,
                            int minTemperature, int maxTemperature) {
        super(cat, name, qun, productionDate, expiryDate, 0.2);////תכונות שירשו ממחלקות האב
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
    }

    @Override
    public String toString() {
        {
            return (super.toString() + ",\n\tMintmp is: " + minTemperature + "\n\tmaxtmp is: " + maxTemperature);
        }
    }
}
