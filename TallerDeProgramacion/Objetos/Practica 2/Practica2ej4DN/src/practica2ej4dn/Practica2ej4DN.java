/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2ej4dn;
import PaqueteLectura.Lector;
/**
 *
 * @author Nicolas
 */
public class Practica2ej4DN {

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
        
        int DFF=5;
        int DFC=8;
        int dia;
        int i=0;
        boolean fin=false;
        Persona p1= new Persona (nombre,edad,dni);
        Persona casting [][] = new Persona [DFF][DFC];
        int cantEntrevistados =0;
        int vecDimL [] = new int [DFF];
        for (i=0; i < DFF; i ++) {
            vecDimL[i]=0;
        }
        while ((!nombre.equals("ZZZ")) && (cantEntrevistados < 40)) {
            System.out.println("Ingrese el dia");
            dia = Lector.leerInt();
            if (vecDimL [dia-1] < DFC) {
                casting [dia-1][vecDimL[dia-1]] = p1;
                vecDimL[dia-1]++;   
                cantEntrevistados++;
            }
            else {
                System.out.println("Dia Lleno");
            }
            
            System.out.println("Ingrese su nombre");
            nombre=Lector.leerString();
            System.out.println("Ingrese su dni");
            dni=Lector.leerInt();
            System.out.println("Ingrese su edad");
            edad=Lector.leerInt();
            p1= new Persona (nombre,edad,dni);
            
        }
        System.out.println("entrevistados : " + cantEntrevistados );
        int j;
        for (i=0;i<DFF; i++){
            System.out.println("");
            for (j=0; j<vecDimL[i]; j++){
                    System.out.print(casting[i][j].toString() + " | ");
                
            }
            System.out.println("Para el dia " + (i+1) + "hubo " + vecDimL[i] + " inscriptos")  ;
        }
        
    }
    
}
