/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3ej5;
import PaqueteLectura.Lector;
/**
 *
 * @author Nicolas
 */
public class Practica3ej5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Ingrese el Radio");
        double r = Lector.leerDouble();
        System.out.println("Ingrese el Color de Relleno");
        String cyr = Lector.leerString();
        System.out.println("Ingrese el Color de Linea");
        String cdl = Lector.leerString();
        Circulo c = new Circulo (r,cyr,cdl);
        System.out.println(c.toString());
    }
    
}
