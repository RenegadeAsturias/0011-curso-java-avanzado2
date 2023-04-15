package concurrencia.ejecutores;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainCallable {

    public static void main(String[] args) {

        Thread miHilo1 = new Thread(new SaludadorRunnable(), "HILO1");
        miHilo1.start();

        // Este Excutor solo tiene varios Hilos para ejecutar las tareas y los utiliza según disponibilidad
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Future<Integer> future = executorService.submit(new CalculadorCallable());

        System.out.println("¿Ha terminado la tarea? "+future.isDone()); // Aquí aún no ha terminado

        // si llamamos al método 'get' del Future conseguiremos que el hilo actual se bloquee
        // hasta que la tarea se haya terminado

        Integer resultado = 0;
        try {
            resultado = future.get();
            System.out.println("¿Ha terminado la tarea? "+future.isDone()); // Aquí aún no ha terminado
            System.out.println("El resultado es :"+resultado);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }


        // Para que dejen de estar disponibles utilizamos shutdown o shutdownNow
        executorService.shutdown();
    }
}
