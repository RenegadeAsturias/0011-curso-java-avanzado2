package streams;

public class Cliente {

    private String nombre;
    private String primerApellido;
    private String pais;

    public Cliente(String nombre, String primerApellido, String pais) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getPais() {
        return pais;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
