package concurrencia.objetosInmutables;

import java.awt.*;

public class Circulo {

    private double radio;
    private Color color;

    public Circulo(double radio, Color color) {
        this.radio = radio;
        this.color = color;
    }

    public void establecerRadio(double radio) {
        this.radio = radio;
    }

    public void establecerColor(Color color) {
        this.color = color;
    }

    public double obtenerRadio() {
        return radio;
    }

    public Color obtenerColor() {
        return color;
    }

    public double obtenerDiametro() {
        return radio * 2;
    }

    public double obtenerArea() {
        return Math.PI  * Math.pow(radio, 2);
    }

    public void escalar(double factor) {
        radio *= factor;
    }

}
