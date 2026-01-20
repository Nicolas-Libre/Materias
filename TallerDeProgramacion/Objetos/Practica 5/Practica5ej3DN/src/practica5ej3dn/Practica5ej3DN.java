/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5ej3dn;

/**
 *
 * @author Nicolas
 */
public class Practica5ej3DN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EventoOcasional EO = new EventoOcasional (2,"Nico", "2/5", "los piojos", 4);
        EO.agregarTema("chac tu chac");
        EO.agregarTema("Civilizacion");
        EO.agregarTema("Dificl");
        
        Gira gir = new Gira ("YSYsmo", "YSY A", 30, 15);
        gir.agregarTema("Pastel con Nutella");
        gir.agregarTema("A toda Hora");
        gir.agregarTema("Vamo a Darle");
        
        Fecha f1=new Fecha ("Buenos Aires", "22");
        Fecha f2= new Fecha ( "España", "31");
        Fecha f3= new Fecha ("Mexico", "11");
        gir.agregarFecha(f1);
        gir.agregarFecha(f2);
        gir.agregarFecha(f3);
        
        System.out.println("precio del evento ocasional: " + EO.calcularCosto());
        System.out.println("precio de la gira " +gir.calcularCosto());
        System.out.println("");
        System.out.println("");
        System.out.println(EO.actuar());
        System.out.println("------------------");
        System.out.println(gir.actuar());
        System.out.println("----------------------------------");
        System.out.println(gir.actuar());
        System.out.println("----------------------------------");
        System.out.println(gir.actuar());
    }
    
}
