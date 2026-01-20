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
public class Triangulo extends FiguraGeometrica {
    private double lado1;
    private double lado2;
    private double lado3;

    public Triangulo(double lado1, double lado2, double lado3, String colorLinea, String colorRelleno) {
        super(colorLinea, colorRelleno);
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    public double calcularPerimetro() {
        double aux;
        aux = getLado1() + getLado2() + getLado3();
        return aux;
    }
    
    public double calcularArea() {
        double aux= this.calcularPerimetro();
        aux = aux * ((aux - getLado1()) * (aux - getLado2()) * (aux - getLado3()));
        return Math.sqrt(aux);
    }
    
     public String toString () {
        String aux = "triangulo" + "color linea: " + getColorLinea() + ", color Relleno: " + getColorRelleno() +"\n";
        aux += "Lado1: " + getLado1() + ", Lado2: " + getLado2() + ", Lado3: " + getLado3() + "\n"
                + "Perimetro: " + this.calcularPerimetro() + ", Area: " + this.calcularArea();
        return aux;    
     }
    public double getLado1() {
        return lado1;
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    public double getLado3() {
        return lado3;
    }

    public void setLado3(double lado3) {
        this.lado3 = lado3;
    }
    
    
}
