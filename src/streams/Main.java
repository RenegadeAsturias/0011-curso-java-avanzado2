package streams;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        /**
         Cuando trabajamos con Streams, nuestros pipelines siempre deben terminar
         con una operación terminal que produce un resultado diferentes a un stream.

         Operaciones terminales interesantes que nos ofrece la clase Stream:

         -La operación terminal forEach realiza una acción a cada elemento del stream.
        */

         Stream.of(8, 15, -3, 24, -99)
                .sorted()
                .forEach(System.out::println);

         // Para guardar el resultado en un Array tenemos el operador terminal 'toArray'
        Object[] miArray =  Stream.of(8, 15, -3, 24, -99)
                .sorted()
                .toArray();

        // Para guardar el resultado en otro Contenedor tenemos el operador terminal 'collect'
        Set<Object> miSet =  Stream.of(8, 15, -3, 24, -99)
                .sorted()
                .collect(Collectors.toSet());

        /** Otro operador terminal interesante es 'reduce'
        Una operación de reducción toma una serie de elementos de entrada
        y los va combinando, aplicando repetidamente una operación.

        Vamos a utilizarla, por ejemplo, para hallar la multiplicación
        de todos los números de nuestro Stream. */

        // Esto devuelve un Optional
        // Returns: an Optional describing the result of the reduction
        // Este Optional contendrá nuestra reducción si ha sido exitosa

        Optional<Integer> optional = Stream.of(8, 15, -3, 24, -99)
                .sorted()
                .reduce((a,b) -> a*b);

        System.out.println("El producto final es = " + optional.get());


        /** Existen algunas operaciones de reducción
         que ya están implementadas en la clase Stream para utilizar directamente.
         Por ejemplo, la operación 'sum'
         que tiene que ser aplicada a un stream de tipo numérico, por ejemplo, un IntStream */

        int suma = IntStream.of(8, 15, -3, 24, -99)
                .sorted()
                .sum();

        System.out.println("La suma final es = " + suma);


        /** Existen otras operaciones de reducción implementadas como 'min', 'max' o 'count'.
        Para conocerlas es interesante explorar las interfaces,
        Stream, IntStream, LongStream o DoubleStream. */

        /** Vamos a ver operaciones que producen resultados booleanos:
        Operación 'anyMatch'
        que nos indica si alguno de los elementos del Stream cumple una determinada condición. */

        boolean mayorQueDiez = IntStream.of(8, 15, -3, 24, -99)
                .sorted()
                .anyMatch(i -> i>10);

        System.out.println("¿Hay algún elemento mayor que diez? " + mayorQueDiez);


        /** Operación 'allMatch'
        que nos indica si todos los elementos del Stream cumplen una determinada condición. */
        boolean todosMayorQueCien = IntStream.of(8, 15, -3, 24, -99)
                .sorted()
                .allMatch(i -> i>100);

        System.out.println("¿Todos los elemento son mayor que cien? " + todosMayorQueCien);

        /** Operación 'noneMatch'
         que nos indica si ninguno de los elementos del Stream cumplen una determinada condición. */
        boolean ningunoMayorQueCien = IntStream.of(8, 15, -3, 24, -99)
                .sorted()
                .noneMatch(i -> i>100);

        System.out.println("¿Ninguno de los elemento son mayor que cien? " + ningunoMayorQueCien);


    }

}
