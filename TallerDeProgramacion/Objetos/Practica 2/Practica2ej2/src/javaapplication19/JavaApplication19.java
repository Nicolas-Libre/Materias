/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication19;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author Nicolas
 */
public class JavaApplication19 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        Persona [] vPersonas = new Persona [16];
        int dimL = 0;
        
        
        int e = GeneradorAleatorio.generarInt(201);
        while ((dimL < 15) && (e != 0)) {
            
            String n = GeneradorAleatorio.generarString(6);
            
            int DNI = GeneradorAleatorio.generarInt (80000);
    
            vPersonas [dimL] = new Persona(n,DNI,e);
            
            dimL++;
            e = GeneradorAleatorio.generarInt(201);
        }
        
        int i;
        for (i=0; i < dimL; i++){
            
            System.out.println(vPersonas [i].toString());
        }
        int z=0;
        int menorDNI =80001;
        Persona chicoDNI = new Persona(); 
        for (i=0; i < dimL; i++){
            if (vPersonas[i].getEdad() > 65){
                z++;
            }
            if (vPersonas[i].getDNI() < menorDNI) {
                menorDNI = vPersonas[i].getDNI();
                chicoDNI = vPersonas[i];
            }
        }
        System.out.println("La cantidad de personas mayor a 65 años es " + z);
        System.out.println(chicoDNI.toString());
    
}
}