package People;

import Enum.EmpType;

public class Employee extends Person {// PERSON ממחלקת הורשה

	private EmpType workerType;
	private double hours;
	private String shift;

	public Employee(String id, String fName, String lName, EmpType workerType, double hours, String shift) {//בנאי יצירת
		super(id, fName, lName);
		this.workerType = workerType;
		this.hours = hours;
		this.shift = shift;
	}

	public String talk() {//עובד סוג לפי אבסטרקטית מחלקה מימוש
		switch(workerType){
		case Manager:
			return "Hi I am " + getfName() + " " + getlName() + " the manager, how may I assist you?";
		case Seller:
			return "Hi I am " + getfName() + " the seller, what movie would you like to see?";
		case Usher:
			return "Hi I am " + getfName() + " the usher, may I walk you to your seat?";
		}
		return "Thank you for coming to the cinema";
	}

	public double getFullSalary() {// עובד סוג לפי  ברוטו משכורת חיושב
		double salary = 1;
		if (workerType == EmpType.Manager) {
			salary = 60 * hours;
			if (hours > 180 && hours < 200)//נוספות שעות לפי חישוב
				salary += (200 - hours) * 1.25 * 60;
			else {
				if (hours > 200)
					salary += (hours - 200) * 1.5 * 60;
			}

		} else if (workerType == EmpType.Seller) {
			salary = 43 * hours;
			if (hours > 180 && hours < 200)//נוספות שעות לפי חישוב
				salary += (200 - hours) * 1.25 * 43;
			else {
				if (hours > 200)
					salary += (hours - 200) * 1.5 * 43;
			}
		} else if (workerType == EmpType.Usher) {
			salary = 36 * hours;
			if (hours > 180 && hours < 200)//נוספות שעות לפי חישוב
				salary += (200 - hours) * 1.25 * 36;
			else {
				if (hours > 200)
					salary += (hours - 200) * 1.5 * 36;
			}
		}
		return salary;
	}

	public double getSalaryWithoutTaxes() {//נטו משכורת חישוב
		double salary = getFullSalary();
		if (salary > 5300 && salary < 6500)
			salary = salary * 0.88;
		else if (salary < 8000)
			salary = salary * 0.82;
		else if (salary > 9000)
			salary = salary * 0.75;
		return salary;
	}

	@Override//וברוטו נטו משכורת הדפסת
	public String toString() {
		String str = "";
		str = super.toString() + ",\n\tFull salary:" + getFullSalary() + ",\n\tSalary without taxes :" + getSalaryWithoutTaxes()
		+ "\n\t===>Always working the " + shift + " shift\n";
		return str;
	}
}
