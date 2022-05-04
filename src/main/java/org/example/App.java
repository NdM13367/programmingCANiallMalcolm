package org.example;

import DAO.showdao.MySqlShowDao;
import DAO.showdao.ShowDaoInterface;
import Enums.ShowMenuOptions;
import Exceptions.DaoException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class App
{
    private static Scanner keyboard = new Scanner(System.in);
    private List<Shows> shows = new ArrayList<>();
    private static ShowDaoInterface showDao = new MySqlShowDao();



    public static void main( String[] args )
    {
        welcomeScreen();
        ShowMenuOptions selectedOption = ShowMenuOptions.PRINT_MENU;
        boolean quit = false;

        while(!quit)
        {
            System.out.print("\n Enter action: (0 to show available options) > ");
            selectedOption = ShowMenuOptions.values()[Integer.parseInt(keyboard.nextLine().trim())];

            switch(selectedOption)
            {
                case PRINT_MENU:
                    printOptions();
                    break;

                case DISPLAY_SHOWS_DETAILS:
                    displayAllShows();
                    break;

                case DISPLAY_BY_ID:
                    displayByID();
                    break;

                case REMOVE_SHOW_BY_ID:
                    removeShowByID();
                    break;

                case ADD_SHOW:
                    addShow();
                    break;

                case DISPLAY_JSON_STRING_LIST_OF_SHOWS:
                    displayJsonStringListOfShows();
                    break;

                case QUIT:
                    quit = true;
                    break;
            }
        }
    }



    private static void welcomeScreen()
    {
        System.out.print("\nWelcome to the Show Ranking List." +
                "\nPlease Press ENTER to start the application:" );
        Scanner keyboard = new Scanner(System.in);
        keyboard.nextLine();
    }


    private static void printOptions()
    {
        System.out.println("\n Available Options");
        System.out.println("0 - to print all options \n"+
                "1 - to display shows\n"+
                "2 - to display shows by id\n"+
                "3 - remove shows by id\n"+
                "4 - add a show\n"+
                "5 - display shows through json\n"+
                "6 - to quit \n");
    }

    private static void displayAllShows()
    {
        {
            try {
                File showDetails = new File("Shows");
                Scanner myReader = new Scanner(showDetails);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    System.out.println(data);
                }
                myReader.close();
            }

            catch (FileNotFoundException e)
            {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }

    private static void displayByID()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter id-1: ");
        int n = keyboard.nextInt();
        try{
            String line = Files.readAllLines(Paths.get("Shows")).get(n);
            System.out.println(line);
        }
        catch(IOException e){
            System.out.println(e);
        }
    }

    private static void removeShowByID()
    {
        String input = "Please delete: ";
        System.out.println(input);

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    System.in));
            String line = reader.readLine();
            reader.close();

            String inFile = "Shows";


            System.out.println("Remove: " + line);
            String lineToRemove = line;


            StringBuffer newContent = new StringBuffer();

            BufferedReader br = new BufferedReader(new FileReader(inFile));
            while ((line = br.readLine()) != null) {
                if (!line.trim().equals(lineToRemove)) {
                    newContent.append(line);
                    newContent.append("\n"); // new line

                }
            }
            br.close();

            FileWriter removeLine = new FileWriter(inFile);
            BufferedWriter change = new BufferedWriter(removeLine);
            PrintWriter replace = new PrintWriter(change);
            replace.write(newContent.toString());
            replace.close();

        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addShow()
    // code from w3schools
    // it crashes when you enter a passenger but it will work when you re-enter
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Id: ");
        int id = keyboard.nextInt();
        System.out.print("Name: ");
        String name = keyboard.next();
        System.out.print("Year: ");
        int year = keyboard.nextInt();
        System.out.print("Genre: ");
        String genre = keyboard.next();
        System.out.print("Studio: ");
        String studio = keyboard.next();
        System.out.print("Your Score: ");
        int yourScore = keyboard.nextInt();
        System.out.print("Average Score: ");
        int averageScore = keyboard.nextInt();
        System.out.print("Number of reviews: ");
        int noOfReviews = keyboard.nextInt();
        System.out.println("Id:" + " " + id + " " + "Name:" + " " + name + "Year:" + " " + year + "Genre:" + " " + genre + "Studio:" + " " + studio + "Your Score:" + " " + yourScore + "Average Score:" + " " + averageScore + "Number of Reviews:" + " " + noOfReviews);
        keyboard.close();

        try(FileWriter fw = new FileWriter("Shows", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println("\n" + id + ", " + name + ", " + year + ", " + genre + ", " + studio + ", " + yourScore + ", " + averageScore + ", " + noOfReviews);
        }
        catch (IOException e)
        {

        }
    }
    private static void displayJsonStringListOfShows()
    {
        try
        {
            String showJsonString = showDao.findAllShowsJson();

            if(showJsonString.equals("null"))
            {
                System.out.println("Train ID does not exist. Please go to the Menu option to Display Trains " + "\n"
                        + "and find one that is available.");
            }
            else
            {
                String[] trainJsonStringArray = showJsonString.split("(?=[{])");

                for (String train : trainJsonStringArray)
                {
                    System.out.println(train);
                }

            }

        }
        catch( DaoException e )
        {
            e.printStackTrace();
        }
    }
}
