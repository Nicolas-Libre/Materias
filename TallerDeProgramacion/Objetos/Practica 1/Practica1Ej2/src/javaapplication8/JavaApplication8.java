/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;
import PaqueteLectura.Lector;
/**
 *
 * @author Nicolas
 */
public class JavaApplication8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i;
        int DF=15;
        int total=0;
        double sumaAlt=0;
        double [] tabla = new double [DF];
        for (i=0; i <DF; i++){
            double altura= Lector.leerDouble();
            tabla[i]=altura;
            total++;
            sumaAlt=sumaAlt+altura;
        }
        double x= sumaAlt/total;
        System.out.println("el promedio es " + x);
        int z=0;
        
        for (i=0;i<DF;i++){
            if (tabla [i] > x) {
                z++;
            }
        }
        System.out.println(z+ " jugadores superan la altura promedio");
    }
}