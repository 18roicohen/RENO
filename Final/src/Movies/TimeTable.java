package Movies;

public class TimeTable {
    private int daysInWeek = 7;
    private int hoursAday = 8;
    private int[][] movieInTimeTable;

    public TimeTable() {
        movieInTimeTable = new int[daysInWeek][hoursAday]; //משתניםבמערך  בניית
        for (int day = 0; day < daysInWeek; day++) {
            for (int hour = 0; hour < hoursAday; hour++) {
                movieInTimeTable[day][hour] = -1; //הצבהשל-1בטבלה
            }
        }
    }

    public String showStartTime() {
        return "16:00";
    }

    public String showEndTime() {
        return "00:00";
    }

    public boolean setMovie(Movie movie, int day) {
        int hours = movie.getLength(); //נגדירמשתנהשעהוהואיקבלאתאורךהסרטממחלקתסרט
        boolean success = false; //
        int locationToPutMovie = -1;
        for (int i = 0; i < hoursAday; i++) {//3,3
            if (movieInTimeTable[day][i] == -1 && i + hours <= hoursAday) {//אם במיקום בטבלה מסומן מינוס אחד וגם יש מקום להכניס את הסרט מבחינת השעות
                locationToPutMovie = i;
                success = true;//נצליח להכניס סרט 
                break;
            }
        }
        if (locationToPutMovie != -1) { //במיקום הפנוי נשים את התז של הסרט 
            for (int i = locationToPutMovie; i < locationToPutMovie + hours; i++) { 
                movieInTimeTable[day][i] = movie.getId(); 
            }
        }
        return success;
    }

}
