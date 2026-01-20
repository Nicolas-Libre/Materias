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
public class Cuadrado extends Figura {
    private double lado;

    public Cuadrado(double lado, String unColorRelleno, String unColorLinea) {
        super(unColorRelleno, unColorLinea);
        setLado (lado);
    }

    public double calcularArea() {
        double aux = getLado() * getLado();
        return aux;
    }
    
    public double calcularPerimetro () {
        double aux = getLado() * 4;
        return aux;
    }
    
    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }
    
    public String auxToString(){
        String aux = " Soy Cuadrado";
        return aux;
    }
    
    public String toString () {
        String aux = "Area: " + this.calcularArea()
                    + " Perimetro: " + this.calcularPerimetro();
        return aux;
        
    }
    
}
