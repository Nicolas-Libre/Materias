/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4ej3dn;

/**
 *
 * @author Nicolas
 */
public class Trabajador extends Persona {
    private String trabajo;

    public Trabajador(String trabajo, String nombre, int dni, int edad) {
        super(nombre, dni, edad);
        setTrabajo (trabajo);
    }

    public String toString (){
        String aux= super.toString();
        aux += ". Soy " + getTrabajo();
        return aux;
    }
    
    
    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }
    
    
    
}
