package comunicacionEnRedSocketsCliente;

public class Main {

    public static void main(String[] args) {
        try {
            ClienteEcho clienteEcho = new ClienteEcho("127.0.0.1", 5000);
            clienteEcho.comenzarConexion();

            String respuesta = clienteEcho.enviarMensaje("Hola");
            System.out.println("respuesta:"+respuesta);

            String respuesta2 = clienteEcho.enviarMensaje("¿Qué tal?");
            System.out.println("respuesta2:"+respuesta2);

            String respuesta3 = clienteEcho.enviarMensaje("Me llamo René");
            System.out.println("respuesta3:"+respuesta3);

            clienteEcho.pararConexion();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
