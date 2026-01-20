/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pactica2ej2dn;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author Nicolas
 */
public class Practica2ej2DN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int DF=15;
        String nombre = GeneradorAleatorio.generarString(4);
        System.out.println(nombre.toString());
        int dni = GeneradorAleatorio.generarInt(9999999);
        System.out.println("DNI = "+ dni);
        int edad = GeneradorAleatorio.generarInt(20);
        System.out.println("Edad = " + edad);
        Persona vectorPersona [] = new Persona [DF];
        Persona p1=new Persona (nombre,edad,dni);
        int DL =0;
        while ((DL!=DF-1) && (edad != 0)) {
            vectorPersona[DL] = p1;
            nombre = GeneradorAleatorio.generarString(4);
            System.out.println(nombre.toString());
            dni = GeneradorAleatorio.generarInt(9999999);
            System.out.println("DNI = "+ dni);
            edad = GeneradorAleatorio.generarInt(20);
            System.out.println("Edad = " + edad);
            p1=new Persona (nombre,edad,dni);
            DL++;
        } 
        int i;
        int cant =0;
        int minDni=999999;
        int posMin=-1;
        for (i=0; i<DL; i++) {
            System.out.println("La " + vectorPersona [i].toString() + "esta em la posicion "+ (i+1));
            if (vectorPersona[i].getEdad() > 5) {
                cant ++;
            }
            if (vectorPersona[i].getDni() < minDni) {
                minDni= vectorPersona[i].getDni();
                posMin=i;
            }
        }
        if (posMin != -1) {
            System.out.println("Persona con menor dni = " + vectorPersona [posMin].toString());
        }
        System.out.println("Cantidad de persona mayores a 5 = " + cant);
        
    }
    
}
