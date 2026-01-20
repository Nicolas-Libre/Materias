/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1ej3dn;
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
/**
 *
 * @author Nicolas
 */
public class Practica1ej3DN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int vector[] = new int [5];
        int matriz[][] = new int [5][5];
        int i;
        int j;
        for (i=0; i<5; i++) {
            for (j=0; j < 5; j++){
                matriz[i][j]= GeneradorAleatorio.generarInt(31);
        }
        }
        for (i=0; i<5; i++) {
            for (j=0; j < 5; j++){
                System.out.print(matriz[i][j] + " | ");
            }
          System.out.println("");
        }
        int suma=0;
        for (j=0; j < 5; j++) {
            suma+=matriz [0][j];
        }
        System.out.println("suma de la fila 1 = " + suma);
    
        int z;
        
        int suma2=0;
        for (z=0; z < 5; z++) {
            for (i=0; i < 5; i++){
                suma2+=matriz[i][z];
            }
            vector[z]=suma2;
            suma2=0;
        }
        int x;
        for (x=0; x < 5; x++){
            System.out.println("Suma de los elementos de la matriz columna " + (x+1) + "= " + vector[x]);
        }
        System.out.println("Ingrese el numero a buscar");
        int num=Lector.leerInt();
        boolean ok=false;
        for (i=0; i < 5; i++){
            for (j=0; j<5; j++){
                if (matriz[i][j] == num) {
                    System.out.println("el numero ingresado se encuentra en la fila " + (i+1) + " columna " + (j+1));
                    ok=true;
                }
            }
        }
        if (ok==false) {
            System.out.println("No se encontro el numero ingresado");
        }
    }
}
