package concurrencia.metodosInteresantesThread;

public class SaludadorRunnable implements Runnable {

    private int periodoDeSaludo;

    public SaludadorRunnable(int milisegundos) {
        periodoDeSaludo = milisegundos;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++) {

            /** No es necesario en este caso porque lo hacemos en el catch del sleep
            if(Thread.interrupted()) {
                System.out.println("Hilo: " + Thread.currentThread().getName() + " termina su ejecución");
                return;
            } */

            try {
                Thread.sleep(periodoDeSaludo);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Hilo: " + Thread.currentThread().getName() + " termina su ejecución");
                return;
            }
            System.out.println("Hola me llamo: " + Thread.currentThread().getName() + " ["+i+"]");
        }
    }
}
