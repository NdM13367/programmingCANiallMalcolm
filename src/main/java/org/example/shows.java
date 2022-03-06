package org.example;

public class shows
{
    private int id;
    private String name;
    private int year;
    private String genre;
    private String studio;
    private int yourScore;
    private int averageScore;
    private int noOfReviews;

    public shows(int id, String name, int year, String genre, String studio, int yourScore, int averageScore, int noOfReviews)
    {
        this.id = id;
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.studio = studio;
        this.yourScore = yourScore;
        this.averageScore = averageScore;
        this.noOfReviews = noOfReviews;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public int getYear()
    {
        return year;
    }

    public String getGenre()
    {
        return genre;
    }

    public String getStudio()
    {
        return studio;
    }

    public int getYourScore()
    {
        return yourScore;
    }

    public int getAverageScore()
    {
        return averageScore;
    }

    public int getNoOfReviews()
    {
        return noOfReviews;
    }
}
