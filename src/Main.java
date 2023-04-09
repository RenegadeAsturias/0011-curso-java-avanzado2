import expresionesLambda.MiValor;
import expresionesLambda.OperadorBinario;
import expresionesLambda.OperadorBinarioGenerico;
import expresionesLambda.OperadorUnario;
import referenciasMetodos.Calculadora;

import java.util.function.UnaryOperator;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // Creamos una referencia a una instancia de tipo MiValor
        // Y le asignamos una Expresión Lambda que ahora es la implementación del método obtenerValor
        MiValor miValor = () -> 2.5;
        System.out.println("miValor.obtenerValor() obtengo = "+miValor.obtenerValor());

        // Cuando solo tenemos un parámetro lo idea es que no pongamos paréntesis.
        OperadorUnario raizCuadrada = n -> Math.sqrt(n);
        System.out.println("La raíz cuadrada de 4 es = " + raizCuadrada.aplicar(4));

        // También podemos utilizar la interface para crear otra implementación. Por ejemplo:
        OperadorUnario triple = n -> 3 * n;

        OperadorBinario multiplicacion = (x,y) -> x*y;
        System.out.println("El resultado de multiplicar 5 por 6 es = " + multiplicacion.aplicar(5, 6));

        // Si el cuerpo de la Expresión Lambda tiene más de una línea pondremos llaves.
        // Y deberemos añadir un 'return'
        OperadorBinario multiplicacionBase = (x,y) -> {
            double base = 5;
            return x*y*base;
        };
        System.out.println("Ejemplo multiplicación base = " + multiplicacionBase.aplicar(5, 6));

        // Utilización de Genéricos para reutilizar nuestras interfaces funcionales:
        OperadorBinarioGenerico<String> concatenar = (x, y) -> x.concat(y);
        System.out.println("Genérico concatenar = "+concatenar.aplicar("Primero ", "Segundo"));

        OperadorBinarioGenerico<Integer> sumar = (x, y) -> x+y;
        System.out.println("Genérico sumar = "+sumar.aplicar(10, 20));

        // Java ya tiene interfaces genéricas predefinidas que satisfacen prácticamente
        // todos los posibles escenarios y es una buena práctica explorarlas y utilizarlas.
        // Y están en el paquete: java.util.function
        // Por ejemplo, vamos a utilizar el BinaryOperator que aplica a dos argumentos iguales
        BinaryOperator<String> concatenar2 = (x, y) -> x.concat(y);
        System.out.println("Genérico concatenar = "+concatenar2.apply("Primero ", "Segundo"));

        BinaryOperator<Integer> sumar2 = (x, y) -> x+y;
        System.out.println("Genérico sumar = "+sumar2.apply(10, 20));

        /**
         Si comenzamos a añadir diferentes métodos a nuestra interface funcional
         puede ocurrir que el próximo desarrollador que vaya a trabajar sobre ella,
         ni siquiera se de cuenta de que es funcional y comience a añadir métodos abstractos.
         Para que esto no ocurra tenemos la etiqueta FunctionalInterface
         y la utilizaremos así:

         @FunctionalInterface
         public interface OperadorBinarioGenerico<T> {
         T aplicar(T operando1, T operando2);
         }

         Y ahora si añadimos un nuevo método abstracto nos dará error al compilar
         'Multiple non-overriding abstract methods found in interface expresionesLambda.OperadorBinarioGenerico'
        */

        /**
         Podemos resumir que dentro de las expresiones lambda
         podemos acceder y modificar las variables de instancia de la clase
         en la que es declarada sin ninguna restricción:
         pero solo podremos acceder a las variables locales
         del entorno donde se declara la lambda si estas son efectivamente final.
        */

        /**
         Cuando en las Expresiones Lambda hacemos referencia a 'this'
         no nos referimos a la expresión en sí, sino a la clase donde está definida.
         Para demostrarlo definimos en nuestra clase una variable de instancia por ejemplo:

         private String miVariableDePrueba = "Variable de Instancia";

         Y dentro de la Expresión Lambda definimos otra variable local con el mismo nombre.
         Imprimiremos el valor de la variable con el mismo nombre referenciándola con this
         y el valor que se mostrará es el valor de la variable de Instancia:
         'Variable de Instancia' porque el this hace referencia a la clase donde está definida.

         UnaryOperator<Double> operacion = n -> {
            String miVariableDePrueba = "Variable Local";
            System.out.printnln("miVariableDePrueba = "+this.miVariableDePrueba);
            return miVariableDePrueba;
         }
        */

        /**
         En Java 8, junto a la inclusión de las expresiones Lambda se añadió la funcionalidad de las referencias a métodos
         que no es otra cosa que poder hacer referencia a un método sin ejecutarlo esto nos provee de una sintaxis más clara
         para las expresiones lambda que consisten en una única llamada a un método vamos a ver algún ejemplo:

         +Comenzaremos por las referencias a métodos estáticos

         Definimos la clase Claculadora:
         public class Calculadora {
             public static int sumar(int a, int b) {
                 return a + b;
             }
         }

         Y podríamos conseguir resolver la suma utilizando:
        */
        BinaryOperator<Integer> suma = (a, b) -> a + b;
        System.out.println("La suma de 2 y 3 es = " + suma.apply(2, 3));

        /** Como eso ya lo tenemos implementado en nuestra clase calculadora
        cambiamos la implementación del método utilizando la expresión lambda anterior por
        la referencia al método estático de nuestra Clase Calculadora: */

        BinaryOperator<Integer> suma2 = Calculadora::sumar;
        System.out.println("La suma de 2 y 3 es = " + suma2.apply(2, 3));

        /**
         No solo nos podemos refererir a métodos estáticos
         también nos podemos refererir a métodos de instancia de objetos.

         Utilizaremos una Interface Funcional que no tiene parámetros
         y que devuelva un valor es Supplier.
        */
        String miString = "Hola me llamo María";

        Supplier<String> mayusculas = miString::toUpperCase;
        System.out.println("miString en mayúsculas es " + mayusculas.get());
        // miString en mayúsculas es HOLA ME LLAMO MARÍA

        /**
        Y también podemos hacer referencia a constructores
        */
        UnaryOperator<String> constructorDeStrings = String::new;
        String unString = constructorDeStrings.apply("Casa");
        String otroString = constructorDeStrings.apply("Perro");
    }
}