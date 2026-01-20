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
public class Paciente extends Persona {
    private String obraSocial;

    public Paciente (int unDni, String unApellido, String unNombre, int unNumTel, String unaObraSocial){
        super (unDni,unApellido, unNombre, unNumTel);
        setObraSocial (unaObraSocial);
    }
    
    public String getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(String obraSocial) {
        this.obraSocial = obraSocial;
    }
    
    public String toString () {
        String aux;
        aux = super.toString() + " Obra Social: " + getObraSocial();
        return aux;
    }   
}
