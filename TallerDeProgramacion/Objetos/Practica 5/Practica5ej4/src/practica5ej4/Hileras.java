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
public class Hileras extends Coro {
    private Corista [][] vectorHileras;
    private int DFF;
    private int DFC;
    private int DLF=0;
    private int DLC=0;
    
    public Hileras (String unNombre, Director unDirector, int tamaño1, int tamaño2){
        super (unNombre, unDirector);
        vectorHileras = new Corista [tamaño1] [tamaño2];
        DFF = tamaño1;
        DFC = tamaño2;
    }
    
    private void setVectorHileras (Corista c, int ubi1, int ubi2) {
        vectorHileras [ubi1][ubi2] = c;
    }
    public void agregarAlCoro (Corista c) {
        if (estaLleno() == false) {
            setVectorHileras (c,DLF,DLC);
            DLC++;
        }
        if ((DLC == DFC) && (DLF < DFF))  {
            DLC =0;
            DLF++;
        }
        
        
    }
    
    public boolean estaLleno () {
        boolean aux=false;
        if ((DLF == DFF) && (DLC == DFC)) {
            aux=true;
        }
        return aux;
    }
    
    private boolean chequearOrden () {
        boolean aux = true;
        int i;
        int j;
        for (i=0; i< DFF-1; i++){
            for (j=0; j < DFC-1; j++){
                if (vectorHileras [i][j].getTono() != vectorHileras [i][j+1].getTono()){
                    aux=false;
                }
                else if (vectorHileras [i][1].getTono() > vectorHileras [i+1][1].getTono()){
                    aux=false;
                }
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
        int j;
        aux = "Nombre del coro de Hileras: " + getNombre() + super.getElDirector().toString();
        for (i=0; i < DFF; i++){
            for (j=0; j < DFC; j++){
                aux += "\n" + "Corista ubicado en fila " + (i+1) + " y columna "+ (j+1) + vectorHileras[i][j].toString();
            }
        }
        return aux;
    }
    
}
