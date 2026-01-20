/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication18;
import PaqueteLectura.Lector;
/**
 *
 * @author Nicolas
 */
public class JavaApplication18 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persona Pers1;
        Pers1 = new Persona();
        String n = Lector.leerString();
        Pers1.setNombre(n);
        int x = Lector.leerInt();
        Pers1.setDNI(x);
        int e = Lector.leerInt();
        Pers1.setEdad(e);
        System.out.println(Pers1.toString());
    }
    
}
