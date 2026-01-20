/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3ej3dn;

/**
 *
 * @author Nicolas
 */
public class Estante {
    private int dimF;
    private int dimL=0;
    private Libro [] vector;
    
    
    public Estante (int unDimF) {
        int i;
        dimF=unDimF;
        vector = new Libro [dimF];
        for (i=0; i < dimF; i++) {
            vector[i] = null;
        }
    }
    
    public Libro devuelvoLibro(String titulo){
        int i=0;
        Libro aux = null;
        while ((i < dimL) && (aux == null)) {
            if (vector[i].getTitulo().equals(titulo)) {
                aux = vector[i];
            }
            i++;
        }
        return aux;
    }
    
    public void AgregarLibro (Libro unLibro){
        if (vector[dimL] == null) {
            vector[dimL] = unLibro;
            dimL++;
        }
    } 
    
    public int cantAlmacenados () {
        return dimL;
    }
    
    public boolean estaLleno () {
        if (dimL == (dimF-1)) {
            return true;
        }
        else
            return false;
    }
    
}
