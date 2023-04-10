package streams;

import java.util.ArrayList;
import java.util.stream.Stream;

public class CarteraDeClientes {

    public static void main(String[] args) {
        ArrayList<Cliente> clientes = crearListaDeClientes();

        for (Cliente cliente : clientes) {
            if (cliente.getNombre().startsWith("M")) {
                System.out.println("CLÁSICO = "+cliente.toString());
            }
        }

        // Utilizando Streams, primer ejemplo
        clientes.stream()
                .filter(cliente -> cliente.getNombre().startsWith("M"))
                .forEach(System.out::println);

        // Utilizando Streams, segundo ejemplo
        clientes.parallelStream()
                .filter(cliente -> cliente.getNombre().startsWith("M"))
                .filter(cliente -> cliente.getPais().equalsIgnoreCase("ARGENTINA"))
                .forEach(System.out::println);

        /**
        Las operaciones que aplicamos sobre un stream que producen otro stream
        se llaman operaciones intermedias,
        estas operaciones no son ejecutadas hasta que no se invoca una operación terminal.

        Operaciones intermedias interesantes que nos ofrece la clase Stream:

        La Operación 'Filter' devuelve un nuevo Stream
        con los elementos que cumplen la condición que indiquemos.

        También utilizaremos el operador terminal 'forEach' para mostrar
        el resultado por pantalla. */

        clientes.stream()
                .filter(cliente -> cliente.getPais().equalsIgnoreCase("MÉXICO"))
                .forEach(System.out::println);


        /**
         La operación 'Peek' devulve un Stream
         con los elementos del Stream
         y adicionalmente realiza una acción a cada uno de estos elementos.

         Esto es muy útil cuando estamos trabajando con pipelines muy largos
         para debuggear o loggear una parte intermedia del proceso.

         Aplicamos algunos cambios y lo dejamos así:
         */
        clientes.stream()
                .filter(cliente -> cliente.getNombre().startsWith("M"))
                .filter(cliente -> cliente.getPais().equalsIgnoreCase("MÉXICO"))
                .count();

        // Supongamos que el contador nos devuelve un número estraño y queremos poner unas trazas
        // para ver qué nos están devolviendo cada filtro: 

        clientes.stream()
                .filter(cliente -> cliente.getNombre().startsWith("M"))
                .peek(cliente -> System.out.println("Cliente cuyo nombre empieza por M = " + cliente))
                .filter(cliente -> cliente.getPais().equalsIgnoreCase("MÉXICO"))
                .peek(cliente -> System.out.println("Cliente cuyo nombre empieza por M y es de MÉXICO = " + cliente))
                .count();


        /**
         La operación 'Map' transforma los elementos de un Stream utilizando la función que le pasemos.
         Creamos un nuevos Stream con los valores de los días laborales
         y la función map le pasamos una función para que convierta los valores en minúsculas
         e imprimimos por pantalla los valores del Stram*/

        Stream.of("LUNES","MARTES","MIÉRCOLES","JUEVES","VIERNES")
                .map(String::toLowerCase)
                .forEach(System.out::println);
        // Muestra: lunes martes miércoles jueves viernes


        /** Otra operación interesante es 'distinct',
        que devuelve un Stream con los elementos no duplicados según su método Equals */
        Stream.of("LUNES","MARTES","MIÉRCOLES","JUEVES","VIERNES", "MARTES")
                .distinct()
                .map(String::toLowerCase)
                .forEach(System.out::println);
        // Muestra: lunes martes miércoles jueves viernes (elimina el repetido)


        // La operación 'sorted' nos devuelve un Stream con los elementos ordenados
        Stream.of("LUNES","MARTES","MIÉRCOLES","JUEVES","VIERNES", "MARTES")
                .distinct()
                .sorted()
                .map(String::toLowerCase)
                .forEach(System.out::println);
        // Muestra: jueves lunes martes miércoles viernes



    }

    // Con streams:

    static ArrayList<Cliente> crearListaDeClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("GREGORIO", "HINOJOSA", "MÉXICO"));
        clientes.add(new Cliente("LORENA", "DE LUCAS", "COLOMBIA"));
        clientes.add(new Cliente("LAURA", "GARATE", "ESPAÑA"));
        clientes.add(new Cliente("JUAN CARLOS", "MORATALLA", "ARGENTINA"));
        clientes.add(new Cliente("JOSE CARLOS", "CORRALES", "PERÚ"));
        clientes.add(new Cliente("SEBASTIAN", "GALAN", "VENEZUELA"));
        clientes.add(new Cliente("JUANA", "MERA", "ARGENTINA"));
        clientes.add(new Cliente("MÓNICA", "MENDIZABAL", "MÉXICO"));
        clientes.add(new Cliente("PEDRO", "GARCÍA", "ESPAÑA"));
        clientes.add(new Cliente("ALBA", "ESPEJO", "CHILE"));
        clientes.add(new Cliente("JAIME", "VIZUETE", "ECUADOR"));
        clientes.add(new Cliente("MARÍA MAR", "CHECA", "GUATEMALA"));
        clientes.add(new Cliente("MARÍA", "CABANILLAS", "ARGENTINA"));
        clientes.add(new Cliente("JOSE CARLOS", "ARTIGAS", "BOLIVIA"));
        clientes.add(new Cliente("MANUEL", "SANTAMARIA", "REPÚBLICA DOMINICANA"));
        clientes.add(new Cliente("SILVIA", "GAMERO", "HONDURAS"));
        clientes.add(new Cliente("LUCIA", "ALCOLEA", "EL SALVADOR"));
        return clientes;
    }
}
