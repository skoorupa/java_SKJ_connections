import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class ServerUDP {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9000);
        DatagramPacket packetToRec = new DatagramPacket(
                new byte[1500],
                1500
        );

        socket.receive(packetToRec);

        String response = new String(packetToRec.getData(), 0, packetToRec.getLength());
        System.out.println(response);

        DatagramPacket packetToSend = new DatagramPacket(
                "Hello client!".getBytes(),
                "Hello client!".length(),
                packetToRec.getAddress(),
                packetToRec.getPort()
        );
        socket.send(packetToSend);
    }
}