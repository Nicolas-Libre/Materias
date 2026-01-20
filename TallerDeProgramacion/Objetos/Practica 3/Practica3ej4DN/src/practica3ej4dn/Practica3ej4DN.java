/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3ej4dn;
import PaqueteLectura.Lector;
/**
 *
 * @author Nicolas
 */
public class Practica3ej4DN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Hotel hote = new Hotel (25);
        
        Cliente cli1 = new Cliente ("Nico", 22, 20);
        Cliente cli2 = new Cliente ("Bri", 22, 21);
        Cliente cli3 = new Cliente ("Anita", 96, 50);
        Cliente cli4 = new Cliente ("Pedro", 32, 51);
        Cliente cli5 = new Cliente ("Wancho", 22, 17);
        Cliente cli6 = new Cliente ("Palme", 12, 12);
        
        hote.ingresarCliente(cli1, 22);
        hote.ingresarCliente(cli2, 1);
        hote.ingresarCliente(cli3, 15);
        hote.ingresarCliente(cli4, 2);
        hote.ingresarCliente(cli5, 16);
        hote.ingresarCliente(cli6, 25);
        
        
        System.out.println(hote.toString());
        hote.aumentarCosto(1000);
        System.out.println("-----------------");
        System.out.println(hote.toString());
        
        
    }
    
}
