/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1ej5dn;
import PaqueteLectura.Lector;
/**
 *
 * @author Nicolas
 */
public class Practica1ej5DN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int puntuacion [][] = new int [5][4];

        int i;
        int j;
        for (i=0; i < 5; i++){
           System.out.println("Cliente " + (i+1));
           for (j=0; j<4; j++) {
              if (j== 0) {
                  System.out.println("Ingrese su valoracion de Atencion al Cliente");
                  
              }
              else 
                  if (j==1) {
                    System.out.println("Ingrese su valoracion de la Comida");
                  }
                  else 
                    if (j==3){
                        System.out.println("Ingrese su valoracion del Precio");
                  
                    }
                    else
                        System.out.println("Ingrese su valoracion del Ambiente");
              puntuacion[i][j]=Lector.leerInt();
           }  
        } 
        for (i=0; i<5; i++){
            System.out.println("");
            for (j=0; j<4; j++) {
                System.out.print(puntuacion [i][j] + " | ");
                
            }
            
        }
        double prom=0;
        for (j=0; j<4; j++){
            System.out.println("");
            for (i=0; i<5; i++) {
                prom+=puntuacion [i][j];
            }
            System.out.println("Puntuacion promedio del aspecto " + j + " = " +(prom/5));  
            prom=0;
        }
    }
}
