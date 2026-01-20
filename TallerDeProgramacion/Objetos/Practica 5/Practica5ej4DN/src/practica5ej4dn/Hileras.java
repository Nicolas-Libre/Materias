/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5ej4dn;

/**
 *
 * @author Nicolas
 */
public class Hileras extends Coro {
    private Corista [][] matrizCoristas;
    private int [] vecDimL;
    private int dimFColumnas;
    private int dimFFilas;
    private int aux=0;

    public Hileras(int cantFilas, int cantColumnas, Director direc, String nombre) {
        super(direc,nombre);
        matrizCoristas = new Corista [cantFilas] [cantColumnas];
        vecDimL= new int [cantFilas];
        dimFColumnas = cantColumnas;
        dimFFilas = cantFilas;
        int i;
        for (i=0; i<dimFFilas; i++){
            vecDimL[i] = 0;
        }
    }
    
    public void agregarCorista(Corista cor){
        boolean agrego=false;
            if (!this.estaLLeno()) {
                matrizCoristas [aux][vecDimL[aux]] = cor;
                vecDimL[aux]++;
            }
        if (vecDimL[aux]==dimFColumnas ){
            aux++;
        }
        
    }
    
    public boolean estaLLeno() {
        if (vecDimL[dimFFilas-1] == dimFColumnas) {
            return true;
        }
        else return false;
            
    }
    public boolean bienFormado() {
        boolean bien=true;
        int i=0;
        int j=0;
        while (bien==true) {
            if ((matrizCoristas[i][j].getTono() != matrizCoristas [i][j+1].getTono()) || (matrizCoristas [i][j].getTono() < matrizCoristas[i+1][j].getTono())){
                bien=false;
            }
            else
                if (j < dimFColumnas-1) {
                    j=0;
                    i++;
                }
        }
        return bien;
    }
    
    
    public String imprimirMatriz() {
        String auxi="";
        int i;
        int j;
        for (i=0; i <aux; i++ ) {
            auxi+= "Fila " +(i+1) + " | ";
            for (j=0; j<vecDimL[i]; j++){
                auxi +=("Columna " + (j+1) + " | "  );
                auxi+= "\n" + matrizCoristas[i][j].toString() + "\n";
            }
        }
        return auxi;
    }
    
    public String toString() {
        String auxi;
        auxi = super.toString()  + this.imprimirMatriz();
        return auxi;
    }
    
    
    
}
