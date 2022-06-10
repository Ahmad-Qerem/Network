
import java.io.*;
import java.net.*;

public class ClientSide_UDP {

    public static void main(String argv[]) throws Exception {
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");

        System.out.println("plese enter the  number to find course name from server ");
        System.out.println("type '!' to exit and close the connection ");
        while (true) {
            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024]; 
            String sentence = inFromUser.readLine();
            if (!sentence.equals("!")) {
                sendData = sentence.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 7777);
                clientSocket.send(sendPacket);
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                clientSocket.receive(receivePacket);
                String modifiedSentence = new String(receivePacket.getData());
                System.out.println("FROM SERVER:" + modifiedSentence);
            } else {
                break;
            }
        }
        clientSocket.close();
    }
}
