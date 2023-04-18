package modulos.mparrastia.utils;

import modulos.mparrastia.estructuras.Frase;

import java.util.Random;

public class GeneradorDeFrasesAleatorias {

    private static final Frase[] frases = {
            new Frase("No hay que ir para atrás ni para darse impulso", "Lao Tsé"),
            new Frase("No hay caminos para la paz; la paz es el camino", "Mahatma Gandhi"),
            new Frase("Aprende a vivir y sabrás morir bien", "Confucio"),
            new Frase("Cada día sabemos más y entendemos menos", "Albert Einstein"),
            new Frase("El dinero no puede comprar la vida", "Bob Marley"),
            new Frase("Lo que no te mata, te hace más fuerte", "Friedrich Nietzsche"),
            new Frase("La peor experiencia es la mejor maestra", "Kovo"),
            new Frase("Un amigo de todos es una amigo de nadie", "Aristóteles"),
            new Frase("Hace falta toda una vida para aprender a vivir", "Séneca"),
            new Frase("Aquel que más posee, más miedo tiene de perderlo", "Leonardo Da Vinci")
    };

    public static Frase obtenerFraseAleatoria() {
        Random random = new Random();
        int n = random.nextInt(frases.length);
        return frases[n];
    }
}
