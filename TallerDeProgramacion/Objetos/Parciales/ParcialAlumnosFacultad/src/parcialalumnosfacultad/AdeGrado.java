/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialalumnosfacultad;

/**
 *
 * @author Nicolas
 */
public class AdeGrado extends Alumno {
    private String carrera;

    
    public AdeGrado (int unDNI, String unNombre, int unDimF, String unCarrera){
        super (unDNI, unNombre, unDimF);   
        setCarrera (unCarrera);
    
    }
    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    

    
    public String toString (){
        String aux;
        aux = super.toString()+ "Esta graduado " + getCarrera(); 
        return aux;
    }
    
}
