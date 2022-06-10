package NetWork;


import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
import javax.swing.JTextPane;

public class ServerThread extends Thread {

    int SPortNum = 0;
    JTextPane TA;
    JList L;
    
    public JList getL() {
        return L;
    }

    public void setL(JList L) {
        this.L = L;
    }
    private ArrayList<USER> OnlineUsers;
    private ArrayList<USER> DataBase;

    public void run() {
        try {
        ServerSocket ss = new ServerSocket(SPortNum);
        System.out.println("ServerSocket awaiting connections...");
        while (true){
            Socket socket = ss.accept(); 
            System.out.println("Connection from " + socket + "!");
            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            USER RUser = (USER)objectInputStream.readObject();
            System.out.println(RUser.getUserName());
            socket.close();
            if (!RUser.isNewUser()&&RUser.isLogedIn()){
                RUser=USER.findUser(DataBase, RUser.getUserName());
                Socket socket2 = new Socket(RUser.getIPAddress(), RUser.getPortNum());
                System.out.println("Connected!");
                OutputStream outputStream = socket2.getOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                System.out.println("Sending messages to the ServerSocket");
                objectOutputStream.writeObject(RUser);
                System.out.println("Closing socket and terminating program.");
                socket2.close();
                OnlineUsers.add(RUser);
                USER.PrintUsersList(OnlineUsers, L);
                SendArrayListToAllUsers();
            }else if (!RUser.isNewUser()&&!RUser.isLogedIn()){
                OnlineUsers.remove(USER.findUser(OnlineUsers, RUser.getUserName()));
                USER.PrintUsersList(OnlineUsers, L);
                SendArrayListToAllUsers();
            
            }
            else {
                DataBase.add(RUser);
                USER.UpdateDataBase(DataBase, "DataBase.txt");
            }
        }
                } catch (Exception ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void SendArrayListToAllUsers() throws IOException {
        for (int i=0;i<OnlineUsers.size();i++) {
            Socket socket = new Socket(OnlineUsers.get(i).getIPAddress(), OnlineUsers.get(i).getPortNum());
            System.out.println("Connected!");
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            System.out.println("Sending messages to the ServerSocket");
            objectOutputStream.writeObject(OnlineUsers);
            System.out.println("Closing socket and terminating program.");
            socket.close();
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

    public ArrayList<USER> getOnlineUsers() {
        return OnlineUsers;
    }

    public void setOnlineUsers(ArrayList<USER> OnlineUsers) {
        this.OnlineUsers = OnlineUsers;
    }

    public ArrayList<USER> getDataBase() {
        return DataBase;
    }

    public void setDataBase(ArrayList<USER> DataBase) {
        this.DataBase = DataBase;
    }
    
}
