import java.io.*;
import java.net.Socket;

public class ClientTCP_HTTP {

    public static void main(String[] args) throws IOException {
        String serverAddress = "128.119.245.12";
        int serverPort = 80;

        String requestHeaderLine1 = "HEAD /ethereal-labs/lab2-1.html HTTP/1.1";
        String requestHeaderLine2 = "Host: gaia.cs.umass.edu";

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

        log("Sending request header line 1: " + requestHeaderLine1);
        bw.write(requestHeaderLine1);
        bw.newLine();
        bw.write(requestHeaderLine2);
        bw.newLine();
        bw.newLine();
        bw.flush();

        log("Response receiving");
        String response = null;
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