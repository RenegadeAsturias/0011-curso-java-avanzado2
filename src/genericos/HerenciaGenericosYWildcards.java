package genericos;

import java.util.ArrayList;

public class HerenciaGenericosYWildcards {

    public static void main(String[] args) {

        Number miNumber = 22;
        Integer miInteger = 55;

        ArrayList<Number> miLista = new ArrayList<>();
        miLista.add(miNumber);
        miLista.add(miInteger);

        mostrarLista(miLista); // Mostrar Lista de Numbers

        // ***********************************************************

        ArrayList<Integer> miOtraLista = new ArrayList<>();
        miOtraLista.add(miInteger);

        // El método: mostrarLista(ArrayList<Number> lista
        // No acepta listas de tipo Integer
        // mostrarLista(miOtraLista);

        // Si en el método mostrarLista cambiamos el tipo Number
        // por una WildCard con interrogante: ArrayList<?>
        // el método aceptará todos los tipos de ArrayLista pero no funcionaría el bucle porque el tipo
        // de la lista podría no extender de la clase Number
        // Debemos especificar que queremos que la clase que se admita por el Wildcard debe extender la clase Number
        // ArrayList<? extends Number>

        mostrarLista2(miLista);     // Mostrar Lista de Numbers+Integers
        mostrarLista2(miOtraLista); // Mostrar Lista de Integers

        // Con esta WildCard estamos especificando que la clase debe ser Number o una que extienda de esa:
        // ArrayList<? extends Number>
        // Y por tanto está acotada superiormente.

        // También existen las WildCars acotadas inferiormente
        // En la que podemos indicar que el tipo de argumento requido es del indicado
        // o de una superclase del mismo.
        // Si queremos que el método 'mostrarLista3' solo acepte Integers o sus superclases,
        // o sea, Number u Object utilizaremos la palabra 'super'
        // Entonces pondremos:
        // public static void mostrarLista3(ArrayList<? super Integer> lista) {
        // Y la lista solo aceptará Integers, Numbers u Objects.

        ArrayList<Object> miListaObjects = new ArrayList<>();
        miListaObjects.add("Lunes");

        mostrarLista3(miLista);     // Mostrar Lista de Numbers+Integers
        mostrarLista3(miOtraLista); // Mostrar Lista de Integers
        mostrarLista3(miListaObjects); // Mostra Lista de Objetos

    }

    public static void mostrarLista(ArrayList<Number> lista) {
        for(Number item: lista) {
            System.out.println("item = " + item);
        }
    }

    public static void mostrarLista2(ArrayList<? extends Number> lista) {
        for(Number item: lista) {
            System.out.println("item = " + item);
        }
    }

    public static void mostrarLista3(ArrayList<? super Integer> lista) {
        for(Object item: lista) {
            System.out.println("item = " + item);
        }
    }

}
