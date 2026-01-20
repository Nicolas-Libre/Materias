/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2ej1dn;

/**
 *
 * @author Nicolas
 */

public class Persona {
    private String nombre;
    private int edad;
    private int dni;
    
    public Persona (String unNombre,  int unEdad, int unDni) {
        nombre = unNombre;
        edad = unEdad;
        dni= unDni;
        
    }

    @Override
    public String toString() {
        return "Persona: " + "nombre= " + nombre + ", edad= " + edad + ", dni= " + dni;
    }
    
    
    
}
