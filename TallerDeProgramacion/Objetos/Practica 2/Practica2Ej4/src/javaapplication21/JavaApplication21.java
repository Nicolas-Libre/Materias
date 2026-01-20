/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication21;
import PaqueteLectura.Lector;

/**
 *
 * @author Nicolas
 */
public class JavaApplication21 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Persona [][] matrizCasting = new Persona [5][8];
    
    int i;
    int j;
    

    for (i = 0; i < 5; i++) { 
        for (j = 0; j < 8; j++)
            matrizCasting [i][j] = new Persona ("x",0,0);         
    }
    System.out.println("Ingrese su Nombre");
    String n = Lector.leerString();

    while (!n.equals("ZZZ")) {
        j = 0;
        System.out.println("Ingrese El dia en el que ingresa (del 1 al 5)");
        int d = Lector.leerInt();
        for (j=0; j < 8; j++){
            
            if (matrizCasting [d - 1][j].getNombre().equals("x")) {
                System.out.println("Ingrese su DNI");
                int DNI = Lector.leerInt();
                System.out.println("Ingrese su Edad");
                int e = Lector.leerInt();
                matrizCasting [d - 1][j] = new Persona (n,DNI,e);
                j=10;
            }
        }
            if (matrizCasting [d - 1][7].getDNI() != 0) {
                System.out.println("El dia " + d + "esta lleno") ;
            }

            System.out.println("Ingrese su Nombre");
            n = Lector.leerString();           
         
    
    }  
    for (i = 0; i < 5; i++) { 
        for (j =0; j < 8; j++)
            System.out.println(matrizCasting[i][j].toString() + "Estoy en el dia " + (i+1) + " y en el turno " + (j+1));
  }
 }
}
    


