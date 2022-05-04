package Validation;

import combostreamservicecore.Protocol;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidationForEnumMenus
{
    private Scanner keyboard = new Scanner(System.in);
    private String menuOptionAction = "\nEnter action: (0 to show available options) > ";


    public ValidationForEnumMenus()
    {

    }
    public Protocol.ClientMainMenuOptions validateClientMenuOptionsEnum()
    {
        Protocol.ClientMainMenuOptions selectedOption = null;
        boolean validClientMenuOption = false;
        while (!validClientMenuOption)
        {
            try
            {
                printMenuOptionAction();
                selectedOption = Protocol.ClientMainMenuOptions.values()[Integer.parseInt(keyboard.nextLine().trim())];
                validClientMenuOption = true;
            }
            catch (InputMismatchException | NumberFormatException | ArrayIndexOutOfBoundsException e)
            {
                System.out.print("Invalid input. Number inputted must be between 0 - 6.\n");
            }

        }

        return selectedOption;
    }

    private void printMenuOptionAction()
    {

    }
}
