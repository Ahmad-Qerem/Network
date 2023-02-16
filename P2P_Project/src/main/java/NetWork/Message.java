package NetWork;

public class Message {

    public String myName = "";
    private String Data = "";
    private String SID = "";
    private int SPortNum = 0;

    public Message(String sid, int spn) {
        SID = sid;
        SPortNum = spn;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public String getSID() {
        return SID;
    }

    public void setSID(String SID) {
        this.SID = SID;
    }

    public int getSPortNum() {
        return SPortNum;
    }

    public void setSPortNum(int SPortNum) {
        this.SPortNum = SPortNum;
    }
}
