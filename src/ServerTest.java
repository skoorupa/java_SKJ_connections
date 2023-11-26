import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket( 2137);

        Socket client = server.accept();

        InputStream client_is = client.getInputStream();
        OutputStream client_os = client.getOutputStream();
        InputStreamReader client_isr = new InputStreamReader(client_is);
        OutputStreamWriter client_osw = new OutputStreamWriter(client_os);
        BufferedReader client_br = new BufferedReader(client_isr);
        BufferedWriter client_bw = new BufferedWriter(client_osw);

        String request = "";
        String requestLine = null;
        while (!(requestLine = client_br.readLine()).isEmpty()) {
            request += requestLine;
            System.out.println(requestLine);
        }
        System.out.println("<koniec transmisji>");

        client_bw.write("got it: "+request);
        client_bw.flush();

        System.out.println("<wyslano>");

        client.close();
    }
}
