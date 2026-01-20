/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;

import PaqueteLectura.Lector;

public class Ej01Tabla2 {

    /**
     * Carga un vector que representa la tabla del 2
     * @param args
     */
    public static void main(String[] args) {
        int i;
        int DF=16;
        int total=0;
        double sumaAlt=0;
        double [] tabla = new double [DF];
        for (i=0; i <DF; i++){
            double altura= Lector.leerDouble();
            tabla[i]=altura;
            total++;
            sumaAlt=sumaAlt+altura;
        }
        System.out.println("el promedio es " + sumaAlt/total);
        int z=0;
        for (i=0; i < DF; i++){
            if (tabla [i] > (sumaAlt/total));
                z++;
    }
  }
}
