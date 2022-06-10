package NetWork;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class TCP_client {

    public void SendData(USER U, String ServerIP, int ServerPortNum) throws Exception {
        Socket socket = new Socket(ServerIP, ServerPortNum);
        System.out.println("Connected!");
        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        System.out.println("Sending messages to the ServerSocket");
        objectOutputStream.writeObject(U);
        System.out.println("Closing socket and terminating program.");
        socket.close();
    }
  
        
}