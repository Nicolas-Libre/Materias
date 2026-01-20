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
public class Libreria {
    private String nombre;
    private int numeroVenta;
    private Caja [] vectorCaja ;
    private int dimL=0;
    
    public Libreria (String unNombre){
        setNombre (unNombre);
        setNumeroVenta (0);
        vectorCaja = new Caja [4];
    }
    
    
    public void agregarCaja (Caja c) {
        if (dimL < 4) {
            vectorCaja [dimL] = c;
            dimL++;
        }
    }
    
    public void emitirTicket (int N, int dni, int cantLibros, int monto, String pago) {
        Ticket T = new Ticket (getNumeroVenta(), dni, cantLibros, monto, pago);
        vectorCaja[N-1].agregarTicket (T);
        numeroVenta++;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroVenta() {
        return numeroVenta;
    }

    public void setNumeroVenta(int numeroVenta) {
        this.numeroVenta = numeroVenta;
    }

    public void marcarNoDisponible (int x) {
        int i;
        for (i=0; i < 4; i ++) {
            if (vectorCaja[i].sumarCantLibros() < x) {
                vectorCaja[i].setDisponible (false);
            }
        }
    }
    
    public Ticket mayorMontoLibreria () {
        double aux=0;
        Ticket T= null;
        int i;
        for (i=0; i< 4; i++){
            if (vectorCaja[i].mayorMontoCaja().getMonto() > aux) {
                aux = vectorCaja[i].mayorMontoCaja().getMonto();
                T = vectorCaja[i].mayorMontoCaja();
            }
        }
        return T;
    }

    
    public String imprimirVectorCaja() {
        String aux="";
        int i;
        for (i=0; i < 4; i++) {
            aux+= " Caja " + (i+1) + vectorCaja[i].toString();
        }
        return aux;
    }
    
    
    public String toString () {
        String aux = "Nombre: " + getNombre() + "\n";
        aux += imprimirVectorCaja();
        return aux;
    }
    
}
