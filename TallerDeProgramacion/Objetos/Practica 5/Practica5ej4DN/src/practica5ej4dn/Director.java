/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5ej4dn;

/**
 *
 * @author Nicolas
 */
public class Director extends Persona {
    
    private int antiguedad;

    public Director(int antiguedad, String nombre, int dni, int edad) {
        super(nombre, dni, edad);
        setAntiguedad(antiguedad);
    }


    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
    
    public String toString() {
        return super.toString() + ", antiguedad= " + getAntiguedad();
    }
    
    
    
    
    
}
