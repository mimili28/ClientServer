import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        String message1;
        String message;
        String reply;

        Socket clientSocket = new Socket("localhost", 6789);

        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream outToServer =
                new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer =
                new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        System.out.println("Type in a message to start connection!");
        message1=inFromUser.readLine();
        while (!message1.equals("Hi server")) {
            System.out.println("Connection could not be established! Try again!");
            message1=inFromUser.readLine();
        }
        System.out.println("Connection is established! Type something!");

        while(true) {
                message = inFromUser.readLine();
                if (message.equals("close")) {
                    System.out.println("Connection is closing!");
                    clientSocket.close();
                }
                outToServer.writeBytes(message + '\n');
                reply = inFromServer.readLine();
                System.out.println("FROM SERVER: " + reply);
        }

    }
}