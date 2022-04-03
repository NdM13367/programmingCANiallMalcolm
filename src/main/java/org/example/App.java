package org.example;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class App
{
    private static Scanner keyboard = new Scanner(System.in);

    public static void main( String[] args )
    {
        System.out.println("Welcome to the car booking system");
        websiteMenuOptions selectedOption = websiteMenuOptions.PRINT_MENU;
        boolean quit = false;

        while(!quit)
        {
            System.out.print("\n Enter action: (0 to show available options) > ");
            selectedOption = websiteMenuOptions.values()[Integer.parseInt(keyboard.nextLine().trim())];

            switch(selectedOption)
            {
                case PRINT_MENU:
                    printOptions();
                    break;

                case DISPLAY_SHOWS:
                    displayShows();
                    break;

                case PRIORITY_QUEUE:
                    priorityQueue();
                    break;

                case DISPLAY_ONLY_SHOWS:
                    displayOnlyShows();
                    break;

                case REMOVE_SHOW:
                    removeShow();
                    break;

                case ADD_SHOW:
                    addShow();
                    break;

                case HIGHEST_LOWEST:
                    highestToLowest();
                    break;

                case QUIT:
                    quit = true;
                    break;
            }
        }
    }



    private static void printOptions()
    {
        System.out.println("\n Available Options");
        System.out.println("0 - to print all options \n"+
                "1 - to display shows\n"+
                "2 - priority queue\n"+
                "3 - to display only shows\n"+
                "4 - remove all shows\n"+
                "5 - add a show\n"+
                "6 - highest and lowest\n"+
                "7 - to quit \n");
    }

    private static void displayShows()
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

    private static void priorityQueue()
    {

    }

    private static void displayOnlyShows()
    {
        {
            try {
                File onlyShowDetails = new File("Available Shows");
                Scanner myReader = new Scanner(onlyShowDetails);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    System.out.println(data);
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }

    private static void removeShow()
    // code from w3schools
    {
        try{
            FileWriter fw = new FileWriter("Shows", false);
            PrintWriter pw = new PrintWriter(fw, false);
            pw.flush();
            pw.close();
            fw.close();
        }catch(Exception exception){
            System.out.println("Exception have been caught");
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
            out.println(id + ", " + name + ", " + year + ", " + genre + ", " + studio + ", " + yourScore + ", " + averageScore + ", " + noOfReviews);
        }
        catch (IOException e)
        {

        }
    }

    private static void highestToLowest()
    {
        Scanner input = new Scanner(System.in);
        String highestName = "";
        int highestScore = 0;
        String lowestName = "";
        int lowestScore = 0;

        System.out.print("Enter number of the show id ");
        int id = input.nextInt();

        for (int i = 0; i < id; i++) {
            System.out.print("Enter show's name: ");
            String name = input.next();
            System.out.println("Enter " + name + " 's score: ");
            int yourScore = input.nextInt();
            lowestScore = yourScore;

            if (yourScore > highestScore) {
                highestScore = yourScore;
                highestName = name;
            }

            if (yourScore < lowestScore) {
                lowestScore = yourScore;
                lowestName = name;
            }
        }

        System.out.println(highestName + " get highest score : " + highestScore);
        System.out.println(lowestName + " get lowest score : " + lowestScore);
    }
}
