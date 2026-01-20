/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2googledrive;

/**
 *
 * @author Nicolas
 */
public class Pareja {
    private Persona [] vecPersona= new Persona [2];
    private String estilo;

    
    
    public Pareja (Persona p1, Persona p2, String unEstilo) {
        vecPersona [0]=p1;
        vecPersona [1] =p2;
        setEstilo(unEstilo);
    }
    
    public int obtenerDiferencia() {
        int aux;
        if (vecPersona [0].getEdad() > vecPersona[1].getEdad()) {
                aux = vecPersona[0].getEdad() - vecPersona[1].getEdad();
        }
        else
                aux = vecPersona[1].getEdad() - vecPersona[0].getEdad();
        return aux;
    }
    
    public String toString () {
        String aux = "Participantes de la pareja:" +"\n" 
                     + vecPersona[0].toString() + "\n" 
                     +  vecPersona[1].toString();
        return aux;
    }
    
    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }
    
    
    
    
    
    
    
}
