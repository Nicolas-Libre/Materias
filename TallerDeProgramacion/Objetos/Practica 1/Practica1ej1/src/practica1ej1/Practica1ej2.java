/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1ej2;
import PaqueteLectura.Lector;
/**
 *
 * @author Nicolas
 */
public class Practica1ej2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int DF=15;
        int [] VJugadores = new int [DF];
        int i;
        double prom=0;
        for (i=0; i <15; i++){
            System.out.println("Ingrese la edad del jugador " + (i+1));
            VJugadores[i] = Lector.leerInt();
            prom += VJugadores[i]; 
        }
        prom= prom/15;
        System.out.println("El promedio es " + prom);
        int cant=0;
        for (i=0; i < DF; i++) {
            if (VJugadores[i] > prom) {
                cant++;
            }
        }
        System.out.println("Cantidad de jugadores con altura > al promedio = " + cant);
    }
    
}
