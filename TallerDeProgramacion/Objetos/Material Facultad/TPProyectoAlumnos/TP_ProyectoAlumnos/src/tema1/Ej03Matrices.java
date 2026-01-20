/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;
import PaqueteLectura.Lector;
//Paso 1. importar la funcionalidad para generar datos aleatorios

public class Ej03Matrices {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int DFF=8;
        int DFC=4;
        int edificio[][] = new int [DFF][DFC];
        int i, j;
        for (i=0; i < (DFF+1); i++){
            for (j=0; (j<DFC+1); j++){
                edificio [i][j]=0;
            }
        }
        int z,t;
        System.out.println("ingrese el piso al que accede");
        z = Lector.leerInt();
        while (z != 9) {
                System.out.println ("ingrese la oficina a la que accede");
                t = Lector.leerInt();
                edificio[z][t] = edificio [z][t] + 1;
                System.out.println("ingrese el piso al que accede");
                z = Lector.leerInt();
    }
        
        for (i=0; i < (DFF+1); i++){
            System.out.println ("----------");
        
            for (j=0; (j<DFC+1); j++){
                System.out.print(edificio [i][j] + " | ");
            }
        }   
    }
    
}
