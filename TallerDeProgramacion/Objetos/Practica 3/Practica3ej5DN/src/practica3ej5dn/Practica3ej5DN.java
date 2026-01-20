/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3ej5dn;
import PaqueteLectura.Lector;
/**
 *
 * @author Nicolas
 */
public class Practica3ej5DN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double rad;
        String rell;
        String lin;
        System.out.println("Ingrese el radio");
        rad= Lector.leerDouble();
        System.out.println("Ingrese el color de Relleno");
        rell = Lector.leerString();
        System.out.println("Ingrese el color de Linea");
        lin=Lector.leerString();
        Circulo circ = new Circulo (rad,rell,lin);
        System.out.println("El area del circulo es " + circ.CalcularArea());
        System.out.println("El perimetro del circulo es " + circ.CalcularPetimetro());
    }
    
}
