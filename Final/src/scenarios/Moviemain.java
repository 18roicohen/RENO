package scenarios;

import Movies.Movie;
import Movies.Production;
import Movies.TimeTable;
import Enum.ProductionJobEnum;
import Enum.GenerMovieEnum;


public class Moviemain {


    public static void main(String[] args) {
        printMovies();
        createTimeTable();
    }

    private static void createTimeTable() {//יצירת רשימת סרטים ללוח סרטים
        Movie m1 = new Movie("Gta", 3, 1995, GenerMovieEnum.Drama, 1);
        m1.setRating(new int[]{3, 4, 3, 5, 4});

        Movie a1 = new Movie("Titanic", 2, 1992, GenerMovieEnum.Drama, 2);
        a1.setRating(new int[]{3, 4, 1, 2, 3});

        Movie b1 = new Movie("Annabelle", 3, 2018, GenerMovieEnum.Horror, 3);
        b1.setRating(new int[]{5, 4, 3, 5, 5});

        Movie b2 = new Movie("The lion king", 1, 1995, GenerMovieEnum.Drama, 4);
        b1.setRating(new int[]{5, 1, 5, 5, 2});

        Movie b3 = new Movie("Joker", 2, 2019, GenerMovieEnum.Horror, 5);
        b3.setRating(new int[]{1, 1, 3, 2, 4});

        Movie b4 = new Movie("Borat", 1, 2006, GenerMovieEnum.Comedy, 6);
        b4.setRating(new int[]{5, 1, 3, 3, 4});

        Movie b5 = new Movie("Mean Girls", 2, 2004, GenerMovieEnum.Horror, 7);
        b5.setRating(new int[]{5, 4, 3, 2, 1});

        Movie b6 = new Movie("Ted", 3, 2016, GenerMovieEnum.Comedy, 8);
        b6.setRating(new int[]{1, 4, 3, 2, 2});

        Movie b7 = new Movie("The Nun", 3, 2017, GenerMovieEnum.Horror, 9);
        b7.setRating(new int[]{5, 4, 3, 4, 4});

        Movie b8 = new Movie("Holidate", 2, 2020, GenerMovieEnum.Horror, 10);
        b8.setRating(new int[]{5, 4, 3, 2, 2});
        //הדפסת הפקה סרט 
        Production p1 = new Production(ProductionJobEnum.Director, "Annabelle Wallis","Peter Safran");
        b1.setProductionCast(p1);

        Production p2 = new Production(ProductionJobEnum.Actor, "Joaquin Phoenix","Todd Phillips");
        b2.setProductionCast(p2);

        Production p3 = new Production(ProductionJobEnum.Director, "Jonathan Taylor Thomas","Don Hahn");
        b3.setProductionCast(p3);

        System.out.println("--------------------------------- Printing production details --------------------------------------------");
        System.out.println(b1.getName() + " production crew are: " + b1.getProductionCast().toString());
        System.out.println(b3.getName() + " production crew are: " + b3.getProductionCast().toString());
        System.out.println(b2.getName() + " production crew are: " + b2.getProductionCast().toString());
        System.out.println("--------------------------------- Done printing production details --------------------------------------------");

        TimeTable timeTable = new TimeTable();// יצרנוטבלתלוחזמנים

        System.out.println("trying to add a movie to sunday");
        System.out.println(timeTable.setMovie(b3, 0));

        System.out.println("trying to add a movie with length "+ b4.getLength() + " to sunday");
        System.out.println(timeTable.setMovie(b4, 0));

        System.out.println("trying to add a movie with length "+ b1.getLength() + " to sunday");
        System.out.println(timeTable.setMovie(b1, 0));

        System.out.println("trying to add a movie with length "+ b2.getLength() + " to sunday");
        System.out.println(timeTable.setMovie(b2, 0));

        System.out.println("trying to add a movie with length "+ b7.getLength() + " to sunday");
        System.out.println(timeTable.setMovie(b7, 0));

        System.out.println("trying to add a movie with length "+ b7.getLength() + " to monday");
        System.out.println(timeTable.setMovie(b7, 1));

    }

    private static void printMovies() {//הדפסת רשימת סרטים
        Movie m1 = new Movie("Gta", 3, 1995, GenerMovieEnum.Drama, 1);
        m1.setRating(new int[]{3, 4, 3, 5, 4});
        System.out.println(m1.toString());

        Movie a1 = new Movie("Titanic", 2, 1992, GenerMovieEnum.Drama, 2);
        a1.setRating(new int[]{3, 4, 1, 2, 3});
        System.out.println(a1.toString());

        Movie b1 = new Movie("Annabelle", 3, 2018, GenerMovieEnum.Horror, 3);
        b1.setRating(new int[]{5, 4, 3, 5, 5});
        System.out.println(b1.toString());

        Movie b2 = new Movie("lion king", 1, 1995, GenerMovieEnum.Drama, 4);
        b1.setRating(new int[]{5, 1, 5, 5, 2});
        System.out.println(b2.toString());

        Movie b3 = new Movie("Joker", 2, 2019, GenerMovieEnum.Horror, 5);
        b3.setRating(new int[]{1, 1, 3, 2, 4});
        System.out.println(b3.toString());

        Movie b4 = new Movie("Borat", 1, 2006, GenerMovieEnum.Comedy, 6);
        b4.setRating(new int[]{5, 1, 3, 3, 4});
        System.out.println(b4.toString());

        Movie b5 = new Movie("Mean Girls", 2, 2004, GenerMovieEnum.Horror, 7);
        b5.setRating(new int[]{5, 4, 3, 2, 1});
        System.out.println(b5.toString());

        Movie b6 = new Movie("Ted", 3, 2016, GenerMovieEnum.Comedy, 8);
        b6.setRating(new int[]{1, 4, 3, 2, 2});
        System.out.println(b6.toString());

        Movie b7 = new Movie("The Nun", 3, 2017, GenerMovieEnum.Horror, 9);
        b7.setRating(new int[]{5, 4, 3, 4, 4});
        System.out.println(b7.toString());

        Movie b8 = new Movie("Holidate", 2, 2004, GenerMovieEnum.Horror, 10);
        b8.setRating(new int[]{5, 4, 3, 2, 2});
        System.out.println(b8.toString());
        //הדפסה של הגבלת גיל 

        System.out.println("--------------------------------- Printing age ratings --------------------------------------------");
        System.out.println("Age rating for " + b7.getName() + " is: " + b7.getMovieAgeRequirementsByGenre());
        System.out.println("Age rating for " + b6.getName() + " is: " + b6.getMovieAgeRequirementsByGenre());
        System.out.println("Age rating for " + b2.getName() + " is: " + b2.getMovieAgeRequirementsByGenre());
        System.out.println("--------------------------------- Done printing age ratings ----------------------------------------");
    }
}