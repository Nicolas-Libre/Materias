/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parciallibreria;

/**
 *
 * @author Nicolas
 */
public class Ticket {
    private int numero;
    private int dniCliente;
    private int cantLibrosComprados;
    private double monto;
    private String medioPago;
    
    public Ticket (int unNumero, int unDniCliente, int unCantLibrosComprados, double unMonto, String unMedioPago){
        setNumero(unNumero);
        setDniCliente (unDniCliente);
        setCantLibrosComprados (unCantLibrosComprados);
        setMonto (unMonto);
        setMedioPago (unMedioPago);
    }
    
   

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }
    
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(int dniCliente) {
        this.dniCliente = dniCliente;
    }

    public int getCantLibrosComprados() {
        return cantLibrosComprados;
    }

    public void setCantLibrosComprados(int cantLibrosComprados) {
        this.cantLibrosComprados = cantLibrosComprados;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    public String toString () {
        String aux;
        aux = "Numero: " + getNumero() + " DNI cliente: " + getDniCliente() 
                + " Cantidad de Libros Comprados: " + getCantLibrosComprados() 
                + " Monto: " + getMonto() + " Medio de pago" + getMedioPago();
        return aux;
    }
    
    
}
