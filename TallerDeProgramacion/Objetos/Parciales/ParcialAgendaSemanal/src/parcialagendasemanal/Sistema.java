/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialagendasemanal;

/**
 *
 * @author Nicolas
 */
public class Sistema {
    private Paciente [][] matrizAgenda;
    
    
    
    public Sistema () {
        matrizAgenda = new Paciente [6][5];
    }

    public void agregarPaciente (int D, int T, Paciente p){
        matrizAgenda [D][T] = p;
    }

    
    public boolean estaAgendado (int D, String elNombre) {
        boolean aux=false;
        int i=0;
        while ((i < 6) && (aux==false)) {
            if (matrizAgenda[i][D].getNombre().equals (elNombre)) {
                aux=true;
                
            }
            i++;
        }
        return aux;
    }
    
    public void liberarTurnos (String elNombre){
        int i;
        int j;
        for (i=0; i < 6; i++){
            for (j=0; j < 5; j++)
                if (matrizAgenda[i][j]!=null && matrizAgenda[i][j].getNombre().equals(elNombre)) {
                    matrizAgenda [i][j] = new Paciente ("","", -1);
                }
        }
    } 
        
   
    public String toString(){
         String aux="";
         int i;
         
         int j;
         for (i=0; i< 6; i++) {
             
         aux += "----------------------------------" + "\n";
             for (j=0; j < 5; j++){
                 if ((matrizAgenda[i][j] == null) || (matrizAgenda[i][j].getCostoSesion() == -1)){
                     aux+= ("El turno " + (i+1) + " en el dia " + (j+1) + " esta libre.") + "\n";
                 }
                 else 
                     aux += ("El turno " + (i+1) + " en el dia " + (j+1) + " esta ocupado por " + matrizAgenda[i][j].toString() + "\n");
         }
     }
         return aux;
    }
}