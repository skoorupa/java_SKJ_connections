import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class ClientUDP {
    public static void main(String[] args) throws IOException {
        byte[] doWyslania = "Hello server!".getBytes();
        String serverName = "localhost";
        int serverPort = 9000;

        DatagramPacket packetToSend = new DatagramPacket(
                doWyslania,
                doWyslania.length,
                InetAddress.getByName(serverName),
                serverPort
        );
        DatagramSocket socket = new DatagramSocket();
        socket.send(packetToSend);

        DatagramPacket packetToRec = new DatagramPacket(
                new byte[1500],
                1500
        );
        socket.receive(packetToRec);
        String response = new String(
                packetToRec.getData(),
                0,
                packetToRec.getLength()
        );
        System.out.println(response);    }
}