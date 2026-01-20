/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialconsultorio;

/**
 *
 * @author Nicolas
 */
public class Medico extends Persona {
    private String especialidad;
    private int numMatricula;

    
    
    public Medico (int unDni, String unApellido, String unNombre, int unNumTel, 
            String unaEspecialidad, int unNumMatricula){
        super (unDni,unApellido, unNombre, unNumTel);
        setEspecialidad (unaEspecialidad);
        setNumMatricula (unNumMatricula);
    }
    
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(int numMatricula) {
        this.numMatricula = numMatricula;
    }
    
    public String toString () {
        String aux;
        aux = super.toString() + " Especialidad: " + getEspecialidad() + " Matricula: " + getNumMatricula();
        return aux;
    }
    
    
    
    
}
