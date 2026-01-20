/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5ej3;

/**
 *
 * @author Nicolas
 */
public class Practica5ej3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        EventoOcasional e = new EventoOcasional ("los piojos", 3, 2, "Nico", "22");
        Gira g = new Gira ("caca", 2, "vende humo", 3);
        Fecha f1 = new Fecha ("La plata", 22);
        Fecha f2 = new Fecha ("buenos aires", 3);
        Fecha f3 = new Fecha ("rosario", 2);
        e.agregarTema ("babilonia");
        e.agregarTema ("como ali");
        e.agregarTema ("extraña soledad ");
        
        
        g.agregarTema("diarrea");
        g.agregarTema ("colitis");
        
        
        g.agregarFecha (f1);
        g.agregarFecha (f2);
        g.agregarFecha (f3);
        
        System.out.println(e.actuar());
        System.out.println(g.actuar());
        
        System.out.println("El costo del evento es " + e.calcularCosto());
        System.out.println("El costo de la gira es " + g.calcularCosto());
        
        
    }
    
}
