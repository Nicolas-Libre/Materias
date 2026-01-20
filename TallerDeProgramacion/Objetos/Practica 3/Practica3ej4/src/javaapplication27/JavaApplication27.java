/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication27;
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
/**
 *
 * @author Nicolas
 */
public class JavaApplication27 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int dimF = 20;
        GeneradorAleatorio.iniciar();
        Hotel h = new Hotel();
        int i=0;
         while (i!= dimF ) {
            System.out.println("Ingrese el numero de Habitacion (Maxmo 20)");
            int x = Lector.leerInt();
            if (h.getvHabitacion()[x-1].isOcupada() == false) {
                System.out.println("Ingrese su Nombre");
                String n = Lector.leerString();
                System.out.println("Ingrese su DNI");
                int DNI = Lector.leerInt();
                System.out.println("Ingrese su Edad");
                int edad = Lector.leerInt();
                Cliente c = new Cliente (n,DNI,edad);
                h.setvHabitacionCliente(c, (x-1));
                i++;
            }
            else  { 
                System.out.println("La Habitacion ya esta ocupada");
            }
        }
        for (i=0; i < dimF; i++){
            System.out.println(h.toString(i));
            
        }
        h.aumentarValor(5);
        for (i=0; i < dimF; i++)
            System.out.println(h.toString(i));
    }
    
}
