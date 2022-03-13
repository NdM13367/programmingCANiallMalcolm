package org.example;

import java.io.*;
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
                "2 - to quit \n");
    }

    private static void displayShows()
    {
        {
            try {
                File passengerDetails = new File("Shows");
                Scanner myReader = new Scanner(passengerDetails);
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

    private static void priorityQueue()
    {

    }
}
