/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2ej1dn;
import PaqueteLectura.Lector;
/**
 *
 * @author Nicolas
 */
public class Practica2ej1DN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Ingrese su dni");
        int dni=Lector.leerInt();
        System.out.println("Ingrese su edad");
        int edad=Lector.leerInt();
        String nombre = Lector.leerString();
        Persona p1 = new Persona(nombre,edad, dni);
        System.out.println(p1.toString());
    }
    
}
