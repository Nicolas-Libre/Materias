/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5ej4;

/**
 *
 * @author Nicolas
 */
public class Semicircular extends Coro {
    private Corista [] vectorSemiCirculo;
    private int dimF;
    private int dimLog=0;
    
    public Semicircular (String unNombre, Director unDirector, int tamaño){
        super (unNombre, unDirector);
        vectorSemiCirculo = new Corista [tamaño];
        dimF =tamaño;
    }
    
    private void setVectorSemiCirculo (Corista c, int ubi) {
        vectorSemiCirculo [ubi] = c;
    }
    
    public void agregarAlCoro (Corista c) {
        if (estaLleno() ==false) {
            setVectorSemiCirculo (c,dimLog);
            dimLog++;
        }
    }
    
    public boolean estaLleno () {
        boolean aux=false;
        if (dimLog == dimF) {
            aux=true;
        }
        return aux;
    }
    
    private boolean chequearOrden () {
        boolean aux = true;
        int i;
        for (i=0; i < dimF-1; i++) {
            if (vectorSemiCirculo [i].getTono() < vectorSemiCirculo [i+1].getTono()) {
                i=dimF;
                aux=false;
            }
        } 
        return aux;
    }
    
    
    public boolean estaOrdenado (){
        boolean aux;
        if (chequearOrden () == true) {
            aux=true;
        }
        else {
            aux=false;
        }
        return aux;
    }
 
    public String toString () {
        String aux;
        int i;
        aux = "Nombre del coro Semicircular: " + getNombre() + super.getElDirector().toString();
        for (i=0; i < dimF; i++){
            aux += "\n" + "Corista " + (i+1) + vectorSemiCirculo[i].toString();
        }
        return aux;
    }
    
}
