package Movies;

import Enum.GenerMovieEnum;

public class Movie {  //הגדרת משתנים
    private String name;
    private int length;
    private int publication;
    private int[] rating;//יצירת מערך
    private int id;
    private GenerMovieEnum genre;
    private Production productionCast;

    public Movie(String name, int length, int publication, GenerMovieEnum genre, int id) {
        if (name == null)
        {
            this.name = "";
        }
        this.name = name;
        this.length = length;
        this.id = id;
        this.rating = new int[5];
        this.genre = genre;
        this.publication = publication;
    }

    @Override
    public String toString() {//הדפסה 
        String str = "";
        str = "ID: " + getId() + ", Movie Name: " + name + " , Movie Lenght: " + length + ""
                + " Hour" + " , Year of publication: " + publication + ", Movie Rating: " + Average();
        return str;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getPublication() {
        return publication;
    }

    public void setPublication(int publication) {
        this.publication = publication;
    }

    public GenerMovieEnum getGenre() {
        return genre;
    }

    public void setGenre(GenerMovieEnum genre) {
        this.genre = genre;
    }

    public int getMovieAgeRequirementsByGenre() {//הגבלת גיל לפי סוג גאנר
        int returnValue = 0;
        switch (genre) {
            case Drama:
                returnValue = 12;
                break;
            case Horror:
                returnValue = 18;
                break;
            case Comedy:
                returnValue = 10;
                break;
        }
        return returnValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[] getRating() {
        return rating;
    }

    public void setRating(int[] rating) {
        this.rating = rating;
    }

    public double Average() { //חישוב ממוצע הרייטניג 
        int sum = 0;
        for (int i = 0; i < rating.length; i++) {
            sum += rating[i];
        }
        return (double) sum / rating.length;
    }

    public Production getProductionCast() {
        return productionCast;
    }

    public void setProductionCast(Production productionCast) {
        this.productionCast = productionCast;
    }
}

