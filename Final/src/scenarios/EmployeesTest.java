package scenarios;
import People.Employee;
import People.Client;
import Enum.ClientType;
import People.DataBase;
import Enum.EmpType;

public class EmployeesTest {

	public static void main(String[] args) 
	{
		Employee Emp1= new Employee("315770743", "Eden","Swisa", EmpType.Manager, 188, "morning");
		System.out.println(Emp1.toString());


		Employee Emp2= new Employee("315852364", "Oron","Mimon", EmpType.Seller, 176, "evening");
		System.out.println(Emp2.toString());

		Employee Emp3= new Employee("256358745", "Noa","Treves", EmpType.Usher, 192, "morning");
		System.out.println(Emp3.toString());

		System.out.println("---------------------------------------------------------");

		Client cl1= new Client("31585225", "Roi", "Cohen", ClientType.Student);
		System.out.println(cl1.toString());

		Client cl2= new Client("56825356", "Adir", "Ashtamker", ClientType.Regular);
		System.out.println(cl2.toString());

		Client cl3= new Client("589645", "Matan", "Swisa", ClientType.Solider);
		System.out.println(cl3.toString());

		Client cl4= new Client("26535452", "Avia", "David", ClientType.VeteranResident);
		System.out.println(cl4.toString());

		DataBase DB = new DataBase(30);
		DB.AddPerson(Emp1);
		DB.AddPerson(Emp2);
		DB.AddPerson(Emp3);
		DB.AddPerson(cl1);
		DB.AddPerson(cl2);
		DB.AddPerson(cl3);
		DB.AddPerson(cl4);

		System.out.println("------------------------ Printing Employees ---------------------------------");
		DB.printEmployee();
		System.out.println("------------------------ Done printing Employees ---------------------------------");
		System.out.println("------------------------ Printing Clients ---------------------------------");
		DB.printClient();
		System.out.println("------------------------ Done printing Clients ---------------------------------");
		System.out.println("------------------------ Printing talk() ---------------------------------");
		DB.personTalk();
		System.out.println("------------------------ Done printing talk() ---------------------------------");
		System.out.println("------------------------ Printing data from database ---------------------------------");
		System.out.println(DB.toString());
		System.out.println("------------------------ Done printing data from database ---------------------------------");
		System.out.println("------------------------ Printing talk from database ---------------------------------");
		DB.personTalk();
		System.out.println("------------------------ Done printing talk from database ---------------------------------");
	}
}
