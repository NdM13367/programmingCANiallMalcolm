package combostreamserviceclient;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

import static combostreamservicecore.ComboServiceDetails.SERVER_PORT;

public class ComboStreamClient
{
    try
    {
        Socket dataSocket = new Socket("localhost", SERVER_PORT);

        OutputStream out = dataSocket.getOutputStream();
        PrintWriter output = new PrintWriter(new OutputStreamWriter(out));

        InputStream in = dataSocket.getInputStream();

        Scanner input = new Scanner(new InputStreamReader(in));

        boolean quit = false;

        ComboStreamClient client = new ComboStreamClient();
        client.start();
    }

    catch(IOException ioe)
    {
        System.out.println(ioe.getMessage());
    }

    public void start()
    {
        welcomeScreen();
    }

    public static void welcomeScreen()
    {
        System.out.print("\nWelcome to the Show Ranking List." +
                "\nPlease Press ENTER to start the application:" );
        Scanner keyboard = new Scanner(System.in);
        keyboard.nextLine();
    }
}
