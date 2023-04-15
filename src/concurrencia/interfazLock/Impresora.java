package concurrencia.interfazLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Impresora {

    private final Lock impresoraLock = new ReentrantLock();

    public void imprimir(Object o) {

        impresoraLock.lock();
        try {
            double duracion = Math.random() * 10000;
            System.out.println(Thread.currentThread().getName() + ": Impresora imprimiendo un documento durante " + duracion / 1000 + "segundos");
            Thread.sleep((long) duracion);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + ": La impresión ha finalizado");
            impresoraLock.unlock();
        }
    }
}
