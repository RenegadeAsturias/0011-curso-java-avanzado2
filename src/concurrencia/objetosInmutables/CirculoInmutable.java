package concurrencia.objetosInmutables;

import java.awt.*;

public final class CirculoInmutable {

    private final double radio;
    private final Color color;

    public CirculoInmutable(double radio, Color color) {
        this.radio = radio;
        this.color = new Color(color.getRGB());
    }

    public double obtenerRadio() {
        return radio;
    }

    public Color obtenerColor() {
        return new Color(color.getRGB());
    }

    public double obtenerDiametro() {
        return radio * 2;
    }

    public double obtenerArea() {
        return Math.PI  * Math.pow(radio, 2);
    }

    public Circulo escalar(double factor) {
        return new Circulo(radio * factor, color);
    }

}
