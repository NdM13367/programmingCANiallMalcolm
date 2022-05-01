package org.example;

public class Shows
{
    private int id;
    private String name;
    private int year;
    private String genre;
    private String studio;
    private int yourScore;
    private int averageScore;
    private int noOfReviews;

    public Shows(int id, String name, int year, String genre, String studio, int yourScore, int averageScore, int noOfReviews)
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

    public void displayShow()
    {
        String leftAlignFormat = "| %-14s| %-14d| %-14d| %-14d| %-29s  |%n";
        System.out.format( leftAlignFormat, id, name, year, genre, studio, yourScore, averageScore, noOfReviews);
        System.out.print(("-").repeat(98) + "\n");

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

    public void setId(int id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public void setGenre(String genre)
    {
        this.genre = genre;
    }

    public void setStudio(String studio)
    {
        this.studio = studio;
    }

    public void setYourScore(int yourScore)
    {
        this.yourScore = yourScore;
    }

    public void setAverageScore(int averageScore)
    {
        this.averageScore = averageScore;
    }

    public void setNoOfReviews(int noOfReviews)
    {
        this.noOfReviews = noOfReviews;
    }
}
