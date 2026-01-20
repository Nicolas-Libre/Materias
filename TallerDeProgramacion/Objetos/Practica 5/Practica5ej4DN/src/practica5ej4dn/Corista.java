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
public class Corista extends Persona {
    
    private int tono;

    public Corista(int tono, String nombre, int dni, int edad) {
        super(nombre, dni, edad);
        setTono(tono);
    }

    
    public String toString() {
        return super.toString() + ", tono= " + getTono();
    }
    
    public int getTono() {
        return tono;
    }

    public void setTono(int tono) {
        this.tono = tono;
    }

    
    
    
    
    
    
    
}
