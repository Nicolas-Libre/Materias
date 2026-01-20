/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2ej3dn;
import PaqueteLectura.Lector;
/**
 *
 * @author Nicolas
 */
public class Practica2ej3DN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Ingrese su nombre");
        String nombre=Lector.leerString();
        System.out.println("Ingrese su dni");
        int dni=Lector.leerInt();
        System.out.println("Ingrese su edad");
        int edad=Lector.leerInt();
        int DLF=0;
        int DLC=0;
        int DFF=5;
        int DFC=8;
        Persona p1= new Persona (nombre,edad,dni);
        Persona casting [][] = new Persona [DFF][DFC];
        while ((!nombre.equals("ZZZ")) && (DLF < DFF) && (DLC < DFC)) {
            casting [DLF][DLC] = p1;
            p1= new Persona (nombre,edad,dni);
            DLC++;
            if (DLC == DFC) {
                DLF++;
                if (DLF != DFF) {
                    DLC=0;
                }
                
            } 
            if ((DLF != DFF) && (DLC !=DFC)) {
                System.out.println("Ingrese su nombre");
                nombre=Lector.leerString();
                System.out.println("Ingrese su dni");
                dni=Lector.leerInt();
                System.out.println("Ingrese su edad");
                edad=Lector.leerInt();
            }
        }
        System.out.println("columnas " + DLC);
        System.out.println("filas " + DLF);
        int i;
        int j;
        for (i=0;i<DLF; i++){
            System.out.println("");
            for (j=0; j<DLC; j++){
                    System.out.print(casting[i][j].toString() + " | ");
                
            }
        }
        
    }
    
}
