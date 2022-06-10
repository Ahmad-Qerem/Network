package NetWork;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
import javax.swing.JTextPane;

public class TCP_Server extends Thread {
    USER currentUser;
    int SPortNum = 0;
    JTextPane TA;
    ArrayList<USER> listOfUsers;
    JList L;
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(SPortNum);
            int f=0;
            while (true) {
                if (f==0){
                Socket socket = ss.accept();    
                System.out.println("Connection from " + socket + "!");
                InputStream inputStream = socket.getInputStream();
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                USER RUser = (USER) objectInputStream.readObject();
                currentUser=RUser;
                f=1;
                socket.close();
                }
                Socket socket = ss.accept();
                InputStream inputStream = socket.getInputStream();
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                listOfUsers = (ArrayList<USER>) objectInputStream.readObject();
                USER.PrintUsersList(listOfUsers, L);               

                
                socket.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public USER getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(USER currentUser) {
        this.currentUser = currentUser;
    }

    public JList getL() {
        return L;
    }

    public void setL(JList L) {
        this.L = L;
    }
    

    public int getSPortNum() {
        return SPortNum;
    }

    public void setSPortNum(int SPortNum) {
        this.SPortNum = SPortNum;
    }

    public JTextPane getTA() {
        return TA;
    }

    public void setTA(JTextPane TA) {
        this.TA = TA;
    }

    public ArrayList<USER> getListOfUsers() {
        return listOfUsers;
    }

    public void setListOfUsers(ArrayList<USER> listOfUsers) {
        this.listOfUsers = listOfUsers;
    }

}
