/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4ej3;

/**
 *
 * @author Nicolas
 */
public class Practica4ej3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Persona nico = new Persona ("Nicolas", 46017636, 20);
        System.out.println(nico.toString());
        Trabajador brisa = new Trabajador ("Brisa", 44650616, 21, "bioquimica");
        System.out.println("");
        System.out.println("");
        System.out.println(brisa.toString());
    }
    
}
