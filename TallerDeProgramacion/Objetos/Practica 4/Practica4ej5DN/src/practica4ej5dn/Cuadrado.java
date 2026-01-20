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
public class Cuadrado extends Figura {
    private double lado;

    public Cuadrado(double lado,String relleno, String linea) {
        super(relleno,linea);
        this.lado = lado;
    }
    
    public double calcularArea() {
        double aux = getLado() * getLado();
        return aux;
    }
    
    public String toString(){
        String aux = "Cuadrado: ";
        aux+= "Lado = " + getLado()  + "\n"
                + "Area = " + calcularArea();
        return aux;
    } 
    
    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }
    
    
    
    
    
}
