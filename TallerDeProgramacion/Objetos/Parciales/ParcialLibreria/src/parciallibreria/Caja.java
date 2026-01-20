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
public class Caja {
    private boolean disponible;
    private Ticket [] vectorTicket;
    private int dimL=0;
    private int dimF;

    public Caja (int cantTickets){
        setDisponible (true);
        vectorTicket = new Ticket [cantTickets];
        dimF = cantTickets;
    }
    
    public void agregarTicket ( Ticket T) {
        setVectorTicket (T);
    }

    public Ticket[] getVectorTicket() {
        return vectorTicket;
    }

    public void setVectorTicket(Ticket T) {
        vectorTicket [dimL] = T;
        dimL++;
    }
    
    
    
    public boolean isDisponible() {
        
        if (dimL == dimF){
            disponible=false;
        }
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    public int sumarCantLibros () {
        int aux=0;
        int i;
        for (i=0; i < dimL; i++){
            aux+= vectorTicket[i].getCantLibrosComprados();
        }
        return aux;
    }
    
    public Ticket mayorMontoCaja () {
        int i;
        Ticket T = null;
        double aux=-1;
        for (i=0; i < dimL; i++) {
            if (vectorTicket[i].getMonto() > aux) {
                aux = vectorTicket[i].getMonto();
                T = vectorTicket[i];
            }
        }
        return T;
    }
    
    public String imprimirVectorTicket () {
        String aux="";
        int i;
        for (i=0; i < dimL; i ++) {
            aux += vectorTicket[i].toString() + "\n";
        }
        return aux;
    }
    
    public String toString () {
        String aux = "";
        if (isDisponible ()== true) {
            aux += " Esta disponible ";
        }
        else aux += " No esta disponible ";
        
        aux += imprimirVectorTicket() + "\n";
        return aux;
    }
    
    
}
