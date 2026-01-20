/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4ej2;

/**
 *
 * @author Nicolas
 */
public class Practica4ej2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Jugador nico = new Jugador ("Nicolas", 1000, 5, 300, 100);
        System.out.println(nico.toString());
        
        Entrenador pedro = new Entrenador ("Pedro", 1300, 20, 6);
        System.out.println(pedro.toString());
        
    }   
    
}
