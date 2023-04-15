package concurrencia.ejecutores;

import java.util.concurrent.Callable;

public class CalculadorCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("Realizando un cálculo muy complicado y lento...");
        Thread.sleep(10000);
        return 99;
    }
}
