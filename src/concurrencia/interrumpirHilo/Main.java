package concurrencia.interrumpirHilo;

public class Main {

    public static void main(String[] args) {
        Thread miHilo1 = new Thread(new Runnable(), "HILO1");
        Thread miHilo2 = new Thread(new Runnable(), "HILO2");
        Thread miHilo3 = new Thread(new Runnable(), "HILO3");

        miHilo1.start();
        miHilo2.start();
        miHilo3.start();

        miHilo2.interrupt();
    }

}
