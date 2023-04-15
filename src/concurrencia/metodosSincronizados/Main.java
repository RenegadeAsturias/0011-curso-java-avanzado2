package concurrencia.metodosSincronizados;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Contador contador = new Contador();

        Thread miHilo1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<5000; i++) {
                    contador.incrementar();
                    System.out.println(Thread.currentThread().getName()+"["+i+"]. VALOR="+contador.obtenerValor());
                }
            }
        }, "HILO1");

        Thread miHilo2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<5000; i++) {
                    contador.incrementar();
                    System.out.println(Thread.currentThread().getName()+"["+i+"]. VALOR="+contador.obtenerValor());
                }
            }
        }, "HILO2");

        miHilo1.start();
        miHilo2.start();

    }
}
