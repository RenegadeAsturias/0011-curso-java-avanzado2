package ejemplos.lambdas;

public class EjemploRunnable {

    public static void main(String[] args) {

        // Tenemos un ejemplo de código clásico de cómo ejecutar un hilo
        // Al ponernos encima de: 'new Runnable()' el IDE nos informa:
        // Anonymous new Runnable() can be replaced with lambda
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Corriendo...");
            }
        });
        thread1.run();

        // Nuevo código sustituyéndolo por una Lambda
        Thread thread2 = new Thread( () -> System.out.println("Corriendo...") );
        thread2.run();

    }

}
