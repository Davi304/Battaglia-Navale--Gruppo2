import java.io.*;
import java.net.*;

public class Server 
{
    public static void main(String[] args) 
    {
        int port = 2000;

        DatagramSocket dSocket;
        DatagramPacket inPacket;
        DatagramPacket outPacket;

        byte[] buffer;

        String messageIn;
        boolean attivo = true;


        try
        {
            dSocket = new DatagramSocket(port);

            while(attivo)
            {
                buffer = new byte[25 * Integer.BYTES];

                inPacket = new DatagramPacket(buffer, buffer.length);

                dSocket.receive(inPacket);

                
            }
        }

        catch(IOException e)
        {
            System.err.println(e);
        }
    }
}
