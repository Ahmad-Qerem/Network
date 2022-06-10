package NetWork;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.*;
import java.util.ArrayList;

public class ClientThread {

    public void SendData(ArrayList<USER> U) throws Exception {
        Socket clientSocket = null;
        for (USER U1 : U) {
            clientSocket = new Socket(U1.IPAddress, U1.getPortNum());
            OutputStream outputStream = clientSocket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(U);
        }
        clientSocket.close();
    }

}
