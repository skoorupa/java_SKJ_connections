import java.io.*;
import java.net.Socket;

public class ClientTest {
    public static void main(String[] args) throws IOException {
        Socket connection = new Socket("localhost",2137);

        InputStream is = connection.getInputStream();
        OutputStream os = connection.getOutputStream();
        InputStreamReader isr = new InputStreamReader(is);
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedReader br = new BufferedReader(isr);
        BufferedWriter bw = new BufferedWriter(osw);

        bw.write("sXXXXX sXXXXX");
        bw.newLine();
        bw.newLine();
        bw.flush();

        String response = null;
        while ((response = br.readLine()) != null) {
            System.out.println(response);
        }
        System.out.println("<koniec transmisji>");

        connection.close();
    }
}
