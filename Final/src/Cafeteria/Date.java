package Cafeteria;

public class Date {
    private int day, mounth, year;

    public Date(int d, int m, int y) {  //���� ������ ������ ��������, ���, ����, ���
        if (d >= 0 && d <= 31)
            this.day = d;
        else
            this.day = 0;

        if (m >= 0 && m <= 12)
            this.mounth = m;
        else
            this.mounth = 0;

        if (y > 0)
            this.year = y;
        else
            this.year = 0;
    }

    public String ToString() {//���� ������ ������ ����� �� 8 ����� �����
        String str = "";

        if (day <= 9)
            str += "0" + day + "/";
        else
            str += day + "/";

        if (mounth <= 9)
            str += "0" + mounth + "/";
        else
            str += mounth + "/";

        if (year <= 9)
            str += "0" + year;
        else
            str += year;

        return (str);
    }
}
