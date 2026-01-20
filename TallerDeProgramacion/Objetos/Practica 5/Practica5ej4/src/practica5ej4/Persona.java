/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5ej4;

/**
 *
 * @author Nicolas
 */
public abstract class Persona {
    private String nombre;
    private int DNI;
    private int edad;

    
    
    public Persona (String unNombre, int unDNI, int unEdad ){
        setNombre (unNombre);
        setDNI (unDNI);
        setEdad (unEdad);
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

public abstract String toString();

}
