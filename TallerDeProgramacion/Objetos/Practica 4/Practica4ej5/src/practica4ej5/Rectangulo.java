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
public class Rectangulo extends Figura {
    private double largo;
    private double ancho;

    public Rectangulo(double largo, double ancho, String unColorRelleno, String unColorLinea) {
        super(unColorRelleno, unColorLinea);
        setLargo (largo);
        setAncho (ancho);
    }

    
    public double calcularArea (){
        double aux = (getLargo() * getAncho());
        return aux;
        
    }
    
    public double calcularPerimetro () {
        double aux = ((getLargo()*2) + (getAncho()*2));
        return aux;
        
    }
    
    public double getLargo() {
        return largo;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }
    
    public String auxToString(){
        String aux = " Soy Rectangulo";
        return aux;
    }
    public String toString () {
        String aux = "Area: " + this.calcularArea()
                    + " Perimetro: " + this.calcularPerimetro();
        return aux;
        
    }
}
