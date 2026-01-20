/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3ej4dn;

/**
 *
 * @author Nicolas
 */
public class Hotel {
    private int dimF;
    private Habitacion vHotel [];
    
    public Hotel (int N){
        int i;
        setDimF (N);
        vHotel = new Habitacion [N];
        for (i=0; i<N; i++){
            vHotel [i] = new Habitacion();
        }
    }

    public void ingresarCliente (Cliente cli, int x) {
        if (vHotel[x-1].isOcupada()==false) {
            vHotel[x-1].setCli (cli);
            vHotel[x-1].setOcupada (true);
        }
    }
    
    public void aumentarCosto(double cant){
        int i;
        for (i=0; i< dimF; i++){
            vHotel[i].setCosto (vHotel[i].getCosto() + cant);
        }
    }
    
    
    public String toString (){
        String aux="";
        int i;
        for (i=0; i<dimF; i++){
            aux+= "Habitacion " + (i+1) +": " + vHotel[i].toString() + "\n";
        }
        return aux;
    }
    
    private void setDimF(int dimF) {
        this.dimF = dimF;
    }
    
    
    
}
