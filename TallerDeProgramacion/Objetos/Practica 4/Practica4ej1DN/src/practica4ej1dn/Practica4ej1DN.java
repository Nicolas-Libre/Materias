/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4ej1dn;

/**
 *
 * @author Nicolas
 */
public class Practica4ej1DN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Triangulo tri = new Triangulo (2,2,2, "azul", "blanco");
        Circulo cir = new Circulo (2, "azul", "blanco" );
        Rectangulo rec = new Rectangulo (2,2,"azul", "blanco");
        Cuadrado cuad = new Cuadrado (2,"azul", "blanco");
        
        System.out.println(tri.toString());
        System.out.println("");
        System.out.println(cir.toString());
        System.out.println("");
        System.out.println(rec.toString());
        System.out.println("");
        System.out.println(cuad.toString());
        tri.despintar();
        cir.despintar();
        rec.despintar();
        cuad.despintar();
        System.out.println("--------------------------");
        System.out.println(tri.toString());
        System.out.println("");
        System.out.println(cir.toString());
        System.out.println("");
        System.out.println(rec.toString());
        System.out.println("");
        System.out.println(cuad.toString());
        
    }
    
}
