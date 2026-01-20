/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1ej4dn;
import PaqueteLectura.Lector;
/**
 *
 * @author Nicolas
 */
public class Practica1ej4DN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int edificio [][] = new int [8][4];
        int i;
        int j;
        for (i=0; i<8; i++) {
            for (j=0; j<4; j++) {
                edificio[i][j] = 0;
            }
        }
        System.out.println("Ingrese el piso");
        int piso = Lector.leerInt();
        System.out.println("Ingrese la Oficina");
        int nOficina=Lector.leerInt();
        
        while (piso!=9) {
            edificio [piso-1] [nOficina-1]+= 1;
            System.out.println("Ingrese el piso");
            piso = Lector.leerInt();
            if (piso!=9) {
                System.out.println("Ingrese la Oficina");
                nOficina=Lector.leerInt();
            }
        }
        for (i=0; i<8; i++) {
            for (j=0; j<4; j++) {
                System.out.print(edificio [i][j] + " | ");
            }
            System.out.println("");
        }
        
    }
    
}
