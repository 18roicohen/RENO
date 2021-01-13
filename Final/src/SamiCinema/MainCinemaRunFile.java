package SamiCinema;

import Cafeteria.Cafeteria;
import Cafeteria.Date;
import Cafeteria.Item;
import Cafeteria.FoodItem;
import Cafeteria.RefrigeratedItem;
import Cinema.Cinema;
import Cinema.CinemaHall;
import Finance.Finance;
import Movies.Movie;
import Enum.GenerMovieEnum;
import Enum.ProductionJobEnum;
import Enum.EmpType;
import Enum.FoodTypeEnum;
import Enum.ClientType;
import Enum.CinemaHallType;
import Movies.Production;
import Movies.TimeTable;
import People.Client;
import People.DataBase;
import People.Employee;

import java.util.Random;

public class MainCinemaRunFile {

	public static void main(String[] args) {
		// data holders
		CinemaHall[] cinemaHallsArr = new CinemaHall[4];
		Movie[] moviesArr = new Movie[10];
		Employee[] employeesArr = new Employee[7];
		Client[] clientsArr = new Client[21];
		TimeTable moviesTimeTable = new TimeTable();
		DataBase dataBase = new DataBase(100);
		Finance financeSystem = new Finance(30);// divides good with 0.5, 0.6, 0.8
		Cinema cinema = new Cinema(financeSystem, "Sami Cinema");
		Cafeteria cafeteria = new Cafeteria(350);

		/* create functions */
		createCinemaHallsList(cinemaHallsArr);
		// now halls were created

		addHallsToCinema(cinema, cinemaHallsArr);
		// cinema now have new halls set inside

		createMovieList(moviesArr);
		// movies are created and inside array

		addMoviesToCinema(cinema, moviesArr);
		// now cinema has all of the movies from the moviesArr array

		createEmployeeList(employeesArr, dataBase);
		// now employeesArr is filled with employees, as well as the Database

		createClientsList(clientsArr, dataBase);
		// now clientsArr is filled with clients, as well as the Database

		createCafeteria(cafeteria);
		//now cafeteria is filled with products

		cinema.setCafeteria(cafeteria);
		//now the ciname is stocked with the products of the cafeteria

		setTimeTableWithMoviesAndPrint(moviesArr, moviesTimeTable);
		// fills the timetable with movies

		cinema.setTimeTable(moviesTimeTable);
		//now the cinema has the filled timetable

		cinema.setDataBase(dataBase);
		//now the cinema has the database

		/*Prints*/
		printMoviesAndHalls(cinema);
		printTimeTable(moviesTimeTable);
		printDataBase(dataBase);
		printCafeteria(cinema.getCafeteria());

		/* starting to buy stuff */
		// start buying tickets
		buyNumberOfTickets(cinema, clientsArr);

		// see how much is the income
		printCinemaIncomeOutCome(cinema);

		// buy some cafeteria products
		buyCafeteriaProducts(cinema);

		// see what is left in the cafeteria
		printCafeteria(cinema.getCafeteria());

		// see how much is the income
		printCinemaIncomeOutCome(cinema);

		// make clients talk
		makeConversationBetweenClientsAndEmployees(clientsArr, employeesArr);
	}

	private static void buyCafeteriaProducts(Cinema cinema) {
		Cafeteria cafeteria = cinema.getCafeteria();
		Finance finance = cinema.getFinance();
		Item item = cafeteria.getItemByType(FoodTypeEnum.Popcorn);
		System.out.println("A client is asking to buy 3 " + FoodTypeEnum.Popcorn.name());
		if (item != null && cafeteria.buyItemByType(FoodTypeEnum.Popcorn, 3)) {
			cafeteria.buyItemByType(FoodTypeEnum.Popcorn, 3);
			finance.boughtItemFromCafeteria(item,3);
			System.out.println("success");
		}
		else {
			System.out.println("Sorry not enough " + FoodTypeEnum.Popcorn.name());
		}
		System.out.println("A client is asking to buy 3 " + FoodTypeEnum.BenAndJerry.name());
		item = cafeteria.getItemByType(FoodTypeEnum.BenAndJerry);
		if (item != null && cafeteria.buyItemByType(FoodTypeEnum.BenAndJerry, 3)) {
			cafeteria.buyItemByType(FoodTypeEnum.BenAndJerry, 3);
			finance.boughtItemFromCafeteria(item, 3);
			System.out.println("success");
		}
		else {
			System.out.println("Sorry not enough " + FoodTypeEnum.BenAndJerry.name());
		}
		System.out.println("A client is asking to buy 120 " + FoodTypeEnum.BenAndJerry.name());
		item = cafeteria.getItemByType(FoodTypeEnum.BenAndJerry);
		if (item != null && cafeteria.buyItemByType(FoodTypeEnum.BenAndJerry, 120)) {
			finance.boughtItemFromCafeteria(item, 120);
			System.out.println("success");
		}
		else {
			System.out.println("Sorry not enough " + FoodTypeEnum.BenAndJerry.name());
		}
		System.out.println("A client is asking to buy 1 " + FoodTypeEnum.Kitkat.name());
		item = cafeteria.getItemByType(FoodTypeEnum.Kitkat);
		if (item != null && cafeteria.buyItemByType(FoodTypeEnum.BenAndJerry, 1)) {
			cafeteria.buyItemByType(FoodTypeEnum.Kitkat, 1);
			finance.boughtItemFromCafeteria(item, 1);
			System.out.println("success");
		}
		else {
			System.out.println("Sorry not enough " + FoodTypeEnum.Kitkat.name());
		}
		System.out.println("A client is asking to buy 2 " + FoodTypeEnum.Mars.name());
		item = cafeteria.getItemByType(FoodTypeEnum.Mars);
		if (item != null && cafeteria.buyItemByType(FoodTypeEnum.BenAndJerry, 2)) {
			cafeteria.buyItemByType(FoodTypeEnum.Mars, 2);
			finance.boughtItemFromCafeteria(item,2);
			System.out.println("success");
		}
		else {
			System.out.println("Sorry not enough " + FoodTypeEnum.Mars.name());
		}
		System.out.println("A client is asking to buy 5 " + FoodTypeEnum.Cola.name());
		item = cafeteria.getItemByType(FoodTypeEnum.Cola);
		if (item != null && cafeteria.buyItemByType(FoodTypeEnum.BenAndJerry, 5)) {
			cafeteria.buyItemByType(FoodTypeEnum.Cola, 5);
			finance.boughtItemFromCafeteria(item,5);
			System.out.println("success");
		}
		else {
			System.out.println("Sorry not enough " + FoodTypeEnum.Mars.name());
		}
	}

	private static void makeConversationBetweenClientsAndEmployees(Client[] clientsArr, Employee[] employeesArr) {
		System.out.println("******************************************************************");
		System.out.println("********************** Printing conversation *********************");
		System.out.println("******************************************************************");
		int randomNumber = (int) (Math.random()* employeesArr.length);
		for (int i = 0; i < clientsArr.length; i++) {
			Employee randomEmployee = employeesArr[randomNumber];
			System.out.println(randomEmployee.talk());
			System.out.println(clientsArr[i].talk());
		}
		System.out.println("********************* Done with conversation *********************");
	}

	private static void printCinemaIncomeOutCome(Cinema cinema) {
		System.out.println("Total money earned until now:");
		System.out.println(cinema.getFinance().getIncomeOutcome().getSummery());
		System.out.println("-----------------------------");
	}

	private static void buyNumberOfTickets(Cinema cinema, Client[] clientsArr) {
		System.out.println();
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("+++++++++++++++++++++ Buying tickets ++++++++++++++++++++++++++");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

		// buy 3 tickets
		int tickets = 3;
		System.out.println(clientsArr[10] + "\t\t\t\t\t=======>is trying to buy " + tickets + " tickets from Hall "
				+ cinema.getCinemaHallArray()[1].getHallNumber() + "\n");
		if(cinema.getCinemaHallArray()[1].buySeats(tickets)){
			cinema.getFinance().buyTickets(tickets, clientsArr[10].getType());
			System.out.println(cinema.getCinemaHallArray()[1]);
			System.out.println(clientsArr[10].getfName() + " succeeded\n");
		}
		else {
			System.out.println("FAILED!!!\n");
		}

		// buy 5 tickets
		tickets = 5;
		System.out.println(clientsArr[1] + "\t\t\t\t\t=======>is trying to buy " + tickets + " tickets from Hall "
				+ cinema.getCinemaHallArray()[1].getHallNumber() + "\n");
		if(cinema.getCinemaHallArray()[1].buySeats(tickets)){
			cinema.getFinance().buyTickets(tickets, clientsArr[1].getType());
			System.out.println(cinema.getCinemaHallArray()[1]);
			System.out.println(clientsArr[1].getfName() + " succeeded\n");
		}
		else {
			System.out.println("FAILED!!!\n");
		}

		// buy 6 tickets
		tickets = 6;
		System.out.println(clientsArr[13] + "\t\t\t\t\t=======>is trying to buy " + tickets + " tickets from Hall "
				+ cinema.getCinemaHallArray()[1].getHallNumber() + "\n");
		if(cinema.getCinemaHallArray()[1].buySeats(tickets)){
			cinema.getFinance().buyTickets(tickets, clientsArr[13].getType());
			System.out.println(cinema.getCinemaHallArray()[1]);
			System.out.println(clientsArr[13].getfName() + " succeeded\n");
		}
		else {
			System.out.println("FAILED!!!\n");
		}

		// buy 4 tickets
		tickets = 4;
		System.out.println(clientsArr[6] + "\t\t\t\t\t=======>is trying to buy " + tickets + " tickets from Hall "
				+ cinema.getCinemaHallArray()[1].getHallNumber() + "\n");
		if(cinema.getCinemaHallArray()[1].buySeats(tickets)){
			cinema.getFinance().buyTickets(tickets, clientsArr[6].getType());
			System.out.println(cinema.getCinemaHallArray()[1]);
			System.out.println(clientsArr[6].getfName() + " succeeded\n");
		}
		else {
			System.out.println("FAILED!!!\n");
		}

		// buy 4 tickets
		System.out.println(clientsArr[6] + "\t\t\t\t\t=======>is trying to buy " + tickets + " tickets from Hall "
				+ cinema.getCinemaHallArray()[3].getHallNumber() + "\n");
		if(cinema.getCinemaHallArray()[3].buySeats(tickets)){
			cinema.getFinance().buyTickets(tickets, clientsArr[6].getType());
			System.out.println(cinema.getCinemaHallArray()[3]);
			System.out.println(clientsArr[6].getfName() + " succeeded\n");
		}
		else {
			System.out.println("FAILED!!!\n");
		}

		// buy 2 tickets
		tickets = 2;
		System.out.println(clientsArr[19] + "\t\t\t\t\t=======>is trying to buy " + tickets + " tickets from Hall "
				+ cinema.getCinemaHallArray()[3].getHallNumber() + "\n");
		if(cinema.getCinemaHallArray()[3].buySeats(tickets)){
			cinema.getFinance().buyTickets(tickets, clientsArr[19].getType());
			System.out.println(cinema.getCinemaHallArray()[3]);
			System.out.println(clientsArr[19].getfName() + " succeeded\n");
		}
		else {
			System.out.println("FAILED!!!\n");
		}

		// buy 2 tickets
		tickets = 2;
		System.out.println(clientsArr[4] + "\t\t\t\t\t=======>is trying to buy " + tickets + " tickets from Hall "
				+ cinema.getCinemaHallArray()[3].getHallNumber() + "\n");
		if(cinema.getCinemaHallArray()[3].buySeats(tickets)){
			cinema.getFinance().buyTickets(tickets, clientsArr[4].getType());
			System.out.println(cinema.getCinemaHallArray()[3]);
			System.out.println(clientsArr[4].getfName() + " succeeded\n");
		}
		else {
			System.out.println("FAILED!!!\n");
		}

		// buy 2 tickets
		tickets = 4;
		System.out.println(clientsArr[15] + "\t\t\t\t\t=======>is trying to buy " + tickets + " tickets from Hall "
				+ cinema.getCinemaHallArray()[3].getHallNumber() + "\n");
		if(cinema.getCinemaHallArray()[3].buySeats(tickets)){
			cinema.getFinance().buyTickets(tickets, clientsArr[15].getType());
			System.out.println(cinema.getCinemaHallArray()[3]);
			System.out.println(clientsArr[15].getfName() + " succeeded\n");
		}
		else {
			System.out.println("FAILED!!!\n");
		}
		System.out.println("+++++++++++++++++++ Done buying tickets ++++++++++++++++++++++++++");
	}

	private static void printCafeteria(Cafeteria cafeteria) {
		System.out.println("\n//////////////// Printing cafeteria //////////////////////////");
		System.out.println(cafeteria);
		cafeteria.getOnlyFoodiItems();
		System.out.println();
		cafeteria.getOnlyRefrigeratorItems();
		System.out.println();
		cafeteria.sumOfTotalQuantityCount();
		System.out.println();
		System.out.println("////////////////// Done printing cafeteria /////////////////////");
	}

	private static void createCafeteria(Cafeteria cafeteria) {
		FoodItem f1 = new FoodItem(500, FoodTypeEnum.Popcorn, 86, new Date(1, 3, 20),
				new Date(1, 3, 21), 0.9);
		FoodItem f2 = new FoodItem(501, FoodTypeEnum.Kitkat, 24, new Date(23, 10, 20),
				new Date(11, 4, 21), 0.19);
		FoodItem f3 = new FoodItem(502, FoodTypeEnum.Kinder, 24, new Date(30, 11, 20),
				new Date(23, 7, 21), 0.2);
		FoodItem f4 = new FoodItem(503, FoodTypeEnum.Mars, 24, new Date(24, 2, 20),
				new Date(19, 4, 21), 0.25);
		RefrigeratedItem s1 = new RefrigeratedItem(505, FoodTypeEnum.Magnum, 36, new Date(15, 8, 20),
				new Date(15, 10, 22), -10, 2);
		RefrigeratedItem s2 = new RefrigeratedItem(506, FoodTypeEnum.Cola, 48, new Date(21, 10, 20),
				new Date(21, 10, 22), -5, 6);
		RefrigeratedItem s3 = new RefrigeratedItem(507, FoodTypeEnum.AmericanIceCream, 72, new Date(13, 5, 20),
				new Date(13, 5, 21), -15, 0);
		RefrigeratedItem s4 = new RefrigeratedItem(508, FoodTypeEnum.BenAndJerry, 36, new Date(23, 2, 20),
				new Date(23, 2, 21), -15, 2);

		cafeteria.addItem(f1);
		cafeteria.addItem(f2);
		cafeteria.addItem(f3);
		cafeteria.addItem(f4);
		cafeteria.addItem(s1);
		cafeteria.addItem(s2);
		cafeteria.addItem(s3);
		cafeteria.addItem(s4);
	}

	private static void printDataBase(DataBase dataBase) {
		System.out.println("------------------ Printing the database ---------------------------");
		System.out.println(dataBase);
		System.out.println("--------------------------------------------------------------------");
	}

	private static void printTimeTable(TimeTable moviesTimeTable) {
	}

	private static void printMoviesAndHalls(Cinema cinema) {
		System.out.println(cinema);
	}

	private static void setTimeTableWithMoviesAndPrint(Movie[] moviesArr, TimeTable moviesTimeTable) {
		int i = 0;
		moviesTimeTable.setMovie(moviesArr[i], 0);
		i++;
		moviesTimeTable.setMovie(moviesArr[i], 0);
		i++;
		moviesTimeTable.setMovie(moviesArr[i], 0);
		i++;
		moviesTimeTable.setMovie(moviesArr[i], 1);
		i++;
		moviesTimeTable.setMovie(moviesArr[i], 1);
		i++;
		moviesTimeTable.setMovie(moviesArr[i], 1);
		i++;
		moviesTimeTable.setMovie(moviesArr[i], 1);
		i++;
		moviesTimeTable.setMovie(moviesArr[i], 2);
		i++;
		moviesTimeTable.setMovie(moviesArr[i], 2);
		i++;
		moviesTimeTable.setMovie(moviesArr[0], 2);
		moviesTimeTable.setMovie(moviesArr[i], 3);
		i = 0;
		moviesTimeTable.setMovie(moviesArr[i], 3);
		moviesTimeTable.setMovie(moviesArr[7], 3);
		i++;
		moviesTimeTable.setMovie(moviesArr[i], 4);
		i++;
		moviesTimeTable.setMovie(moviesArr[i], 4);
		i++;
		moviesTimeTable.setMovie(moviesArr[i], 4);
		i++;
		moviesTimeTable.setMovie(moviesArr[i], 4);
		i = 0;
		moviesTimeTable.setMovie(moviesArr[i], 5);
		i++;
		moviesTimeTable.setMovie(moviesArr[i], 5);
		i++;
		moviesTimeTable.setMovie(moviesArr[i], 5);
		i++;
		moviesTimeTable.setMovie(moviesArr[i], 6);
		i++;
		moviesTimeTable.setMovie(moviesArr[i], 6);
		i++;
		moviesTimeTable.setMovie(moviesArr[i], 6);
		i++;
		moviesTimeTable.setMovie(moviesArr[i], 6);
	}

	private static void createCinemaHallsList(CinemaHall[] cinemaHallsArr) {
		CinemaHall hall1 = new CinemaHall(1, 20, CinemaHallType.TwoD);
		CinemaHall hall2 = new CinemaHall(2, 10, CinemaHallType.ThreeD);
		CinemaHall hall3 = new CinemaHall(3, 20, CinemaHallType.TwoD);
		CinemaHall hall4 = new CinemaHall(4, 8, CinemaHallType.VIP);

		cinemaHallsArr[0] = hall1;
		cinemaHallsArr[1] = hall2;
		cinemaHallsArr[2] = hall3;
		cinemaHallsArr[3] = hall4;
	}

	private static void addHallsToCinema(Cinema cinema, CinemaHall[] halls) {
		for (int i = 0; i < halls.length; i++) {
			cinema.addCinemaHall(halls[i]);
		}
	}

	private static void addMoviesToCinema(Cinema cinema, Movie[] moviesArr) {
		for (int i = 0; i < moviesArr.length; i++) {
			if (i < cinema.MAX_NUMBER_OF_MOVIES) {
				cinema.addMovieToCinema(moviesArr[i]);
			}
		}
	}

	private static void createClientsList(Client[] clientsArr, DataBase dataBase) {
		int id = 0;
		Client client1 = new Client(getRandomId(), "Bugs", "Bunny", ClientType.Regular);
		clientsArr[id] = client1;
		dataBase.AddPerson(client1);
		id++;

		Client client2 = new Client(getRandomId(), "Daffy", "Duck", ClientType.Regular);
		clientsArr[id] = client2;
		dataBase.AddPerson(client2);
		id++;

		Client client3 = new Client(getRandomId(), "Porky", "Pig", ClientType.Solider);
		clientsArr[id] = client3;
		dataBase.AddPerson(client3);
		id++;

		Client client4 = new Client(getRandomId(), "Sylvester", "Not Stallone", ClientType.Solider);
		clientsArr[id] = client4;
		dataBase.AddPerson(client4);
		id++;

		Client client5 = new Client(getRandomId(), "Elmer", "Fudd", ClientType.Solider);
		clientsArr[id] = client5;
		dataBase.AddPerson(client5);
		id++;

		Client client6 = new Client(getRandomId(), "Speedy", "Gonzales", ClientType.Student);
		clientsArr[id] = client6;
		dataBase.AddPerson(client6);
		id++;

		Client client7 = new Client(getRandomId(), "Tweety", "Bird", ClientType.VeteranResident);
		clientsArr[id] = client7;
		dataBase.AddPerson(client7);
		id++;

		Client client8 = new Client(getRandomId(), "Yosemite", "Sam", ClientType.Regular);
		clientsArr[id] = client8;
		dataBase.AddPerson(client8);
		id++;

		Client client9 = new Client(getRandomId(), "Tasmanian", "Devil", ClientType.Regular);
		clientsArr[id] = client9;
		dataBase.AddPerson(client9);
		id++;

		Client client10 = new Client(getRandomId(), "Martian", "Marvin", ClientType.Regular);
		clientsArr[id] = client10;
		dataBase.AddPerson(client10);
		id++;

		Client client11 = new Client(getRandomId(), "Lola", "Bunny", ClientType.Regular);
		clientsArr[id] = client11;
		dataBase.AddPerson(client11);
		id++;

		Client client12 = new Client(getRandomId(), "Wile E.", "Coyote", ClientType.Regular);
		clientsArr[id] = client12;
		dataBase.AddPerson(client12);
		id++;

		Client client13 = new Client(getRandomId(), "Bugs", "Bunny", ClientType.Regular);
		clientsArr[id] = client13;
		dataBase.AddPerson(client13);
		id++;

		Client client14 = new Client(getRandomId(), "Franklin", "Turtle", ClientType.Regular);
		clientsArr[id] = client14;
		dataBase.AddPerson(client14);
		id++;

		Client client15 = new Client(getRandomId(), "Tom", "Cat", ClientType.Regular);
		clientsArr[id] = client15;
		dataBase.AddPerson(client15);
		id++;

		Client client16 = new Client(getRandomId(), "Jerry", "Mouse", ClientType.Regular);
		clientsArr[id] = client16;
		dataBase.AddPerson(client16);
		id++;

		Client client17 = new Client(getRandomId(), "April", "O'niel", ClientType.Regular);
		clientsArr[id] = client17;
		dataBase.AddPerson(client17);
		id++;

		Client client18 = new Client(getRandomId(), "Michelangelo", "Pizza", ClientType.Regular);
		clientsArr[id] = client18;
		dataBase.AddPerson(client18);
		id++;

		Client client19 = new Client(getRandomId(), "Leonardo", "Pizza", ClientType.Regular);
		clientsArr[id] = client19;
		dataBase.AddPerson(client19);
		id++;

		Client client20 = new Client(getRandomId(), "Donatello", "Pizza", ClientType.Regular);
		clientsArr[id] = client20;
		dataBase.AddPerson(client20);
		id++;

		Client client21 = new Client(getRandomId(), "Raphael", "Pizza", ClientType.Regular);
		clientsArr[id] = client21;
		dataBase.AddPerson(client21);
	}

	private static void createEmployeeList(Employee[] employsArr, DataBase dataBase) {
		int id = 0;
		Employee emp1 = new Employee(getRandomId(), "Tony", "Stark", EmpType.Manager,190, "Morning");
		employsArr[id] = emp1;
		dataBase.AddPerson(emp1);
		id++;

		Employee emp2 = new Employee(getRandomId(), "Bruce", "Banner", EmpType.Seller,160, "Evening");
		employsArr[id] = emp2;
		dataBase.AddPerson(emp2);
		id++;

		Employee emp3 = new Employee(getRandomId(), "Natasha", "Romanoff", EmpType.Seller,170, "Evening");
		employsArr[id] = emp3;
		dataBase.AddPerson(emp3);
		id++;

		Employee emp4 = new Employee(getRandomId(), "Thor", "Odinsen", EmpType.Usher,183, "Evening");
		employsArr[id] = emp4;
		dataBase.AddPerson(emp4);
		id++;

		Employee emp5 = new Employee(getRandomId(), "Steve", "Rogers", EmpType.Manager,168, "Morning");
		employsArr[id] = emp5;
		dataBase.AddPerson(emp5);
		id++;

		Employee emp6 = new Employee(getRandomId(), "Clint", "Barton", EmpType.Usher,150, "Morning");
		employsArr[id] = emp6;
		dataBase.AddPerson(emp6);
		id++;

		Employee emp7 = new Employee(getRandomId(), "James", "Rhodes", EmpType.Seller,190, "Morning");
		employsArr[id] = emp7;
		dataBase.AddPerson(emp7);
	}

	private static String getRandomId() {
		String id = "";
		int result = 0;
		result = createRandomTenDigitNumber();
		if(result < 0) {
			result*=-1;
		}
		id = String.valueOf(result);
		return id;
	}

	private static int createRandomTenDigitNumber() {
		int result = 0;
		Random randNum = new Random();
		for(int i = 0; i < 10; i++) {
			result = result * 10 + (randNum.nextInt(9) + 1);
		}
		return result;
	}

	private static void createMovieList(Movie[] moviesArr) {
		int id = 0;
		Movie m1 = new Movie("GTA", 3, 1995, GenerMovieEnum.Drama, id);
		m1.setRating(new int[]{3, 4, 3, 5, 4});
		Production p1 = new Production(ProductionJobEnum.Actor, "Trevor philips","Carl Jhonson");
		m1.setProductionCast(p1);
		moviesArr[id] = m1;
		id++;

		Movie m2 = new Movie("Titanic", 2, 1992, GenerMovieEnum.Drama, id);
		m2.setRating(new int[]{3, 4, 1, 2, 3});
		Production p2 = new Production(ProductionJobEnum.Actor, "Leonardo DiCaprio","James Cameron");
		m2.setProductionCast(p2);
		moviesArr[id] = m2;
		id++;

		Movie m3 = new Movie("Annabelle", 3, 2018, GenerMovieEnum.Horror, id);
		m3.setRating(new int[]{5, 4, 3, 5, 5});
		Production p3 = new Production(ProductionJobEnum.Director, "Annabelle Wallis","Peter Safran");
		m3.setProductionCast(p3);
		moviesArr[id] = m3;
		id++;

		Movie m4 = new Movie("The Lion king", 1, 1995, GenerMovieEnum.Drama, id);
		m4.setRating(new int[]{5, 1, 5, 5, 2});
		Production p4 = new Production(ProductionJobEnum.Actor, "Jonathan Taylor Thomas","Don Hahn");
		m4.setProductionCast(p4);
		moviesArr[id] = m4;
		id++;

		Movie m5 = new Movie("Joker", 2, 2019, GenerMovieEnum.Horror, id);
		m5.setRating(new int[]{1, 1, 3, 2, 4});
		Production p5 = new Production(ProductionJobEnum.Actor, "Joaquin Phoenix","Todd Phillips");
		m5.setProductionCast(p5);
		moviesArr[id] = m5;
		id++;

		Movie m6 = new Movie("Borat", 1, 2006, GenerMovieEnum.Comedy, id);
		m6.setRating(new int[]{5, 1, 3, 3, 4});
		Production p6 = new Production(ProductionJobEnum.Director, "Sacha Baron Cohen","Jay Roach");
		m6.setProductionCast(p6);
		moviesArr[id] = m6;
		id++;

		Movie m7 = new Movie("Mean Girls", 2, 2004, GenerMovieEnum.Horror, id);
		m7.setRating(new int[]{5, 4, 3, 2, 1});
		Production p7 = new Production(ProductionJobEnum.Director, "Lindsay Lohan","Lorne Michaels");
		m7.setProductionCast(p7);
		moviesArr[id] = m7;
		id++;

		Movie m8 = new Movie("Ted", 3, 2016, GenerMovieEnum.Comedy, id);
		m8.setRating(new int[]{1, 4, 3, 2, 2});
		Production p8 = new Production(ProductionJobEnum.Director, "Mila Kunis","Seth MacFarlane");
		m8.setProductionCast(p8);
		moviesArr[id] = m8;
		id++;

		Movie m9 = new Movie("The Nun", 3, 2018, GenerMovieEnum.Horror, id);
		m9.setRating(new int[]{5, 4, 3, 4, 4});
		Production p9 = new Production(ProductionJobEnum.Director, "Taissa Farmiga","Peter Safran");
		m9.setProductionCast(p9);
		moviesArr[id] = m9;
		id++;

		Movie m10 = new Movie("Holidate", 2, 2020, GenerMovieEnum.Horror, id);
		m10.setRating(new int[]{5, 4, 3, 2, 2});
		Production p10 = new Production(ProductionJobEnum.Director, "Emma Roberts","Mary Viola");
		m10.setProductionCast(p10);
		moviesArr[id] = m10;
	}
}
