import java.util.function.UnaryOperator;

public class VariablesEnExpresionesLambda {

    private double miDouble = 10.0;
    private String miString = "Variable de instancia";

    public void miEjemplo() {

        double miDoubleLocal = 20.0;
        String miStringLocal = "Variable local";

        // Si utilizamos una variable local en nuestra expresión Lambda, no hay problema
        // UnaryOperator<Double> miOperador = n -> miDoubleLocal + n;

        // Pero si ahora intentamos modificar el valor de la variable local, nos mostrará error:
        // Variable used in lambda expression should be final or effectively final
        // miDoubleLocal++;

        // Si utilizamos una variable de instancia en nuestra expresión Lambda, no hay problema
        UnaryOperator<Double> miOperador = n -> miDouble + n;

        // Y si ahora intentamos modificar el valor de la variable de instancia es correcto.
        miDouble++;

        /** Si intentamos modificar una variable en el cuerpo de la expresión Lambda también tendremos el mismo error
        Variable used in lambda expression should be final or effectively final
        UnaryOperator<Double> miOperador2 = n -> {
            miDoubleLocal++;
            return  miDoubleLocal + n;
        }; */

    }

}
