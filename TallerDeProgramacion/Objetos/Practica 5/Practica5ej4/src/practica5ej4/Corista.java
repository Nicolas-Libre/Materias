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
public class Corista extends Persona {
    private int tono;

    
    public Corista (String unNombre, int unDNI, int unEdad, int unTono) {
        super (unNombre, unDNI, unEdad);
        setTono (unTono);
    }
    
    public int getTono() {
        return tono;
    }

    public void setTono(int tono) {
        this.tono = tono;
    }
    
        public String toString (){
        String aux;
        aux = " Nombre del Corista: " + super.getNombre() + " DNI: " + super.getDNI() +"\n" +
                "Edad: " + super.getEdad() + " Tono: " + getTono();
        return aux;
    }
    
}
