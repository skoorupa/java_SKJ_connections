import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class ClientUDP_DNS {
    public static void main(String[] args) throws IOException {
        byte[]doWyslania = {0x08, 0x54, 0x01, 0x00, 0x00, 0x01, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x03, 0x77, 0x77, 0x77, 0x02, 0x77, 0x70, 0x02, 0x70, 0x6c, 0x00, 0x00, 0x01, 0x00, 0x01};
        String dnsName = "8.8.8.8";
        int dnsPort = 53;
//------------------------------------------
        DatagramPacket packetToSend = new DatagramPacket(
                doWyslania,
                doWyslania.length,
                InetAddress.getByName(dnsName),
                dnsPort
        );
        DatagramSocket socket = new DatagramSocket();
        socket.send(packetToSend);
//------------------------------------------
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
        System.out.println(response);
        for(int i = 0; i < packetToRec.getLength(); i++) {
            System.out.print( ((int)packetToRec.getData()[i]) + " ");
        }
        System.out.println();

    }
}