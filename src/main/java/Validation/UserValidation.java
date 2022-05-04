package Validation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserValidation
{
    private Scanner keyboard = new Scanner(System.in);
    private static UserValidationRegexes userValidationRegexes = new UserValidationRegexes();
    private  int userInputInt;
    private double userInputDouble;
    private String userInputString;


    public UserValidation()
    {

    }

    public String getUserInputForStringInputs(String message)
    {
        System.out.print("\n" + message);
        userInputString = keyboard.next();

        return userInputString;
    }

    public String validateTrainID()
    {
        String trainID = "";
        boolean validTrainID = false;

        while (!validTrainID)
        {
            trainID = getUserInputForStringInputs("Please enter a train ID > ");
            keyboard.nextLine();

            if (userValidationRegexes.checkTrainID(trainID))
            {
                validTrainID = true;
                break;
            }
        }

        return trainID;
    }
}
