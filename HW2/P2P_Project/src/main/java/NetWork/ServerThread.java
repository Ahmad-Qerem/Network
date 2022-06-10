package NetWork;
import java.awt.Color;
import java.net.*;
import javax.swing.JTextPane;
import GUI.GUIControler;
public class ServerThread extends Thread {
    int SPortNum = 0;
    JTextPane TA;
    public void run() {
        try {
            DatagramSocket serverSocket = new DatagramSocket(SPortNum);
            while (true) {
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                String sentence = new String(receivePacket.getData());
                GUIControler.AddColoredTextToPane(TA, sentence.strip() + "\n", Color.BLUE);
            }
        } catch (Exception ex) {
        }
    }

    public JTextPane getTA() {
        return TA;
    }

    public void setTA(JTextPane TA) {
        this.TA = TA;
    }

    public int getSPortNum() {
        return SPortNum;
    }

    public void setSPortNum(int SPortNum) {
        this.SPortNum = SPortNum;
    }
}
