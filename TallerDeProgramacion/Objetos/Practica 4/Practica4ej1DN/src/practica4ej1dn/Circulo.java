/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4ej1dn;

/**
 *
 * @author Nicolas
 */
public class Circulo extends FiguraGeometrica {
    private double radio;

    public double calcularPerimetro () {
        double aux;
        aux = 2* Math.PI * getRadio();
        return aux;
    }
    
    public double calcularArea() {
        double aux;
        aux = Math.PI * (getRadio() * getRadio());
        return aux;
    }
    
     public String toString () {
        String aux = "circulo" + "color linea: " + getColorLinea() + ", color Relleno: " + getColorRelleno() +"\n";
        aux += "Radio: " + getRadio() + "\n"
                + "Perimetro: " + this.calcularPerimetro() + ", Area: " + this.calcularArea();
        return aux;    
     }
    public Circulo(double radio, String colorLinea, String colorRelleno) {
        super(colorLinea, colorRelleno);
        this.radio = radio;
    }
    
    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    
    
    
    
}
