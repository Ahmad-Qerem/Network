
import java.io.*;
import java.net.*;
import java.util.ArrayList;

class ServerSide_UDP {

    public static class course {

        String ID = "";
        String Name = "";

        public static String find(ArrayList<course> Data, int LINES, String clientSentence) {
            for (int i = 0; i < LINES; i++) {

                if (Data.get(i).ID.equals(clientSentence)) {
                    return Data.get(i).Name;
                }
            }
            return "Error 404";
        }

    }

    public static void main(String argv[]) throws Exception {

        ArrayList<course> Data = new ArrayList<>();
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

        DatagramSocket serverSocket = new DatagramSocket(7777);


        while (true) {
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];            
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);

            String sentence = new String(receivePacket.getData(),receivePacket.getOffset(), receivePacket.getLength());

            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();

            String capitalizedSentence = course.find(Data, LINES, sentence);
            sendData = capitalizedSentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);
        }
    }
}
