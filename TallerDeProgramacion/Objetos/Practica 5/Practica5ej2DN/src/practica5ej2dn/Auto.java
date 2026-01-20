/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5ej2dn;

/**
 *
 * @author Nicolas
 */
public class Auto {
    private String nombre;
    private int patente;

    public Auto(String nombre, int patente) {
        setNombre(nombre);
        setPatente(patente);
    }

    
    public String toString(){
        String aux;
        aux = "Dueño: " + getNombre() + ", patente " + getPatente() + "\n";
        return aux;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPatente() {
        return patente;
    }

    public void setPatente(int patente) {
        this.patente = patente;
    }
    
    
}
