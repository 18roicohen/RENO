package Movies;

public class TimeTable {
    private int daysInWeek = 7;
    private int hoursAday = 8;
    private int[][] movieInTimeTable;

    public TimeTable() {
        movieInTimeTable = new int[daysInWeek][hoursAday]; //�����������  �����
        for (int day = 0; day < daysInWeek; day++) {
            for (int hour = 0; hour < hoursAday; hour++) {
                movieInTimeTable[day][hour] = -1; //������-1�����
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
        int hours = movie.getLength(); //����������������������������������������
        boolean success = false; //
        int locationToPutMovie = -1;
        for (int i = 0; i < hoursAday; i++) {//3,3
            if (movieInTimeTable[day][i] == -1 && i + hours <= hoursAday) {//�� ������ ����� ����� ����� ��� ��� �� ���� ������ �� ���� ������ �����
                locationToPutMovie = i;
                success = true;//����� ������ ��� 
                break;
            }
        }
        if (locationToPutMovie != -1) { //������ ����� ���� �� ��� �� ���� 
            for (int i = locationToPutMovie; i < locationToPutMovie + hours; i++) { 
                movieInTimeTable[day][i] = movie.getId(); 
            }
        }
        return success;
    }

}
