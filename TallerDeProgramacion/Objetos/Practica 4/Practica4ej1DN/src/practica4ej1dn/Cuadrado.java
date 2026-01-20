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
public class Cuadrado extends FiguraGeometrica {
    private double lado;

    public Cuadrado(double lado, String colorLinea, String colorRelleno) {
        super(colorLinea, colorRelleno);
        this.lado = lado;
    }
    
    public double calcularPerimetro() {
        return (getLado() * 4);
    }
    
    public double calcularArea () {
        return (getLado () * getLado());
    }
    
    public String toString () {
        String aux= "cuadrado" + "color linea: " + getColorLinea() + ", color Relleno: " + getColorRelleno() + "\n";
        aux += "Lado: " + getLado() + "\n"
                + "Perimetro: " + this.calcularPerimetro() + ", Area: " + this.calcularArea();
        return aux;    
    }
    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }
    
    
    
}
