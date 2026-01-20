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
public class ParcialLibreria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Libreria L = new Libreria ("caca");
        Caja C1 = new Caja ( 5);
        Caja C2 = new Caja ( 5);
        Caja C3 = new Caja ( 5);
        Caja C4 = new Caja ( 5);
        L.agregarCaja (C1);
        L.agregarCaja (C2);
        L.agregarCaja (C3);
        L.agregarCaja (C4);
        
        
        L.emitirTicket(1, 2, 4, 1000, "pago");
        L.emitirTicket (1, 1, 1, 1, "debito");
        L.emitirTicket (3, 1, 1, 1, "debito");
        L.emitirTicket (1, 1, 1, 1, "debito");
        L.emitirTicket (2, 1, 1, 1, "debito");
        
        
        System.out.println(L.getNombre());
        
        System.out.println(L.getNumeroVenta());
        System.out.println();
        
        System.out.println(L.toString());
    }
    
}
