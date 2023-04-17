package comunicacionEnRedDatagramas;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ClienteEcho {
    private DatagramSocket datagramSocket;
    private InetAddress direccionDelServidor;
    private int puertoDelServidor;
    private byte[] buffer;

    public ClienteEcho(InetAddress direccionDelServidor, int puertoDelServidor) {
        this.direccionDelServidor = direccionDelServidor;
        this.puertoDelServidor = puertoDelServidor;
        try {
            datagramSocket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public String enviarMensaje(String mensaje) {
        try {
            buffer = mensaje.getBytes();
            DatagramPacket paquete = new DatagramPacket(buffer, buffer.length, direccionDelServidor, puertoDelServidor);
            datagramSocket.send(paquete);
        } catch (IOException e) {
            e.printStackTrace();
        }

        DatagramPacket paqueteEcho = null;
        try {
            paqueteEcho = new DatagramPacket(buffer, buffer.length);
            datagramSocket.receive(paqueteEcho);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String mensajeRecibido = new String(paqueteEcho.getData(), 0, paqueteEcho.getLength());
        return mensajeRecibido;
    }

}
