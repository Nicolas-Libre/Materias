/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication27;

/**
 *
 * @author Nicolas
 */
public class Hotel {
    int dimF=20;
    private int numero;
    private Habitacion [] vHabitacion = new Habitacion [dimF];

    
    public Hotel (){
        numero = -1;
        int i;
        for (i=0; i < dimF; i++) {
            vHabitacion [i] = new Habitacion ();
        }
    }

    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Habitacion[] getvHabitacion() {
        return vHabitacion;
    }

    public void setvHabitacionCliente(Cliente c, int x) {
        this.vHabitacion[x].setClien(c);
    }
   
    public Habitacion [] aumentarValor (double a) {
        int i;
        for (i=0; i < dimF; i++) {
            vHabitacion [i].setPrecio(vHabitacion [i].getPrecio()+ a);
        }
        return vHabitacion;
    }
    
    

  public String toString (int i){

    String aux;
 
        
        if (vHabitacion [i].isOcupada() == true) {
            aux = "Habitacion " + (i+1) + ": Tiene precio " + vHabitacion [i].getPrecio() + " y esta ocupada por " + vHabitacion [i].getClien().toString();
        }
            else {
                    aux = "Habitacion " + i + ": Esta vacia";
                }
          
        return aux;
    }  
}   
    

