package es.joseljg.tiendaderopa.clases;

import java.io.Serializable;
import java.util.Objects;

public class Ropa implements Serializable {
    // atributos
    private String codropa;
    private String tipo;
    private String talla;
    private String color;
    private double preciov;
    //------------------------------------------


    public Ropa(String codropa, String tipo, String talla, String color, double preciov) {
        this.codropa = codropa;
        this.tipo = tipo;
        this.talla = talla;
        this.color = color;
        this.preciov = preciov;
    }

    public String getCodropa() {
        return codropa;
    }

    public void setCodropa(String codropa) {
        this.codropa = codropa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPreciov() {
        return preciov;
    }

    public void setPreciov(double preciov) {
        this.preciov = preciov;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ropa)) return false;
        Ropa ropa = (Ropa) o;
        return Double.compare(ropa.preciov, preciov) == 0 && codropa.equals(ropa.codropa) && Objects.equals(tipo, ropa.tipo) && Objects.equals(talla, ropa.talla) && Objects.equals(color, ropa.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codropa, tipo, talla, color, preciov);
    }

    @Override
    public String toString() {
        return "Ropa{" +
                "codropa='" + codropa + '\'' +
                ", tipo='" + tipo + '\'' +
                ", talla='" + talla + '\'' +
                ", color='" + color + '\'' +
                ", preciov=" + preciov +
                '}';
    }
}
