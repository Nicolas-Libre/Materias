/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial1googledrive;

/**
 *
 * @author Nicolas
 */
public class DeGrado extends Alumno{
    private String carrera;

    public DeGrado(String carrera, int dni, String nombre, int N) {
        super(dni, nombre, N);
        setCarrera(carrera);
    }

    
    public String toString() {
        String aux= super.toString();
        aux+= " Carrera: " + getCarrera();
        return aux;
                
    }
    
    
    
    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    
    
    
    
    
    
}
