import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String argv[]) throws Exception
    {
        //String clientSentence1;
        String clientSentence;
        String response;

        ServerSocket welcomeSocket = new ServerSocket(6789);

        Socket connectionSocket = welcomeSocket.accept();

        BufferedReader inFromClient =
                new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
        DataOutputStream  outToClient =
                new DataOutputStream(connectionSocket.getOutputStream());


        while(true) {

           clientSentence = inFromClient.readLine();
           StringBuilder sb= new StringBuilder(clientSentence);

           response = sb.reverse().toString() + '\n';
           outToClient.writeBytes(response);
        }
    }

}
