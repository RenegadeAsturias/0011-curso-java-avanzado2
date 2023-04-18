package modulos.mparrastia.estructuras;

public class Frase {

    private String autor;
    private String frase;

    public Frase(String frase, String autor) {
        this.autor = autor;
        this.frase = frase;
    }

    public String getAutor() {
        return autor;
    }

    public String getFrase() {
        return frase;
    }
}
