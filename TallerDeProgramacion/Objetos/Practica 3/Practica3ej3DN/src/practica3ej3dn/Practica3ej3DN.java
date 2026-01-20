/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3ej3dn;

/**
 *
 * @author Nicolas
 */
public class Practica3ej3DN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Estante esta = new Estante(20);
        
        Libro libro1 = new Libro ("Mujercitas", "3", 2222, "Nico", "2", 22);
        Libro libro2 = new Libro ("colegio maldito", "5", 1843, "Bri", "1", 11);
        Libro libro3 = new Libro ("Lo que el agua se llevo", "0", 2569, "Pedro", "8", 22);
        Libro libro4 = new Libro ("Ratatouille", "9", 4125, "Anita", "6", 66);
        
        esta.AgregarLibro(libro1);
        esta.AgregarLibro(libro2);
        esta.AgregarLibro(libro3);
        esta.AgregarLibro(libro4);
        
        Libro buscar= esta.devuelvoLibro("Mujercitas");
        System.out.println("El autor del titulo buscado es " + buscar.getPrimerAutor());
        
    }
    
}
