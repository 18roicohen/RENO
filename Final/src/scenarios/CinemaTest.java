package scenarios;

import Enum.GenerMovieEnum;
import Enum.CinemaHallType;
import Cinema.Cinema;
import Cinema.CinemaHall;
import Finance.Finance;
import Movies.Movie;

public class CinemaTest {
	public static void main(String[] args) {

		int ticketCost = 30;

		Finance finance = new Finance(ticketCost);

		CinemaHall hall1 = new CinemaHall(1, 20, CinemaHallType.TwoD);
		CinemaHall hall2 = new CinemaHall(2, 10, CinemaHallType.ThreeD);
		CinemaHall hall3 = new CinemaHall(3, 20, CinemaHallType.TwoD);
		CinemaHall hall4 = new CinemaHall(4, 8, CinemaHallType.VIP);

		System.out.println("----------------- Create cinema name yes PLANET ---------");
		Cinema Cinema = new Cinema(finance,"yes PLANET");
		System.out.println(Cinema);

		System.out.println("----------------- Add hall to cinema ---------");
		System.out.println("** Add null - not added");
		System.out.println(Cinema.addCinemaHall(null));
		System.out.println();

		System.out.println("----------------- Add hall to cinema ---------");
		System.out.println("** type TwoD, numOfSeat = 10");
		Cinema.addCinemaHall(hall1);
		System.out.println(Cinema);

		Cinema.addCinemaHall(hall2);
		Cinema.addCinemaHall(hall3);
		Cinema.addCinemaHall(hall4);
		System.out.println(Cinema);

		System.out.println("----------------- Add hall to cinema ---------");
		System.out.println("** Add cinema hall that found in cinema");
		System.out.println(Cinema.addCinemaHall(hall4));
		System.out.println();

		System.out.println("----------------- Add movie to cinema ---------");
		System.out.println("** Add movie with null cinema hall");
		System.out.println("----------------- Try Adding movie 'Titanic' to cinema but fail ------------");
		System.out.println(Cinema.addMovieToCinema(new Movie("Titanic", 2, 1992, GenerMovieEnum.Drama, 2), null));
		System.out.println();

		System.out.println("----------------- Add movie to cinema ---------");
		System.out.println("** Add movie with cinema hall that doesn't exist");
		CinemaHall hall5 = new CinemaHall(1, 10, CinemaHallType.TwoD);
		System.out.println("----------------- Try Adding movie 'GTA' to cinema but fail ------------");
		System.out.println(Cinema.addMovieToCinema(new Movie("Gta", 3, 1995, GenerMovieEnum.Drama, 1), hall5));
		System.out.println();

		System.out.println("----------------- Add movie 'Borat' to cinema ------------");
		System.out.println(Cinema.addMovieToCinema(new Movie("Borat", 1, 2006, GenerMovieEnum.Comedy, 1), hall1));
		System.out.println();

		System.out.println("----------------- Print cinema ------------");
		System.out.println(Cinema);
		System.out.println("----------------- Save seats--------------");
		System.out.println(hall4);

		System.out.println("Trying to buy 20 seats in hall 4");
		boolean successSaving = hall4.buySeats(20);

		if (successSaving) {
			System.out.println("Success");
		} else {
			System.out.println("Failed, probably no space");
		}

		System.out.println("After failed");
		System.out.println(hall4);

		System.out.println();

		System.out.println("Trying to buy 4 seats in hall 4");
		successSaving = hall4.buySeats(4);

		if (successSaving) {
			System.out.println("Success");
		} else {
			System.out.println("Failed, probably no space");
		}
		System.out.println("After success");
		System.out.println(hall4);
 
		System.out.println();

		System.out.println("Trying to buy last 4 seats in hall 4 and show that hall is full");
		successSaving = hall4.buySeats(4);

		if (successSaving) {
			System.out.println("Success");
		} else {
			System.out.println("Failed, probably no space");
		}
		System.out.println("After success");
		System.out.println(hall4);
	}
}