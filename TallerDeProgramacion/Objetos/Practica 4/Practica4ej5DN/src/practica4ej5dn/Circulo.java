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
public class Circulo extends Figura {
    private double radio;

    public Circulo(double radio,String relleno, String linea) {
        super(relleno,linea);
        setRadio(radio);
    }

    public double calcularArea() {
        double aux = getRadio() * getRadio();
        return Math.PI * aux;
                
    }
    
    public String toString(){
        String aux = "Circulo, ";
        aux+= "radio = " + getRadio() + "\n"
                + "Area = " + calcularArea();
        return aux;
    } 
    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
    
    
    
    
}
