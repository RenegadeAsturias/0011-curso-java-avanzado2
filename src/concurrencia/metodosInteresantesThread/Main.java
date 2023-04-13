package concurrencia.metodosInteresantesThread;

import concurrencia.metodosInteresantesThread.SaludadorRunnable;

public class Main {

    public static void main(String[] args) {

        Thread miHilo1 = new Thread(new SaludadorRunnable(6000), "Hilo1");
        miHilo1.start();

        Thread miHilo2 = new Thread(new SaludadorRunnable(2000), "Hilo2");
        miHilo2.start();

        /** Vamos a interrumpir el Hilo1
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        miHilo1.interrupt();
        */

        // Mientras los hilos sigan vivos no hacemos nada
        while (miHilo1.isAlive() || miHilo2.isAlive()){

        }

        // Después liberar recursos


        try {
            miHilo2.join(); // Se ejecuta cuando termina un Hilo determinado
            System.out.println("Terminó el Hilo2!!!!!!!!!!!!!!!!!!!");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            miHilo1.join(); // Se ejecuta cuando termina un Hilo determinado
            System.out.println("Terminó el Hilo1!!!!!!!!!!!!!!!!!!!");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
