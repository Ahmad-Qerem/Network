
import java.io.*;
import java.net.*;
import java.util.ArrayList;

class ServerSide {

    public static class course {
        String ID = "";
        String Name = "";
        
        public static String find(ArrayList<course> Data, int LINES, String clientSentence) {
            for (int i = 0; i < LINES; i++) {
                if (clientSentence.equals(Data.get(i).ID)) {
                    return Data.get(i).Name;
                }

            }
            return "Error 404";
        }
    }

    public static void main(String argv[]) throws Exception {

        ArrayList<course> Data = new ArrayList<course>();
        File file = new File("Data.txt");
        BufferedReader BReder = new BufferedReader(new FileReader(file));
        int LINES = Integer.parseInt(BReder.readLine());
        String Reder = "";
        for (int i = 0; i < LINES; i++) {
            Reder = BReder.readLine();
            String RData[] = Reder.split(",");
            course Ncourse = new course();
            Ncourse.ID = RData[0];
            Ncourse.Name = RData[1];
            Data.add(Ncourse);
        }
        for (int i = 0; i < LINES; i++) {
            System.out.println(Data.get(i).ID + ":" + Data.get(i).Name);
        }

        String clientSentence;
        String capitalizedSentence;
        ServerSocket welcomeSocket = new ServerSocket(7777);
        while (true) {
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            clientSentence = inFromClient.readLine();
            System.out.println("The client requested "+clientSentence);
            capitalizedSentence = course.find(Data, LINES, clientSentence)+'\n';
            outToClient.writeBytes(capitalizedSentence);
        }
    }
}
