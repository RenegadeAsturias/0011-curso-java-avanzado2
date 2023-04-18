package modulos.mparrastia.interfaz;

import modulos.mparrastia.estructuras.Frase;
import modulos.mparrastia.frases.GestorFraseDelDia;

public class Main {
    public static void main(String[] args) {
        GestorFraseDelDia gestorFraseDelDia = new GestorFraseDelDia();
        Frase fraseDelDia = gestorFraseDelDia.obtenerfraseDelDia();
        System.out.println("Frase del dia: " + fraseDelDia.getFrase() + " por " + fraseDelDia.getAutor());

    }
}
