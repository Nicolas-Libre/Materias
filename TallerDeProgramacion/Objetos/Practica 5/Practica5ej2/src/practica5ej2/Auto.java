/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5ej2;

/**
 *
 * @author Nicolas
 */
public class Auto {
    private String nombreDueño;
    private int patente;

    public Auto (String unNombreDueño, int unaPatente) {
        setNombreDueño (unNombreDueño);
        setPatente (unaPatente);
    }
    
    public String getNombreDueño() {
        return nombreDueño;
    }

    public void setNombreDueño(String nombreDueño) {
        this.nombreDueño = nombreDueño;
    }

    public int getPatente() {
        return patente;
    }

    public void setPatente(int patente) {
        this.patente = patente;
    }
    
    public String toString () {
        String aux;
        aux = " | El dueño del auto es  " + getNombreDueño() + 
                " y  tiene patente " + getPatente ();
        return aux;
    }
    
    
}
