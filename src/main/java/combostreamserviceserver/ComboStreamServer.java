package combostreamserviceserver;

import combostreamservicecore.ComboServiceDetails;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.NoSuchElementException;

public class ComboStreamServer
{
    public static void main(String[] args)
    {
        try
        {
            ServerSocket listeningSocket = new ServerSocket(ComboServiceDetails.SERVER_PORT);

            boolean continueRunning = true;
            int countRequests = 0;

            while(continueRunning)
            {
                System.out.println("Waiting for connections...");
                Socket dataSocket = listeningSocket.accept();

                ThreadPerClient runnable = new ThreadPerClient(dataSocket);
                Thread clientThread = new Thread(runnable);
                clientThread.start();
            }
            listeningSocket.close();
        }
        catch(NoSuchElementException nse)
        {
            System.out.println(nse.getMessage());
        }
        catch(IOException ioe)
        {
            System.out.println(ioe.getMessage());
        }
    }
}

