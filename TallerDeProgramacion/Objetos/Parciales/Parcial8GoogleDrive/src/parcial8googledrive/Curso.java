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
public abstract class Curso {
    private int añoCursada;
    private Alumno [] vecAlumno;
    private int dimL=0;
    private int dimF;
    public Curso(int añoCursada, int N) {
        setAñoCursada(añoCursada);
        vecAlumno = new Alumno [N];
        dimF=N;
    }

    public boolean agregarAlumno (Alumno a) {
        boolean aux=false;
        if (dimL < dimF) {
            vecAlumno [dimL] =a;
            dimL++;
            aux=true;
        }
        return aux;
    }
    
    public int buscarDni(int unDni) {
        int i=0;
        int pos = -1;
        boolean ok=false;
        while ((i<dimL) && (ok==false)) {
            if (vecAlumno[i].getDni() == unDni) {
                ok=true;
                pos=i;
            }
            else
                i++;
        }
        return pos;
          
    }
    
    public void incrementarAsistencia (int unDni){
        int pos = this.buscarDni(unDni);
        if (pos != -1) {
            vecAlumno[pos].setAsistencias(vecAlumno[pos].getAsistencias() + 1);
        }
    }
    
    public void aprobarAutoEvaluacion (int unDni) {
        int pos = this.buscarDni(unDni);
        if (pos != -1) {
            vecAlumno[pos].setAutoEvaAprobada(vecAlumno[pos].getAutoEvaAprobada() + 1);
        }
    }
    
    
    public abstract boolean puedeRendir (Alumno a);
    
    public void setAñoCursada(int añoCursada) {
        this.añoCursada = añoCursada;
    }
    
    
    
    
    
}
