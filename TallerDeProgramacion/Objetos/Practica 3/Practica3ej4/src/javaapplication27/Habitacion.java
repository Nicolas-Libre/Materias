/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication27;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author Nicolas
 */

public class Habitacion {

    private double precio;
    private boolean ocupada;
    private Cliente clien;
    
         
    public Habitacion () {
        GeneradorAleatorio.iniciar();
        precio = GeneradorAleatorio.generarDouble(60001) + 2000;
        ocupada = false;
        clien = new Cliente ();
    }
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isOcupada() {
        boolean auxB =false;
        if (clien.getEdad() != 0)
            auxB=true;
        ocupada =auxB;
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public Cliente getClien() {
        return clien;
    }

    public void setClien(Cliente clien) {
        this.clien = clien;
    }
    


}