package People;

import Enum.ClientType;

public class Client extends Person {// PERSON ממחלקת הורשה
	private ClientType type;

	public Client(String id, String fName, String lName, ClientType type) {//בנאי יצירת
		super(id, fName, lName);
		this.type = type;
	}

	public Client(Person other, ClientType type) {//העתקה בנאי יצירת
		super(other);
		this.type = type;
	}

	public String talk() {//אבסטרקטית מחלקה מימוש
		return "Hi I am a " + type.name() + " customer do I deserve a discount?";
	}

	public ClientType getType() {//מנוי סוג החזרת
		return type;
	}

	@Override//מנוי סוג הדפסת
	public String toString() {
		String str = "";
		str = super.toString() + "\n\tType is - " + type + "\n";
		return str;
	}
}

