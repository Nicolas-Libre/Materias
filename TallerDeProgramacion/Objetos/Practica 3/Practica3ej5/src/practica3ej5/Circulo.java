/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3ej5;

/**
 *
 * @author Nicolas
 */
public class Circulo {
    private double radio;
    private String colorRelleno;
    private String colorLinea;
    
    
    public Circulo (double unRadio, String unColorRelleno, String unColorLinea) {
        radio = unRadio;
        colorRelleno = unColorRelleno;
        colorLinea = unColorLinea;
    }
    
    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public String getColorRelleno() {
        return colorRelleno;
    }

    public void setColorRelleno(String colorRelleno) {
        this.colorRelleno = colorRelleno;
    }

    public String getColorLinea() {
        return colorLinea;
    }

    public void setColorLinea(String colorLinea) {
        this.colorLinea = colorLinea;
    }

    public double calcularPerimetro (){
        double auxPerimetro;
        auxPerimetro = (2 * Math.PI * radio);
        return auxPerimetro;
    }
    
    public double calcularArea () {
        double auxArea;
        auxArea = Math.PI * (radio * radio);
        return auxArea;
    }

    @Override
    public String toString () {
        String aux;
        aux = ("El color del relleno del Circulo es " + colorRelleno + ", el color de la linea es " + colorLinea + "el perimetro es " + calcularPerimetro() + " y el area es " + calcularArea ());
        return aux;
    }
}
