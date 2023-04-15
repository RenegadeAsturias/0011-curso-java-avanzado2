package concurrencia.interfazLock;

public class ImprimirImpresoraRapidaCalidad implements Runnable {

    private ImpresoraRapidaCalidad impresora;

    public ImprimirImpresoraRapidaCalidad(ImpresoraRapidaCalidad impresora) {
        this.impresora = impresora;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + ": Quiere imprimir un documento");
        impresora.imprimir(new Object());
    }
}
