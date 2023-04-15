package concurrencia.interfazLock;

public class ImprimirImpresora implements Runnable {

    private Impresora impresora;

    public ImprimirImpresora(Impresora impresora) {
        this.impresora = impresora;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + ": Quiere imprimir un documento");
        impresora.imprimir(new Object());
    }
}
