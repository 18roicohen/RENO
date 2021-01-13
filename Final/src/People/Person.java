package People;

public abstract class Person {
	protected String id;
	protected String fName;
	protected String lName;

	public Person(String id, String fName, String lName) {//���� �����
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
	}

	public Person(Person other)//����� ����
	{
		this.id = other.id;
		this.fName = other.fName;
		this.lName = other.lName;

	}

	public String getId() {//�� �����
		return id;
	}

	public String getfName() {//���� �� �����
		return fName;
	}

	public void setfName(String fName) {//��� ���� �� �����
		this.fName = fName;
	}

	public String getlName() {//����� �� �����
		return lName;
	}

	public void setlName(String lName) {//��� ����� �� �����
		this.lName = lName;
	}


	public abstract String talk();//��������� ����� �����


	@Override//���� �� ����� �� �� �����
	public String toString() {
		return "Person \n\tID=" + id + ",\n\tFirst name = " + fName + ",\n\tLast nam = " + lName;
	}

	public Person(String id) {
		this.id = id;
		this.fName = "No First name";
		this.lName = "No Last name";
	}

}
