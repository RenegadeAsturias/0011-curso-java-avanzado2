package concurrencia.interfazLock;

public class MainImpresoraRapidaCalidad {
    public static void main(String[] args) {

        ImpresoraRapidaCalidad impresora = new ImpresoraRapidaCalidad();
        Thread hilo1 = new Thread(new ImprimirImpresoraRapidaCalidad(impresora), "Hilo1");
        Thread hilo2 = new Thread(new ImprimirImpresoraRapidaCalidad(impresora), "Hilo2");
        Thread hilo3 = new Thread(new ImprimirImpresoraRapidaCalidad(impresora), "Hilo3");
        Thread hilo4 = new Thread(new ImprimirImpresoraRapidaCalidad(impresora), "Hilo4");
        Thread hilo5 = new Thread(new ImprimirImpresoraRapidaCalidad(impresora), "Hilo5");
        Thread hilo6 = new Thread(new ImprimirImpresoraRapidaCalidad(impresora), "Hilo1");
        Thread hilo7 = new Thread(new ImprimirImpresoraRapidaCalidad(impresora), "Hilo2");
        Thread hilo8 = new Thread(new ImprimirImpresoraRapidaCalidad(impresora), "Hilo3");
        Thread hilo9 = new Thread(new ImprimirImpresoraRapidaCalidad(impresora), "Hilo4");
        Thread hilo10 = new Thread(new ImprimirImpresoraRapidaCalidad(impresora), "Hilo5");
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
        hilo6.start();
        hilo7.start();
        hilo8.start();
        hilo9.start();
        hilo10.start();
    }
}
