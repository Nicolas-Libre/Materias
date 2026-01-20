/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5ej3dn;

/**
 *
 * @author Nicolas
 */
public abstract class Recital {
    private String banda;
    private String [] temas;
    private int dimF;
    private int dimL=0;

    public Recital(String banda, int cantTemas) {
        setBanda(banda);
        temas = new String [cantTemas];
        dimF=cantTemas;
    }

    
    public abstract double calcularCosto() ;
        
    
    
    public String getBanda() {
        return banda;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }

    public void agregarTema (String nTema){
        if ((dimL<dimF) && (temas[dimL] == null)) {
            temas[dimL] = nTema;
            dimL++;
        }
    }
    public  String actuar(){
        int i;
        String aux="";
        for(i=0;i<dimL;i++){
            aux+= "y ahora tocaremos " + temas[i] + "\n";
        }
        return aux;
    }
    
    
    
    
    
    
}
