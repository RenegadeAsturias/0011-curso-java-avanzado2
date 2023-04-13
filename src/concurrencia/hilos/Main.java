package concurrencia.hilos;

public class Main {

    public static void main(String[] args) {

        Thread miHilo0 = new Thread(new SaludadorRunnable(), "Hilo0");
        miHilo0.start();

        Thread miHilo1 = new Thread(new SaludadorRunnable(), "Hilo1");
        miHilo1.start();

        Thread miHilo2 = new Thread(new SaludadorRunnable(), "Hilo2");
        miHilo2.start();

        SaludadorThread miHilo3 = new SaludadorThread();
        miHilo3.start();

    }
}
