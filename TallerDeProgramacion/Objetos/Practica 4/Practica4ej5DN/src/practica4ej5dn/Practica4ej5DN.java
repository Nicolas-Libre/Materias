/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4ej5dn;

/**
 *
 * @author Nicolas
 */
public class Practica4ej5DN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Dibujo d = new Dibujo("un dibujo");
        Cuadrado c1 = new Cuadrado(10,"Violeta","Rosa");
        Rectangulo r= new Rectangulo(20,10,"Azul","Celeste");
        Cuadrado c2= new Cuadrado(30,"Rojo","Naranja");
        d.agregar (c1);
        d.agregar (r);
        d.agregar (c2);
        System.out.println("---------");
        System.out.println("Dibujo: ");
        d.mostrar();
    
    }
    
}
