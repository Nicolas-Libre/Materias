/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5ej2;
import PaqueteLectura.Lector;
/**
 *
 * @author Nicolas
 */
public class Practica5ej2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Auto a1 = new Auto ("etiola", 22);
        Auto a2 = new Auto ("toyota", 9);
        Auto a3 = new Auto ("nissan", 5);
        Auto a4 = new Auto ("mercedez", 4);
        Auto a5 = new Auto ("BMW", 8);
        Auto a6 = new Auto ("audi", 6);
        Estacionamiento e = new Estacionamiento ("caca", "54 y 20", 00, 24, 3,3);
        
        
        e.setAuto (a1, 0, 0);
        e.setAuto (a2, 0, 1);
        e.setAuto (a3, 1, 0);
        e.setAuto (a4, 2, 0);
        e.setAuto (a5, 0, 2);
        e.setAuto (a6, 2, 1);
        int pat = Lector.leerInt();
        System.out.println(e.toString());
        System.out.println(e.buscarPatente (pat));
                
        System.out.println("La cantidad de autos en la plaza ingresada es: " + e.cantAutosEnPlaza (1));
    }
    
}
