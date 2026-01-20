/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial8googledrive;

/**
 *
 * @author Nicolas
 */
public class Distancia extends Curso {
    private String sala;

    public Distancia(String sala, int añoCursada, int N) {
        super(añoCursada, N);
        setSala(sala);
    }

    
    public boolean puedeRendir (Alumno a){
        boolean aux=false;
        if ((a.getAsistencias() >= 1) && (a.getAutoEvaAprobada() >=3)){
            aux=true;
        }
        return aux;
    }
    
    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }
    
    
    
    
}
