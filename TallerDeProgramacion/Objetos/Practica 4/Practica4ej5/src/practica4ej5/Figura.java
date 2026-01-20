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
public abstract class  Figura {
    private String colorRelleno = "x";
    private String colorLinea;

    public Figura (String unColorRelleno, String unColorLinea) {
        setColorRelleno (unColorRelleno);
        setColorLinea (unColorLinea);
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
    
    public String toString() {
        String aux = this.auxToString() + 
                    " con color de Relleno" + getColorRelleno() + 
                    " y con color de Linea " + getColorLinea (); 
        
                    
        return aux;
    }
    
    
    public abstract String auxToString();
    public abstract double calcularArea();
    public abstract double calcularPerimetro();
    
}
