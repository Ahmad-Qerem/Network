package NetWork;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
public class USER implements Serializable{
    String UserName;
    String IPAddress;
    int PortNum;
    boolean LogedIn=false;
    boolean NewUser=false;
    public USER(String username, String ipaddress, int port) {
        UserName = username;
        IPAddress = ipaddress;
        PortNum = port;
    }
    public String getUserName() {
        return UserName;
    }
    public void setUserName(String UserName) {
        this.UserName = UserName;
    }
    public String getIPAddress() {
        return IPAddress;
    }
    public void setIPAddress(String IPAddress) {
        this.IPAddress = IPAddress;
    }
    public int getPortNum() {
        return PortNum;
    }
    public void setPortNum(int PortNum) {
        this.PortNum = PortNum;
    }

    public boolean isLogedIn() {
        return LogedIn;
    }

    public void setLogedIn(boolean LogedIn) {
        this.LogedIn = LogedIn;
    }

    public boolean isNewUser() {
        return NewUser;
    }

    public void setNewUser(boolean NewUser) {
        this.NewUser = NewUser;
    }
    
    
    public static ArrayList<USER> getUsersFromDataBase(String FileName) {
        ArrayList<USER> Data = new ArrayList<>();
        File myFile = new File(FileName);
        Scanner Scanner;
        String line = null;
        String[] info = null;
        try {
            Scanner = new Scanner(myFile);
            while (Scanner.hasNext()) {
                line = Scanner.nextLine();
                info = line.split(",");
                USER newUsere = new USER(info[0], info[1], Integer.parseInt(info[2]));
                Data.add(newUsere);
            }
            
        } catch (Exception ex) {}
        return Data;
    }
    public static void UpdateDataBase(ArrayList<USER> Data, String FileName) {
        FileWriter myWriter = null;
        try {
            myWriter = new FileWriter(FileName);
            myWriter.write("");
            for (USER Data1 : Data) {
                String S = Data1.UserName + "," + Data1.getIPAddress() + "," + Data1.getPortNum()+ "\n";
                myWriter.append(S);
            }
            myWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(USER.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                myWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(USER.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static void PrintUsersList(ArrayList<USER> Data,JList L) {
        DefaultListModel LM = new DefaultListModel();
        for (USER Data1 : Data) {
            String S=Data1.getUserName() + "," + Data1.getIPAddress() + "," + Data1.getPortNum();
            LM.addElement(S);
        }
        L.setModel(LM);
    }
    public static USER findUser(ArrayList<USER> Data, String userName) {
        for (USER Data1 : Data) {
            if (userName.equals(Data1.getUserName())) {
                return Data1;
            }
        }
        return null;
    }
}