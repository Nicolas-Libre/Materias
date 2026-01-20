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
public class Presencial extends Curso {
    private int aula;

    public Presencial(int aula, int añoCursada, int N) {
        super(añoCursada, N);
        setAula(aula);
    }

    
    public boolean puedeRendir (Alumno a){
        boolean aux=false;
        if (a.getAsistencias() >= 3) {
            aux=true;
        }
        return aux;
    }
    
    public int getAula() {
        return aula;
    }

    public void setAula(int aula) {
        this.aula = aula;
    }
    
    
    
}
