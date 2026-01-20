/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4ej5dn;

/**
 *
 * @author Nicolas
 */
public class Rectangulo extends Figura {
    private double base;
    private double altura;

    public Rectangulo(double base, double altura, String relleno, String linea) {
        super(relleno,linea);
        setBase(base);
        setAltura(altura);
    }

    
    public double calcularArea() {
        return getBase() * getAltura();
    }
    
    public String toString(){
        String aux = "Rectangulo: ";
        aux+= "base = " + getBase() + "y altura = " + getAltura() + "\n"
                + "Area = " + calcularArea();
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
