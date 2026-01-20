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
public abstract class Persona {
    private String nombre;
    private int dni;
    private int edad;

    
    public Persona(String nombre, int dni, int edad) {
        setNombre(nombre);
        setDni(dni);
        setEdad(edad);
    }

    @Override
    public String toString() {
        return "Nombre= " + getNombre() + ", dni= " + getDni() + ", edad= " + getEdad ();
    }
    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
    
    
    
}
