package comunicacionEnRedSocketsServidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorEcho {

    private int numeroDePuerto;
    private Socket clienteSocket;
    private ServerSocket servidorSocket;
    private PrintWriter out;
    private BufferedReader in;

    public static void main(String[] args) {
        ServidorEcho servidorEcho = new ServidorEcho(5000);
        servidorEcho.comenzar();
    }

    public ServidorEcho(int numeroDePuerto) {
        this.numeroDePuerto = numeroDePuerto;
    }

    public void comenzar() {
        try {
            servidorSocket = new ServerSocket(numeroDePuerto);
            clienteSocket = servidorSocket.accept();
            out = new PrintWriter(clienteSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null){
                System.out.println(inputLine);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void parar() {
        try {
            in.close();
            out.close();
            servidorSocket.close();
            clienteSocket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
