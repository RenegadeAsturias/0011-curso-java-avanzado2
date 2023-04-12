package ejemplos.lambdas;

import java.util.ArrayList;

public class EjemploColecciones {

    public static void main(String[] args) {

        // Ejemplo de recorrer colecciones utilizando expresiones Lambda

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Lunes");
        arrayList.add("Martes");
        arrayList.add("Miércoles");
        arrayList.add("Jueves");
        arrayList.add("Viernes");

        // El método forEach de la clase Iterable tiene como parámeto
        // un objeto de tipo Consumer que es una interfaz funcional.
        // Lo que hace el método forEach es ejecutar el método por cada elemento de la colección.

        // Así mostraremos cada uno de los elementos de nuestra lista utilizando expresiones Lambda
        arrayList.forEach(s -> System.out.println(s));

        // Y podemos sustituir la expresión Lambda por una referencia al método
        // lo cuál es una buena práctica.
        arrayList.forEach(System.out::println);

    }

}
