package NetWork;
import java.awt.Color;
import java.net.*;
import java.util.ArrayList;
import javax.swing.JTextPane;
import GUI.GUIControler;
import java.io.File;
import java.util.Scanner;
public class ClientThread {

    public void SendData(ArrayList<USER> U,USER Sender,Message M,JTextPane TA) throws Exception {
        int flag =0;
        for (USER U1 : U) {
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress IPAddress = InetAddress.getByName(U1.getIPAddress());
            byte[] sendData = new byte[1024];
            String sentence = M.getData();
            if (flag==0){
                String S="ME : "+sentence+"\n";
                GUIControler.AddColoredTextToPane(TA,S,Color.RED);
                flag = 1;
            }
            sentence = Sender.getUserName()+": "+M.getData();
            sendData = sentence.getBytes();
            DatagramPacket sendPacket= new DatagramPacket(sendData, sendData.length, IPAddress, U1.getPortNum());
            clientSocket.send(sendPacket);
            clientSocket.close();
            
        }
            
    }
        public void SendFile(ArrayList<USER> U,USER Sender,File F,JTextPane TA) throws Exception {
        int flag =0;
        for (USER U1 : U) {
            
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress IPAddress = InetAddress.getByName(U1.getIPAddress());
            byte[] sendData = new byte[1024];
            File myFile = F;
            Scanner Scanner;
            String line = null;
            String[] info = null;
            try {
                Scanner = new Scanner(myFile);
                while (Scanner.hasNext()) {
                    String sentence =Scanner.nextLine() ;
                    if (flag == 0) {
                        String S = "ME : " + sentence + "\n";
                        GUIControler.AddColoredTextToPane(TA, S, Color.RED);
                        flag = 1;
                    }
                    sentence = Sender.getUserName() + ": " + sentence;
                    sendData = sentence.getBytes();
                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, U1.getPortNum());
                    clientSocket.send(sendPacket);

            }
            
        } catch (Exception ex) {}
            
            

            clientSocket.close();
            
        }
            
    }
}
