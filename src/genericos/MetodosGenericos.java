package genericos;

public class MetodosGenericos {

    // Los métodos también pueden introducir sus propios parámetros genéricos
    // Y esta declaración se limitará al ámbito del método.

    public static <T> int contarTodasLasApariciones(T[] lista, T objeto1) {
        int contador = 0;

        for(T objetoLista: lista) {
            if(objeto1.equals(objetoLista)) {
                System.out.println("objeto1 = " + objeto1);
                contador++;
            }
        }

        // Dentro del ámbito del método podemos utilizar el genérico
        // Por ejemplo:
        T miVariable;

        return contador;
    }

    public void otroMetodo() {

        // Fuera del ámbito del método no podemos utilizar el genérico de otro método:
        // Error: Cannot resolve symbol 'T'
        // T miVariable;
    }

}
