/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4ej2dn;

/**
 *
 * @author Nicolas
 */
public class Practica4ej2DN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Jugador NicoFree = new Jugador (14,36,"NicoFree", 1000, 2);
        Entrenador tobiGay = new Entrenador (0, "tobiGay", 100,5);
        System.out.println(NicoFree.toString());
        System.out.println("");
        System.out.println("");
        System.out.println(tobiGay.toString());
    }
    
}
