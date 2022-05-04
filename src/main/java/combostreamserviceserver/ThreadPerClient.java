package combostreamserviceserver;

import combostreamserviceclient.Command;
import combostreamserviceclient.CommandFactory;
import combostreamservicecore.Packet;
import combostreamservicecore.Protocol;

import java.io.*;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ThreadPerClient implements Runnable
{
    private Socket dataSocket;

    public ThreadPerClient(Socket dataSocket)
    {
        this.dataSocket = dataSocket;
    }

    @Override
    public void run()
    {
        //Step 3: Build the input and output streams linked to the datasocket
        try
        {
            OutputStream out = dataSocket.getOutputStream();
            PrintWriter output = new PrintWriter(new OutputStreamWriter(out));

            InputStream in = dataSocket.getInputStream();

            //An example of the Decorator design pattern
            Scanner input = new Scanner(new InputStreamReader(in));


            Packet incomingPacket = new Packet(Protocol.ClientMainMenuOptions.NONE,null);
            Packet response = null;
            boolean sendMessage = false;
            int countRequests = 0;

            while (!incomingPacket.getMessageType().equals(Protocol.ClientMainMenuOptions.QUIT_CLIENT_MENU))
            {

                //take information from the client

                incomingPacket.readFromJSON(new JSONObject(input.nextLine()));
                System.out.println("Received message " + incomingPacket);

                countRequests++;

                CommandFactory factory = new CommandFactory(countRequests);
                //Figure out what command was sent by the client
                Command command =factory.createCommand(incomingPacket.getMessageType());

                if(command != null)
                {
                    response = command.createResponse(incomingPacket);
                }

                //Send the response to the client
                output.println(response.writeJSON());
                output.flush();
            }
            dataSocket.close();
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
