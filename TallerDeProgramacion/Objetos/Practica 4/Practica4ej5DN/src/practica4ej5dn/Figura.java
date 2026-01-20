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
public abstract class Figura {
    private String relleno;
    private String linea;

    public Figura(String relleno, String linea) {
        setRelleno(relleno);
        setLinea(linea);
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
    
    
    
    
    public abstract double calcularArea();
    public abstract String toString();
    
    
}
