/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3ej5dn;

/**
 *
 * @author Nicolas
 */
public class Circulo {
    private double radio;
    private String relleno;
    private String linea;

    public Circulo(double radio, String relleno, String linea) {
        setRadio (radio);
        setRelleno (relleno);
        setLinea (linea);
    }

    
    public double CalcularPetimetro(){
        double aux;
        aux = 2 * (Math.PI * getRadio());
        return aux;
                
    }
    
    public double CalcularArea () {
        double aux;
        aux = (getRadio()* getRadio()) * Math.PI;
        return aux;
    }
    
    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public String getRelleno() {
        return relleno;
    }

    public void setRelleno(String relleno) {
        this.relleno = relleno;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }
    
    
    
    
            
}
