package concurrencia.ejecutores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainSaludador {

    public static void main(String[] args) {

        Thread miHilo1 = new Thread(new SaludadorRunnable(), "HILO1");
        miHilo1.start();

        // Este Excutor solo tiene un Hilo para ejecutar las tareas
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(miHilo1);
        executorService.submit(miHilo1);
        executorService.submit(miHilo1);

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Esta es otra tarea");
            }
        });

        // Este Excutor solo tiene varios Hilos para ejecutar las tareas y los utiliza según disponibilidad
        ExecutorService executorService2 = Executors.newFixedThreadPool(4);
        executorService2.submit(miHilo1);
        executorService2.submit(miHilo1);
        executorService2.submit(miHilo1);
        executorService2.submit(miHilo1);
        executorService2.submit(miHilo1);
        executorService2.submit(miHilo1);


        // Para que dejen de estar disponibles utilizamos shutdown o shutdownNow
        executorService.shutdown();
        executorService2.shutdown();
    }
}
