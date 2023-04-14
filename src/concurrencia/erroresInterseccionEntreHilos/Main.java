package concurrencia.erroresInterseccionEntreHilos;

public class Main {

    public static void main(String[] args) {

        /** Errores de la interacción entre hilos
            a veces es complicado prever el orden de sucesión de acontecimientos
            cuando tenemos dos o más hilos accediendo al mismo tiempo a los mismos recursos

            Cuando introducimos concurrencia en nuestras aplicaciones podemos encontrarnos
            con dos tipos de errores:

            +ERRORES: Interferencia entre hilos
            Los Errores de Interferencia se producen cuando al mismo tiempo se realizan dos o más operaciones
            sobre un mismo dato en diferentes hilos intercambiándose entre sí.
            El problema ocurre cuando estas operaciones constan de varias instrucciones
            y estas se solapan aun cuando solo consten de una única instrucción que podemos creer que se realizará en un paso
            no sabemos en cuántos pasos será esa instrucción dividida por la máquina virtual de Java.

            // ******************************************************************************************************

            +ERRORES: Errores de consistencia de memoria
            los Errores de Consistencia de memoria se producen cuando dos hilos tienen versiones diferentes
            de lo que debería ser el mismo dato.


            EJEMPLO: +ERRORES: Interferencia entre hilos
            Partimos de una clase simple:

            public class InterferenciaEntreHilosContador {
                private int c = 0;
                public void incrementar() { c++; }
                public void decrementar() { c--; }
                public int obtenerValor() { return c; }
            }

            Tenemos una clase contador con una única variable de instancia de tipo int
            y tres métodos un método que sirve para incrementar su valor en uno, un método que sirve para decrementar su valor también en uno
            y un método para obtener el valor de la variable de instancia.
            Imaginemos ahora que dos hilos están actuando sobre un mismo objeto de tipo contador supongamos que ambos hilos
            llaman al mismo tiempo al método incremental.
            Podemos pensar que no pasará nada extraño que cada uno incrementará en uno la variable y el resultado será lo esperado
            pero esto no es así porque la operación de incrementar en realidad tiene más de un paso
            y la máquina virtual de Java la divide en tres pasos:
            (1) obtener el valor de c
            (2) incrementar ese valor en uno
            (3) guardar el valor obtenido en C
            veamos paso a paso el problema que nos encontraremos
            supongamos que inicialmente C tiene un valor de cero y que hilo A e hilo B llaman al método implementar al mismo tiempo
            y el hilo A obtiene el valor c = 0
            y el hilo B obtiene el valor c = 0
            y el hilo A incrementa el valor c = 1
            y el hilo B incrementa el valor c = 1
            y el hilo A guarda el valor de c = 1
            y el hilo B guarda el valor de c = 1
            Entonces hemos perdido una unidad por el camino y esto en algunos escenarios puede ser catastrófico
            imaginemos que estamos intentando otorgar identificadores únicos secuenciales
            a las peticiones que recibimos en nuestro servidor en este caso tendríamos dos peticiones diferentes
            con el mismo identificador además este tipo de errores son difíciles de detectar
            ya que se producirán solo a veces y son impredecibles


            +ERRORES: Interferencia entre hilos
            Vamos a ver un mecanismo que nos puede llevar a problemas de inconsistencia de memoria

            Cuando trabajamos con variables no volátiles la máquina virtual de Java puede optar por copiar variables de la memoria principal
            a la caché de la CPU mientras trabaja con ellas para mejorar el rendimiento.
            Si la máquina contiene más de una CPU cada hilo puede correr en una CPU diferente
            y realizar la copia en su correspondiente caché y nosotros no tenemos control ni podemos saber
            cuando la máquina virtual de Jaba decide copiar la variable a la caché de la CPU
            y cuando decide volver a pasarla a la memoria principal y esto hace que las modificaciones de un hilo no se vean por el otro.
            Los errores de consistencia de memoria son bastante contraintuitivos y sus causas son bastante complejas.
            Partiendo del ejemplo anterior del contador vamos a ver un error inesperado que puede ocurrirnos.
            Vamos a suponer que partimos con el valor de la variable C a cero
            si desde el hilo a incrementamos el valor de nuestro contador
            y después desde ese mismo hilo A guardamos ese valor podemos estar completamente seguros de que veremos por pantalla el valor 1
            pero ¿qué ocurriría si incrementamos el valor de nuestro contador desde el hilo A y después intentamos acceder a ese valor desde el hilo B?
            A pesar de que estemos segurísimos de que el segundo paso ha ocurrido después del primero
            no tendremos nunca garantía de que el hilo B vea el valor modificado por el hilo A y bien podríamos obtener el valor cero.
            Para asegurarnos de que un hilo vea las modificaciones de otros tenemos que garantizar una relación conocida como: ocurre-antes
            Veamos qué mecanismos nos aseguran tener una relación ocurre-antes entre acciones.
            Cda acción en un hilo ocurre antes que las acciones en ese mismo hilo se vienen después en el orden del programa:
            (1) Mismo hilo, acciones en orden

            La sincronización es el primer mecanismo que nos permite evitar los problemas de interacción con hilos,
            con ella  lo que hacemos es bloquear una variable para que solo un hilo pueda modificarla
            y desbloquearla cuando la acción ha terminado
            pues bien el desbloqueo ocurre antes que cualquier bloqueo subsidiante
            y en consecuencia cualquier acción de antes del desbloqueo tendrá una relación de ocurre-antes
            con las que ocurran después del bloqueo.

            Podríamos evitar el problema anterior si bloqueamos el contador para el hilo A
            lo modificamos lo desbloqueamos lo bloqueamos para el hilo B y lo leemos.
            Es decir:
            (2) Sincronización:
            bloqueo - Hilo A modifica - desbloqueo - bloqueo - Hilo B lee
            Esto nos asegurará que el hilo B vea las modificaciones del hilo A.

            (3) Variables volatile
            Las variables volátil garantizan que su escritura y lectura serán hechas desde la memoria principal
            La escritura a una variable volátil ocurre antes que cualquier escritura o lectura subsecuente de la misma variable.
            Por lo tanto podríamos haber evitado nuestro problema anterior haciendo la variable C volátil
            siempre con precaución ya que podría empeorar el rendimiento de nuestro programa
            ya que suele ser más costoso leer de la memoria principal que de la caché.

            Una llamada a Start en un hilo ocurre antes que cualquier acción en ese hilo.
            + start()
            Todas las acciones en un hilo ocurren antes que una llamada exitosa al método join de ese hilo.
            + join()
            Los métodos y clases del paquete:
            +java.util.concurrent tienen mecanismos que extienden estas garantías de relación ocurren antes.
        */

    }
}
