import java.io.*;
import java.net.Socket;

public class ClientTCP {

    public static void main(String[] args) throws IOException {
        String serverAddress = "localhost";
        int serverPort = 8000;

        log("Connecting to the server: " + serverAddress + ":" + serverPort);
        Socket clientConnection = new Socket(serverAddress, serverPort);
        log("Connected to the server: " + serverAddress + ":" + serverPort);

        log("Streams collecting");
        InputStream is = clientConnection.getInputStream();
        OutputStream os = clientConnection.getOutputStream();
        InputStreamReader isr = new InputStreamReader(is);
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedReader br = new BufferedReader(isr);
        BufferedWriter bw = new BufferedWriter(osw);

        log("Sending requests");
        bw.write("Hello server!");
        bw.newLine();
        bw.newLine();
        bw.flush();

        log("Response receiving");
        String response;
        int i = 1;
        while ((response = br.readLine()) != null) {
            log("Response received " + i + ": " + response);
            i++;
        }

        log("Closing connection to the server: " + serverAddress + ":" + serverPort);
        clientConnection.close();
        log("Connection closed to the server: " + serverAddress + ":" + serverPort);
    }

    public static void log(String mesg) {
        System.out.println("[C]: " + mesg);
        System.out.flush();
    }
}