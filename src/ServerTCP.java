import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {

    public static void main(String[] args) throws IOException {
        int serverPort = 8000;

        log("Server port opening: " + serverPort);
        ServerSocket welcomeSocket = new ServerSocket(serverPort);
        log("Server port opened: " + serverPort);
        log("Listening: " + serverPort);

        Socket clientConnection = welcomeSocket.accept();
        log("Client connected: " + clientConnection.getInetAddress() + ":" + clientConnection.getPort());

        log("Streams collecting");
        InputStream is = clientConnection.getInputStream();
        OutputStream os = clientConnection.getOutputStream();
        InputStreamReader isr = new InputStreamReader(is);
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedReader br = new BufferedReader(isr);
        BufferedWriter bw = new BufferedWriter(osw);

        log("Reading requests");
        String request;
        int i = 1;
        while (!(request = br.readLine()).equals("")) {
            log("Request received "+i+": "+request);
            i++;
        }

        log("Sending response");
        bw.write("Hello client!");
        bw.flush();

        log("Closing connection to the client");
        clientConnection.close();
        log("Connection closed to the client");
    }

    public static void log(String mesg) {
        System.out.println("[S]: " + mesg);
        System.out.flush();
    }
}