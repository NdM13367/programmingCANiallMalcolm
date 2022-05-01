package DTO;

public class Shows implements Comparable<Shows>
{
    private final int SHOWS_ID;
    private String name;
    private int year;
    private String genre;
    private String studio;
    private int yourScore;
    private int averageScore;
    private int noOfReviews;


    public Shows(int SHOWS_ID, String name, int year, String genre, String studio, int yourScore, int averageScore, int noOfReviews)
    {
        this.SHOWS_ID = SHOWS_ID;
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.studio = studio;
        this.yourScore = yourScore;
        this.averageScore = averageScore;
        this.noOfReviews = noOfReviews;
    }

    public int getSHOWS_ID() {
        return SHOWS_ID;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public String getStudio() {
        return studio;
    }

    public int getYourScore() {
        return yourScore;
    }

    public int getAverageScore() {
        return averageScore;
    }

    public int getNoOfReviews() {
        return noOfReviews;
    }

    public void displayShows()
    {
        String leftAlignFormat = "| %-14s| %-17s  |%n";
        System.out.format( leftAlignFormat, SHOWS_ID, name, year, genre, studio, yourScore, averageScore, noOfReviews);
        System.out.print(("-").repeat(38) + "\n");
    }

    @Override
    public int compareTo(Shows otherShows)
    {
        return this.SHOWS_ID - otherShows.getSHOWS_ID();
    }

    @Override
    public String toString()
    {
        return "Fleet{" +
                "SHOWS_ID=" + SHOWS_ID +
                ", name='" + name + '\'' +
                ", year='" + year + '\'' +
                ", genre='" + genre + '\'' +
                ", studio='" + studio + '\'' +
                ", yourScore='" + yourScore + '\'' +
                ", averageScore='" + averageScore + '\'' +
                ", noOfReviews='" + noOfReviews + '\'' +
                '}';
    }
}
