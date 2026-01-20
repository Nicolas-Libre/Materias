/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3ej1dn;
import PaqueteLectura.Lector;
/**
 *
 * @author Nicolas
 */
public class Practica3ej1DN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Ingrese el valor del lado 1");
        double Lado1= Lector.leerDouble();
        System.out.println("Ingrese el valor del lado 2");
        double Lado2 = Lector.leerDouble();
        System.out.println("Ingrese el valor del lado 3");
        double Lado3 = Lector.leerDouble();
        System.out.println("Ingrese el color de relleno");
        String Relleno = Lector.leerString();
        System.out.println("Ingrese el color de linea");
        String Linea = Lector.leerString();
        Triangulo tri = new Triangulo (Lado1,Lado2,Lado3,Relleno,Linea);
        System.out.println("El perimetro es " + tri.CalcularPerimetro());
        System.out.println("El area es " + tri.CalcularArea());
        
        
    }
    
}
