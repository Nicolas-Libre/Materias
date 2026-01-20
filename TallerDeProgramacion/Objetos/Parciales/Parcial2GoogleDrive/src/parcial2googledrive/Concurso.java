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
public class Concurso {
    private Pareja [] vecParejas;
    private int dimL=0;
    private int dimF;
    
    public Concurso (int N){
        vecParejas  = new Pareja [N];
        dimF=N;
    }
    
    public void agregarPareja (Pareja par){
        if (dimL<dimF) {
            vecParejas[dimL] = par;
            dimL++;
        }
    }
    
    public Pareja masDifEdad(){
        int i=0;
        int max =0;
        Pareja maxPar = null;
        while (i<dimL) {
            if (vecParejas[i].obtenerDiferencia() > max){
                maxPar=vecParejas[i];
                max=vecParejas[i].obtenerDiferencia();
            }
            i++;
        }
        return maxPar;
    }
    
    
}
