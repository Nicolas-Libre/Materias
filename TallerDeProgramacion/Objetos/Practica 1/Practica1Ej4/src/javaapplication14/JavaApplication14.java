/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication14;

import PaqueteLectura.Lector;

/**
 *
 * @author Nicolas
 */
public class JavaApplication14 {
    public static void main(String[] args) {
        int DFF=9;
        int DFC=5;
        int edificio[][] = new int [DFF][DFC];
        int i, j;
        for (i=0; i < DFF; i++){
            for (j=0; j < DFC; j++){
                edificio [i][j]=0;
            }
        }
        int z,t;
        System.out.println("ingrese el piso al que accede");
        z = Lector.leerInt();
        while (z != 9) {
                System.out.println ("ingrese la oficina a la que accede");
                t = Lector.leerInt();
                edificio[z - 1][t - 1] = (edificio [z - 1][t - 1]) + 1;
                System.out.println("ingrese el piso al que accede");
                z = Lector.leerInt();

        }
        
        for (i=0; i < DFF; i++){
            System.out.println ("----------");
        
            for (j=0; j<DFC; j++){
                System.out.print(edificio [i][j] + " | ");
            }
  }   
}
}