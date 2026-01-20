/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial3googledrive;

/**
 *
 * @author Nicolas
 */
public class Agenda {
    private int DFF=5;
    private int DFC=6;
    private Paciente [][] sistema = new Paciente [DFF][DFC];
    
    
    public Agenda () {
        iniciarAgenda();
    }
    
    private void iniciarAgenda () {
        int i;
        int j;
        for (i=0; i<DFF;i++){
            for (j=0; j< DFC; j++){
                sistema[i][j]=null;
            }
        }
    }
    
    
    private String imprimirMatriz(){
        String aux="";
        int i;
        int j;
        for (i=0;i<DFF;i++){
            for (j=0; j<DFC;j++){
                if (sistema[i][j] != null) {
                    aux += "Paciente en el dia " + (i+1) + ", turno " + (j+1) + "\n"
                            + sistema[i][j].toString() + "\n";
                }
            }
        }
        return aux;
               
    }
    public String toString() {
        String aux= "Agenda: " + "\n"
                    + this.imprimirMatriz();
        return aux;
    }
    
    public void agregarPaciente (int D, int T, Paciente p){
        sistema[D-1][T-1]=p;
    }
    
    public void liberarTurno (String nombre){
        int i;
        int j;
        for (i=0; i<DFF; i++){
            for (j=0;j<DFC;j++){
                if (sistema[i][j] != null) {
                   if (sistema[i][j].getNombre().equals(nombre)) {
                       sistema[i][j] =null;
                   }
                }
                            
            }
        }
    }
    
    public boolean tieneAgendado(int D, String nombre){
        int j;
        boolean aux=false;
        for (j=0; j<DFC;j++){
            if (sistema[D][j] != null) {
                if (sistema[D][j].getNombre().equals(nombre)) {
                    aux=true;
                } 
            }
        }
        return aux;
    }
}
