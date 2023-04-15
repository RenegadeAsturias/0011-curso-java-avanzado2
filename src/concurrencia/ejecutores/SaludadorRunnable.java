package concurrencia.ejecutores;

public class SaludadorRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Hola me llamo " + Thread.currentThread().getName());
    }



}
