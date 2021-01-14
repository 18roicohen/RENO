package Cinema;

import Cafeteria.Cafeteria;
import Finance.Finance;
import Movies.Movie;
import Movies.TimeTable;
import People.DataBase;

public class Cinema {

	CinemaHall[] cinemaHallArray;
	Finance finance;
	Movie[] movies;
	String nameCinema;
	int numberCinemaHallArray;
	int numberMovies;
	public final static int MAX_NUMBER_OF_MOVIES = 10;
	/**
	 * Constructor
	 * @param finance of cinema
	 */
	public Cinema(Finance finance, String name) {
		this.finance = finance;
		this.numberCinemaHallArray = 0;
		this.numberMovies = 0;
		this.cinemaHallArray = new CinemaHall[10];
		this.movies = new Movie[MAX_NUMBER_OF_MOVIES];
		this.nameCinema = name;
	}

	/**
	 * Private method that return String of movies Array
	 * @return String
	 */
	//	private String[] toStringArrayMovies() {
	//
	//		String[] ans = new String[numberMovies];
	//		for (int i=0; i <numberMovies; i++) {
	//			ans[i] = movies[i].toString() ;
	//		}
	//		return ans;
	//	}

	/**
	 * Private method that return String of Cinema Hall Array
	 * @return String
	 */
	//	private String[] toStringArrayCinemaHallArray() {
	//		String[] ans = new String[numberCinemaHallArray];
	//		for (int i=0; i <numberCinemaHallArray; i++) {
	//			ans[i] = cinemaHallArray[i].toString() ;
	//
	//		}
	//		return ans;
	//	}

	@Override
	public String toString() {
		return "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n" +
				"               Welcome to " + nameCinema + "          \n" +
				"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n" +
				"\n~~~~~~~~~~~~~~~~~~~~~~~~~~" +
				"\n~~~~ The cinema Halls ~~~~" +
				"\n~~~~~~~~~~~~~~~~~~~~~~~~~~" + /*toStringArrayCinemaHallArray() +*/"\n" +
				"********************************\n" +
				"***** The movies that show *****\n" +
				"********************************" +/* toStringArrayMovies() +*/"\n\n" +
				"Have fun ! :)\n";
	}

	/**
	 * 
	 * @param CinemaHallParameter -
	 * @return -
	 */
	private boolean foundCinemaHall(CinemaHall CinemaHallParameter){
		boolean found = false;
		for (int i = 0; i <= this.numberCinemaHallArray; i++){
			if(this.cinemaHallArray [i] != null) {
				if(this.cinemaHallArray[i].equals(CinemaHallParameter)){
					found = true;
					break;
				}
			}
		}
		return found;
	}

	/**
	 * Add cinema hall to cinema
	 * limit of 10 cinema hall
	 * @param CinemaHallAdd - Cinema.Cinema hall add
	 */
	public String addCinemaHall(CinemaHall CinemaHallAdd){
		if(CinemaHallAdd != null && numberCinemaHallArray <10){
			if(foundCinemaHall(CinemaHallAdd) == false){
				// save the cinema hall
				this.cinemaHallArray[numberCinemaHallArray] = CinemaHallAdd;
				numberCinemaHallArray ++;
				return "The cinema hall added successfully!";
			}
			return "The cinema hall already exists in cinema " + this.nameCinema;
		}
		return "Wrong parameter or limit 10 cinema hall";
	}

	/**
	 * Add movie to  cinema
	 * limit of 10 movies
	 * @param movie - Movie to add to array of showing movies
	 * @return string
	 */
	public String addMovieToCinema(Movie movie){
		if (movie != null && numberMovies < MAX_NUMBER_OF_MOVIES){
			this.movies[numberMovies] = movie;
			numberMovies ++;
			return "The movie added successfully!";
		}
		return "Wrong parameter or limit 10 movies";
	}
	/**
	 * Add movie to  cinema
	 * limit of 10 movies
	 * @param movie - Movie to add to array of showing movies
	 * @return string
	 */
	public String addMovieToCinema(Movie movie, CinemaHall cinemaHall){
		if (cinemaHall != null  && movie != null && numberMovies < 10){
			if(foundCinemaHall(cinemaHall) == false){
				return "The cinema hall is not in cinema " +nameCinema;
			}
			this.movies[numberMovies] = movie;
			numberMovies ++;
			return "The movie added successfully!";
		}
		return "Wrong parameter or limit 10 movies";
	}

	public CinemaHall[] getCinemaHallArray() {
		return cinemaHallArray;
	}

	public Finance getFinance() {
		return finance;
	}

	public Movie[] getMovies() {
		return movies;
	}

	public String getNameCinema() {
		return nameCinema;
	}

	public int getNumberCinemaHallArray() {
		return numberCinemaHallArray;
	}

	public int getNumberMovies() {
		return numberMovies;
	}

	/**
	 * To be used only for final solution - MainCinemaRunFile
	 * **/
	private TimeTable timeTable;
	private Cafeteria cafeteria;
	private DataBase dataBase;

	public TimeTable getTimeTable() {
		return timeTable;
	}

	public void setTimeTable(TimeTable timeTable) {
		this.timeTable = timeTable;
	}

	public Cafeteria getCafeteria() {
		return cafeteria;
	}

	public void setCafeteria(Cafeteria cafeteria) {
		this.cafeteria = cafeteria;
	}

	public DataBase getDataBase() {
		return dataBase;
	}

	public void setDataBase(DataBase dataBase) {
		this.dataBase = dataBase;
	}
}
