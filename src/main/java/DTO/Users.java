package DTO;

public class Users
{
    private int noOfEntries;
    private int USERS_ID;
    private int SHOWS_ID;
    private String name;
    private int yourScore;

    public Users(int noOfEntries, int USERS_ID, int SHOWS_ID, String name, int yourScore)
    {
        this.noOfEntries = noOfEntries;
        this.USERS_ID = USERS_ID;
        this.SHOWS_ID = SHOWS_ID;
        this.name = name;
        this.yourScore = yourScore;
    }

    public int getNoOfEntries() {
        return noOfEntries;
    }

    public int getUSERS_ID() {
        return USERS_ID;
    }

    public int getSHOWS_ID() {
        return SHOWS_ID;
    }

    public String getName() {
        return name;
    }

    public int getYourScore() {
        return yourScore;
    }

    public void displayUsers()
    {
        String leftAlignFormat = "| %-14s| %-17s  |%n";
        System.out.format( leftAlignFormat, noOfEntries, USERS_ID, SHOWS_ID, name, yourScore);
        System.out.print(("-").repeat(38) + "\n");
    }

    @Override
    public String toString()
    {
        return "Fleet{" +
                "noOfEntries=" + noOfEntries +
                ", Users ID='" + USERS_ID + '\'' +
                ", Shows ID='" + SHOWS_ID + '\'' +
                ", name='" + name + '\'' +
                ", your score='" + yourScore + '\'' +
                '}';
    }
}
