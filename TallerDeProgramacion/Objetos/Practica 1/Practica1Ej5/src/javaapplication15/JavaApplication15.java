/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication15;
import PaqueteLectura.Lector;/**
 *
 * @author Nicolas
 */
public class JavaApplication15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i,j;
        
        int [][] puntajeRestaurante = new int [5][4];
        for (i=0; i<5;i++) {
        
            System.out.println("ingrese el puntaje de la Atencion al Cliente");
            int a = Lector.leerInt();
            puntajeRestaurante [i][0]=a;
            System.out.println("ingrese el puntaje de la Calidad de la Comida");
            int c = Lector.leerInt();
            puntajeRestaurante [i][1]=c;
            System.out.println("ingrese el puntaje del Precio");
            int p = Lector.leerInt();
            puntajeRestaurante [i][2]=p;
            System.out.println("ingrese el puntaje del Ambiente");
            int am = Lector.leerInt();
            puntajeRestaurante [i][3]=am;
            System.out.println("Gracias :D");
        }
        for (i=0; i<5; i++){
            System.out.println("---------");
            for (j=0; j<4; j++) {
                System.out.print(puntajeRestaurante [i][j] + " | ");

            }
        }
        System.out.println();
        System.out.println("Estos son todos los puntajes ");


       
       for (j=0; j < 4; j++) {
            double sumaTotal =0;
            for (i=0; i<5; i++){
                sumaTotal=sumaTotal + puntajeRestaurante [i][j];
            }    
            System.out.println("El promedio del Aspecto " + j + " es " + sumaTotal/5);

       }
    }
}
