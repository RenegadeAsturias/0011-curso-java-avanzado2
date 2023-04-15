package concurrencia.interrumpirHilo;

public class Runnable implements java.lang.Runnable {

    @Override
    public void run() {

        try {
            System.out.println("Ejecutando Hilo: "+Thread.currentThread().getName());
            Thread.sleep(10000);

            double duracion = Math.random() * 20000;
            System.out.println(Thread.currentThread().getName() + ": Impresora imprimiendo un documento durante " + duracion / 1000 + "segundos");
            Thread.sleep((long) duracion);

            System.out.println("Se ejecutó el Hilo: "+Thread.currentThread().getName());

        } catch (InterruptedException e) {
            System.out.println("Se interrumpió el Hilo: "+Thread.currentThread().getName());
            return;

        } finally {
            System.out.println("Finally! Hilo: "+Thread.currentThread().getName());
        }

    }
}
