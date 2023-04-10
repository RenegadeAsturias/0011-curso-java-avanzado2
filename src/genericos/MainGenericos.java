package genericos;

import java.util.ArrayList;

public class MainGenericos {
    public static void main(String[] args) {
        Caja miCaja = new Caja();
        miCaja.set(58);

        // Esto nos dará un error en tiempo de Ejecución:
        // class java.lang.Integer cannot be cast to class java.lang.String
        // String miString = (String)miCaja.get();

        CajaGenerica<Integer> miCajaGenerica = new CajaGenerica<>();
        miCajaGenerica.set(58);

        // Esto nos dará un error en tiempo de Compilación
        // Inconvertible types; cannot cast 'java.lang.Integer' to 'java.lang.String'
        // String miStringGenerico = (String)miCajaGenerica.get();

        ArrayList<String> lstDias = new ArrayList<>();
        lstDias.add("Lunes"); lstDias.add("Martes");

        String[] diasLaborables = { "Lunes", "Martes", "Miércoles", "Jueves", "Viernes" };

        int contador = MetodosGenericos.contarTodasLasApariciones(diasLaborables, "Lunes");
    }
}
