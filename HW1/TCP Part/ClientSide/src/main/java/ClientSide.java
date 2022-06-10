
import java.io.*;
import java.net.*;

public class ClientSide {

    public static void main(String argv[]) throws Exception {
        String sentence;
        String modifiedSentence;
        BufferedReader inFromUser;
        Socket clientSocket= null;
        System.out.println("plese enter the  number to find course name from server ");
        System.out.println("type '!' to exit and close the connection ");
        while (true) {
            inFromUser = new BufferedReader(new InputStreamReader(System.in));
            sentence = inFromUser.readLine();
            if (sentence.equals("!")){
                break;
            }else {
                clientSocket = new Socket("localhost", 7777);
                DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
                BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                
                outToServer.writeBytes(sentence + '\n');
                modifiedSentence = inFromServer.readLine();
                System.out.println("FROM SERVER: " + modifiedSentence);
            }

        }
        clientSocket.close();
    }
}
