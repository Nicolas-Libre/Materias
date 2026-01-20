/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication20;
import PaqueteLectura.Lector;

/**
 *
 * @author Nicolas
 */
public class JavaApplication20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Persona [][] matrizCasting = new Persona [5][8];
    int i;
    int j;
    

    for (i=0; i < 5; i++) { 
        for (j=0; j < 8; j++)
            matrizCasting [i][j] = new Persona ("x",0,0);         
    }
    String n = Lector.leerString();
    while (!n.equals("ZZZ")&& i < 5 && j < 8) {
        for (i=0; i < 5; i++) {
            for (j=0; j < 8; j++){
                int DNI = Lector.leerInt();
                int e = Lector.leerInt();
                matrizCasting [i][j] = new Persona (n,DNI,e);
                n = Lector.leerString();
                if (n.equals( "ZZZ")) {
                    i = 5;
                    j = 8;
                 
                }
            }
       
        }
    }
    for (i=0; i < 5; i++) { 
        for (j=0; j < 8; j++)
            System.out.println(matrizCasting[i][j].toString() + "Estoy en el dia " + (i+1) + " y en el turno " + (j+1));
    }  
  }
}
