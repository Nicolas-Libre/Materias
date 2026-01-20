/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication24;
import PaqueteLectura.Lector;
/**
 *
 * @author Nicolas
 */
public class JavaApplication24 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
            System.out.println("Ingrese el lado 1");
            double lado1 = Lector.leerDouble();
            System.out.println("Ingrese el lado 2");
            double lado2 = Lector.leerDouble();
            System.out.println("Ingrese el lado 3");
            double lado3 = Lector.leerDouble();
            System.out.println("Ingrese el color del relleno");
            String colorRelleno = Lector.leerString();
            System.out.println("Ingrese el color de las lineas");
            String colorLinea = Lector.leerString();
            triangulo prueba = new triangulo (lado1,lado2,lado3,colorRelleno,colorLinea);
            //double P;
            //P = prueba.calcularPerimetro();
           // System.out.println(P);
            System.out.println(prueba.toString());
    }
    
}
