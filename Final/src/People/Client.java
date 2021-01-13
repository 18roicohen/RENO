package People;

import Enum.ClientType;

public class Client extends Person {// PERSON ������ �����
	private ClientType type;

	public Client(String id, String fName, String lName, ClientType type) {//���� �����
		super(id, fName, lName);
		this.type = type;
	}

	public Client(Person other, ClientType type) {//����� ���� �����
		super(other);
		this.type = type;
	}

	public String talk() {//��������� ����� �����
		return "Hi I am a " + type.name() + " customer do I deserve a discount?";
	}

	public ClientType getType() {//���� ��� �����
		return type;
	}

	@Override//���� ��� �����
	public String toString() {
		String str = "";
		str = super.toString() + "\n\tType is - " + type + "\n";
		return str;
	}
}

