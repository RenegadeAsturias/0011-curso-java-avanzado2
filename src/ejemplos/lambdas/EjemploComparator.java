package ejemplos.lambdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EjemploComparator {

    public static void main(String[] args) {
        Persona persona1 = new Persona("Juan", "García");
        Persona persona2 = new Persona("Ana", "Martínez");
        Persona persona3 = new Persona("Laura", "Díaz");
        Persona persona4 = new Persona("Sandra", "Álvarez");

        List<Persona> lista = Arrays.asList(persona1, persona2, persona3, persona4);

        // Para ordenar la lista por Nombre:
        lista.sort((p1, p2) -> p1.getNombre().compareTo(p2.getNombre()));
        lista.forEach(System.out::println);

        // Para ordenar la lista por Nombre y utilizando el método comparing:
        lista.sort(Comparator.comparing(Persona::getNombre));
        lista.forEach(System.out::println);

        // Para ordenar la lista por Apellido:
        lista.sort(Comparator.comparing(Persona::getApellido));
        lista.forEach(System.out::println);

    }

}
