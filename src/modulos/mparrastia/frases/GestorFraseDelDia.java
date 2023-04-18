package modulos.mparrastia.frases;

import modulos.mparrastia.estructuras.Frase;
import modulos.mparrastia.utils.GeneradorDeFrasesAleatorias;

public class GestorFraseDelDia {

    private Frase fraseDelDia;

    public Frase obtenerfraseDelDia() {
        if (fraseDelDia == null) {
           fraseDelDia = GeneradorDeFrasesAleatorias.obtenerFraseAleatoria();
        }
        return fraseDelDia;
    }
}
