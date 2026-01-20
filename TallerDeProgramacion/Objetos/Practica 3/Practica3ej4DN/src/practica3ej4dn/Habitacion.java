/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3ej4dn;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author Nicolas
 */
public class Habitacion {
    private double costo= GeneradorAleatorio.generarDouble(6001) + 2000;
    private boolean ocupada=false;
    private Cliente cli=null;

    
    
    public String toString (){
        String aux;
        aux = "Costo: " + getCosto();
        if (isOcupada() == true) {
            aux+= " ocupada por " + getCli().toString();
        }
        else
            aux+= " libre";
        return aux;
    }
    
    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }
    
    
    
    
}
