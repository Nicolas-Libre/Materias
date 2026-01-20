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
public class Rectangulo extends FiguraGeometrica {
    private double base;
    private double altura;

    public Rectangulo(double base, double altura, String colorLinea, String colorRelleno) {
        super(colorLinea, colorRelleno);
        this.base = base;
        this.altura = altura;
    }

    
    public double calcularPerimetro () {
        double aux = getBase() * 2;
        aux += getAltura() * 2;
        return aux;
    }
    public double calcularArea () {
        return (getBase() * getAltura()) /2;
    }
    
    public String toString () {
        String aux = "rectangulo" + "color linea: " + getColorLinea() + ", color Relleno: " + getColorRelleno() + "\n";
        aux += "Base: " + getBase() + ", Altura: " + getAltura() + "\n"
                + "Perimetro: " + this.calcularPerimetro() + ", Area: " + this.calcularArea();
        return aux;    
    }
    
    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    
    
}
