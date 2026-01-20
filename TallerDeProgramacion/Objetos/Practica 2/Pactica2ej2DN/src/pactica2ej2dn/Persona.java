/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pactica2ej2dn;

/**
 *
 * @author Nicolas
 */
public class Persona {
    private String nombre;
    private int edad;
    private int dni;

    public Persona (String unNombre, int unEdad, int unDni) {
        setDni(unDni);
        setNombre (unNombre);
        setEdad (unEdad);
    }

    @Override
    public String toString() {
        return "Persona:" + "nombre= " + getNombre() + ", edad=" + getEdad() + ", dni=" + getDni();
    }

    private String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getDni() {
        return dni;
    }
    
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
    
    
}
