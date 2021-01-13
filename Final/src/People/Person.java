package People;

public abstract class Person {
	protected String id;
	protected String fName;
	protected String lName;

	public Person(String id, String fName, String lName) {//בנאי יצירת
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
	}

	public Person(Person other)//העתקה בנאי
	{
		this.id = other.id;
		this.fName = other.fName;
		this.lName = other.lName;

	}

	public String getId() {//תז החזרה
		return id;
	}

	public String getfName() {//פרטי שם החזרת
		return fName;
	}

	public void setfName(String fName) {//חדש פרטי שם עדכון
		this.fName = fName;
	}

	public String getlName() {//משפחה שם החזרת
		return lName;
	}

	public void setlName(String lName) {//חדש משפחה שם עדכון
		this.lName = lName;
	}


	public abstract String talk();//אבסטרקטית מחלקה הגדרת


	@Override//פקטי שם משפחה שם תז הדפסה
	public String toString() {
		return "Person \n\tID=" + id + ",\n\tFirst name = " + fName + ",\n\tLast nam = " + lName;
	}

	public Person(String id) {
		this.id = id;
		this.fName = "No First name";
		this.lName = "No Last name";
	}

}
