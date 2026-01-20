/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication26;
import PaqueteLectura.Lector;
import java.util.Arrays;
/**
 *
 * @author Nicolas
 */
public class JavaApplication26 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i;
        Estante e = new Estante ();
        for (i=0; i<20; i++) {

            System.out.println("Ingrese el titulo del libro");
            String tit = Lector.leerString();
            System.out.println("Ingrese la editorial del libro");
            String edit = Lector.leerString();
            System.out.println("Ingrese el año de edicion del libro");
            int anio = Lector.leerInt();
            System.out.println("Ingrese el nombre del autor");
            String nombreA = Lector.leerString();
            System.out.println("Ingrese la biografia del autor");
            String bioA = Lector.leerString();
            System.out.println("Ingrese el origen del autor");
            String oriA = Lector.leerString();
            Autor a = new Autor (nombreA,bioA,oriA);
            System.out.println("Ingrese el ISBN");
            String ISBN = Lector.leerString();
            System.out.println("Ingrese el precio");
            double precio = Lector.leerDouble();
            Libro l = new Libro (tit,edit,anio,a,ISBN,precio);
            e.cacEstante(l,i);
            System.out.println(Arrays.toString(e.getvEstante()));

            System.out.println("Si ingreso todos los libro ingrese -1 ");
                int auxFin =Lector.leerInt();
                if (auxFin == -1) {
                    i = 20;
                }
                
        }
           //for (i=0; i <20; i++){
             //  System.out.println(e.getvEstante()[i]);
           //}
        // System.out.println(e.estaLleno());
         //System.out.println("cantidad de libros = " + e.getCantLibros());
         //System.out.println("Ingrese el titulo a buscar ");
         //String xTitulo = Lector.leerString();
         //System.out.println(e.preguntarLibro(xTitulo));
         
   
        }
    }

