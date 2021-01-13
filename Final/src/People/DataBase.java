package People;

public class DataBase {//מחלקה יצירת
	private Person[] arr;
	private int count;
	private int maxPerson;

	/**
	 * contractor that get number of Person in Data Base
	 */
	public DataBase(int num) {
		arr = new Person[num];//מערך יצירת
		count = 0;
		this.maxPerson = num;
	}

	public void AddPerson(Person person) {
		if (count < maxPerson) {
			arr[count] = person;
			count++;
		}
	}

	public void printEmployee() {//נתונים לבסיס עובדם הכנסת
		String str = "";
		System.out.println("The workers are:");
		for (int i = 0; i < count; i++) {
			if (arr[i] instanceof Employee) {//עובדים למחלקת שיוך יש אם בדיקה
				str = arr[i].fName + " " + arr[i].lName + " ID:" + arr[i].id + "";
				System.out.println(str);
			}
		}
	}

	public void printClient() {//נתונים לבסיס מנויים הכנסת
		String str = "";
		System.out.println("The clients are:");
		for (int i = 0; i < count; i++) {
			if (arr[i] instanceof Client) {//מנויים למחלקת שיוך יש אם בדיקה
				str = arr[i].fName + " " + arr[i].lName + " ID:" + arr[i].id;
				System.out.println(str);
			}
		}
	}

	public void personTalk() {//שאמרו משפטים והדפסת שמירה
		String str = "";
		for (int i = 0; i < count; i++) {
			str = arr[i].talk();
			System.out.println(str);
		}
	}

	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i < count; i++) {
			str += arr[i].toString();
		}
		return str;
	}
}


