/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication25;

/**
 *
 * @author Nicolas
 */
public class JavaApplication25 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Autor a = new Autor ("pepe", "caca", "dubai");
        Libro L1 = new Libro ("a", "b", 3, a,"o", 4 );
        System.out.println(L1.toString()); 
    }
    
}
