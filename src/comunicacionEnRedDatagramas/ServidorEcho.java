package comunicacionEnRedDatagramas;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ServidorEcho extends Thread {

    private DatagramSocket datagramSocket;
    private byte[] buffer = new byte[256];

    public ServidorEcho(int numeroDePuerto) {
        try {
            datagramSocket = new DatagramSocket(numeroDePuerto);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);
            datagramSocket.receive(paquete);
            InetAddress direccion = paquete.getAddress();
            int puerto = paquete.getPort();

            DatagramPacket paqueteEcho = new DatagramPacket(buffer, buffer.length, direccion, puerto);
            datagramSocket.send(paqueteEcho);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
