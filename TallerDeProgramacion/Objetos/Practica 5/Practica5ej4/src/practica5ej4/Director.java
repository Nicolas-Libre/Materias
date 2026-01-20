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
public class Director extends Persona {
    private int antiguedad;

    
    public Director (String unNombre, int unDNI, int unEdad, int unAntiguedad){
        super (unNombre,unDNI,unEdad);
        setAntiguedad (unAntiguedad);
    }
    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
    
    public String toString (){
        String aux;
        aux = " Nombre del Director: " + super.getNombre() + " DNI: " + super.getDNI() +"\n" +
                "Edad: " + super.getEdad() + " Antiguedad: " + getAntiguedad();
        return aux;
    }
    
}
