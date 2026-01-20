/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication27;

/**
 *
 * @author Nicolas
 */
public class Cliente {
    private String nombre;
    private int DNI;
    private int edad;
    
    
    public Cliente () {
        nombre = "x";
        DNI = 0;
        edad = 0;
    }
    
    public Cliente (String unNombre, int unDNI, int unaEdad) {
        nombre = unNombre;
        DNI = unDNI;
        edad = unaEdad;
        
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
    
    


    @Override
    public String toString () {
        String aux;
        aux= "El señor " + nombre + " con dni " + DNI + " con edad " + edad;
        return aux;
    }
    
}
    