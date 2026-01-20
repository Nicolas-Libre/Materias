/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4ej5;

/**
 *
 * @author Nicolas
 */
public class Circulo extends Figura {
    private double radio;
    
    public Circulo (String CR, String CL, double unRadio){
        super (CR,CL);
        setRadio (unRadio);
    }
    
    public double calcularArea() {
        double aux = (radio * radio);
        return (Math.PI*aux);
    }
    
    public double calcularPerimetro () {
        double aux = (Math.PI * 2);
        return (aux * getRadio());
    }
    
    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
    
    public String toString () {
        String aux = "Area: " + this.calcularArea()
                    + " Perimetro: " + this.calcularPerimetro();
        return aux;
        
    }
    
    public String auxToString(){
        String aux = " Soy Circulo";
        return aux;
    }
    
}
