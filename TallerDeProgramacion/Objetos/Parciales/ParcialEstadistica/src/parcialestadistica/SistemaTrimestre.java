/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialestadistica;

/**
 *
 * @author Nicolas
 */
public class SistemaTrimestre   {
    private int [] cantEgresados = new int [4];

    
    public SistemaTrimestre (Carrera c, int NAños) {
        
        inicializarVector();
    }
    public void inicializarVector() {
        int i;
        for (i=0; i < 4; i++){
            cantEgresados[i]= -1;
        }
    }  
    
    public void devolverSetEgresados (int trimestreY, int cant) {
        
        cantEgresados [trimestreY-1] = cant;
        
    }
    
    public int getCantEgresados (int trimestreY) {
        int aux;
        aux= cantEgresados[trimestreY-1];
        return aux;
    }
    
    public int devolverCantAlumnos (int alumnosX) {
        int aux=0;
        int i;
        for (i=0; i < 4; i++) {
            if (cantEgresados [i] == alumnosX){
                aux++;
            }
        }
        return aux;
    }
    
    public int devolverTotalEgresados () {
        int i;
        int aux=0;
        for (i=0; i < 4; i++) {
            aux += getCantEgresados(i+1);
        }
        return aux;
            
    }
    
    public String imprimirVectorTrim () {
        int i;
        String aux="";
        for (i=0; i< 4; i++){
            aux += "Trimestre " + (i+1) 
                    + ": cantidad de egresados: " + getCantEgresados(i) +"\n";
        }
        return aux;
    }
    
    public String toString () {
        String aux;
        aux= imprimirVectorTrim();
        return aux;
    }
}
