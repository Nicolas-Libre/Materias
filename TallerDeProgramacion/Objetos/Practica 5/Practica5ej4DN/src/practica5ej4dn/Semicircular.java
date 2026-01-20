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
public class Semicircular extends Coro {
    private Corista [] vectorCoristas;
    private int dimL=0;
    private int dimF;

    public Semicircular(int cantCoristas, Director direc, String nombre) {
        super(direc,nombre);
        vectorCoristas = new Corista [cantCoristas];
        dimF=cantCoristas;
    }
    
    public void agregarCorista(Corista cor){
        if ((dimL<dimF) && (vectorCoristas[dimL] == null)) {
            vectorCoristas[dimL]=cor;
            dimL++;
        }
    }
    
    public boolean estaLLeno() {
        if (dimL ==dimF) {
            return true;
        }
        else return false;
    }
    
    public boolean bienFormado() {
        int i=0;
        boolean bien=true;
        while ((bien ==true) && (i < dimL-1)) {
            if (vectorCoristas[i].getTono() < vectorCoristas[i+1].getTono()) {
                bien=false;
            }
        }
        return bien;
            
        }
    
    
    public String imprimirVector() {
        String aux="";
        int i;
        for (i=0; i< dimL; i++) {
            aux+= "Corista= " + (i+1) + " " + vectorCoristas[i].toString() + "\n";
        }
        return aux;
    }
    
    public String toString() {
        String aux= super.toString() + this.imprimirVector();
        return aux;
    }
}
    

