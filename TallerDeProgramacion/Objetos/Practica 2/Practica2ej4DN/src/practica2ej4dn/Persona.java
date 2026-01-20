/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2ej4dn;

/**
 *
 * @author Nicolas
 */
public class Persona {
    private String nombre;
    private int edad;
    private int dni;

    public Persona(String unNombre, int unEdad, int unDni) {
        setNombre (unNombre);
        setEdad(unEdad);
        setDni (unDni);
    }

    @Override
    public String toString() {
        return "Persona: " + "nombre= " + nombre + ", edad= " + edad + ", dni= " + dni ;
    }

    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
    
    
    
    
    
}
