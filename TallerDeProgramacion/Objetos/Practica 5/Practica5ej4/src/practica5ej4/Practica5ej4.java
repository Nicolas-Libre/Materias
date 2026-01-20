/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5ej4;
import PaqueteLectura.Lector;
/**
 *
 * @author Nicolas
 */
public class Practica5ej4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Director d1 = new Director ("Nico", 22, 20, 6);
        Director d2 = new Director ("Brisa", 62, 21, 2);
        
        Corista PS1 = new Corista ("SC 1", 24, 3, 6);
        Corista PS2 = new Corista ("SC 2", 20, 5, 3);
        Corista PS3 = new Corista ("SC 3", 15, 4, 2);
        Corista PS4 = new Corista ("SC 4", 12, 8, 1);
        
        
        
        Semicircular SC = new Semicircular ("Coro semicircular", d1, 4);
        SC.agregarAlCoro (PS1);
        SC.agregarAlCoro (PS2);
        SC.agregarAlCoro (PS3);
        SC.agregarAlCoro (PS4);
        
        Corista PH1 = new Corista ("H 1", 11, 2, 1 );
        Corista PH2 = new Corista ("H 2", 10, 1, 1);
        Corista PH3 = new Corista ("H 3", 9, 0, 2);
        Corista PH4 = new Corista ("H 4", 8, 8, 2);
        
        System.out.println(SC.toString());
        if (SC.estaOrdenado()){
            System.out.println("El coro SC esta Ordenado");
        }
        else System.out.println("El coro SC esta desordenado");
        
        
        Hileras H = new Hileras ("Coro por Hileras", d2, 2,2);
        
        H.agregarAlCoro (PH1);
        H.agregarAlCoro (PH2);
        H.agregarAlCoro (PH3);
        H.agregarAlCoro (PH4);
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println(H.toString());
        if (H.estaOrdenado()) {
            System.out.println("El coro H esta ordenado");
        }
        else System.out.println("El coro H esta Desordenado");
    }
    
}
