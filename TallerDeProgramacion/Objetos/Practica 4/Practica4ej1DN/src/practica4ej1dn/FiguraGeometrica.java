/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4ej1dn;

/**
 *
 * @author Nicolas
 */
public abstract class FiguraGeometrica {
    private String colorLinea;
    private String colorRelleno;

    public FiguraGeometrica(String colorLinea, String colorRelleno) {
        setColorLinea (colorLinea);
        setColorRelleno(colorRelleno);
    }

    public void despintar() {
        setColorLinea("negra");
        setColorRelleno ("blanco");
               
    }
    
    public String getColorLinea() {
        return colorLinea;
    }

    public void setColorLinea(String colorLinea) {
        this.colorLinea = colorLinea;
    }

    public String getColorRelleno() {
        return colorRelleno;
    }

    public void setColorRelleno(String colorRelleno) {
        this.colorRelleno = colorRelleno;
    }
    
    public abstract double calcularArea();
    public abstract double calcularPerimetro();
    public abstract String toString();
    
    
}
