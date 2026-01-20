/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4ej3;

/**
 *
 * @author Nicolas
 */
public class Trabajador extends Persona {
    private String rol;
    
    
    public Trabajador (String unNombre, int unDNI, int unEdad, String unRol){
        super (unNombre,unDNI,unEdad);
        setRol (unRol);
        
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    public String toString() {
        String aux;
        aux = super.toString() + " Soy " + getRol();
        return aux;
    }
    
}
