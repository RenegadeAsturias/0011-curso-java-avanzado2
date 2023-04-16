package comunicacionEnRedSocketsCliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteEcho {

    private String nombreDeHost;
    private int numeroDePuerto;
    private Socket clienteSocket;
    private PrintWriter out;
    private BufferedReader in;

    public ClienteEcho(String nombreDeHost, int numeroDePuerto){
        this.nombreDeHost = nombreDeHost;
        this.numeroDePuerto = numeroDePuerto;
    }

    public void comenzarConexion() {
        try {
            clienteSocket = new Socket(nombreDeHost, numeroDePuerto);
            out = new PrintWriter(clienteSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String enviarMensaje(String mensaje) {
        System.out.println(mensaje);
        String respuesta = null;
        try {
            respuesta = in.readLine();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return respuesta;
    }

    public  void  pararConexion() {
        try {
            in.close();
            out.close();
            clienteSocket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
