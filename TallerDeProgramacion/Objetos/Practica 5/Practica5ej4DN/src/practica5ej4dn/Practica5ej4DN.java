/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5ej4dn;

/**
 *
 * @author Nicolas
 */
public class Practica5ej4DN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Director dire = new Director(5, "Nico", 22, 20);
        Semicircular semi = new Semicircular (4,dire, "Los maspi ");
        Director dire2 = new Director (2,"Brisa", 66,21);
        Hileras hile = new Hileras (2,2,dire2, "hermosa ");
        
        
        Corista cor1 = new Corista (2,"caca",54,60);
        Corista cor2 = new Corista (1,"abuelo",26,69);
        Corista cor3 = new Corista (3,"marta",21,21);
        Corista cor4 = new Corista (6,"ian",10,28);
        Corista cor5 = new Corista (5,"vicky",160,19);
        Corista cor6 = new Corista (8,"oso",6,34);
        hile.agregarCorista(cor1);
        hile.agregarCorista(cor2);
        hile.agregarCorista(cor3);
        hile.agregarCorista(cor5);
        
        
        semi.agregarCorista(cor4);
        semi.agregarCorista(cor6);
        System.out.println("Semicircular: " +"\n"
                    + semi.toString());
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Hileras: " + "\n"
                            +hile.toString());
    }
    
}
