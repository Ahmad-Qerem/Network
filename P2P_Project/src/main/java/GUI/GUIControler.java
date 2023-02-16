package GUI;

import NetWork.*;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class GUIControler {

    private ArrayList<USER> TargetUsers;
    private DefaultListModel dlm;
    
    private boolean LOGEDIN = false;
    private ArrayList<USER> DataBase;
    private USER CurruntUser;
    private ClientThread CT;
    private ServerThread ST;
    private TCP_Server TCPS;
    private TCP_client TCPC;
    private boolean flag = false;

    public ArrayList<USER> getTargetUsers() {
        return TargetUsers;
    }

    public void setTargetUsers(ArrayList<USER> TargetUsers) {
        this.TargetUsers = TargetUsers;
    }

    public DefaultListModel getDlm() {
        return dlm;
    }

    public void setDlm(DefaultListModel dlm) {
        this.dlm = dlm;
    }

    public ServerThread getST() {
        return ST;
    }

    public void setST(ServerThread ST) {
        this.ST = ST;
    }

    public boolean isLOGEDIN() {
        return LOGEDIN;
    }

    public void setLOGEDIN(boolean LOGEDIN) {
        this.LOGEDIN = LOGEDIN;
    }

    public ArrayList<USER> getDataBase() {
        return DataBase;
    }

    public void setDataBase(ArrayList<USER> DataBase) {
        this.DataBase = DataBase;
    }

    public USER getCurruntUser() {
        return CurruntUser;
    }

    public void setCurruntUser(USER CurruntUser) {
        this.CurruntUser = CurruntUser;
    }

    public ClientThread getCT() {
        return CT;
    }

    public void setCT(ClientThread CT) {
        this.CT = CT;
    }

    public boolean isSTStarted() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public TCP_Server getTCPS() {
        return TCPS;
    }

    public void setTCPS(TCP_Server TCPS) {
        this.TCPS = TCPS;
    }

    public TCP_client getTCPC() {
        return TCPC;
    }

    public void setTCPC(TCP_client TCPC) {
        this.TCPC = TCPC;
    }
    
    

    public static void AddColoredTextToPane(JTextPane ChatArea, String Data, Color c) {
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet SET = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);
        SET = sc.addAttribute(SET, StyleConstants.FontFamily, "Lucida Console");
        SET = sc.addAttribute(SET, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);
        int len = ChatArea.getDocument().getLength();
        ChatArea.setCaretPosition(len);
        ChatArea.setCharacterAttributes(SET, false);
        ChatArea.replaceSelection(Data);
    }
}
