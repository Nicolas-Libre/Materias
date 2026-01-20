/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import PaqueteLectura.GeneradorAleatorio;
    /**
     * Carga un vector que representa la tabla del 2
     */
public class JavaApplication1 {
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        int x;
        int DF=11;  
        int [] tabla2 = new int[DF]; // indices de 0 a 10
        int i;
        for (i=0;i<DF;i++)
            tabla2[i]=0;
        
        int z;
        z=11;
        for (i=0;i<DF;i++) {
            x=GeneradorAleatorio.generarInt(12);
            if (x!=11){
                tabla2[i]=x;

            }
            else{
                z=i;
                i=10;
            }
        }  
       int t;

       for (t=0; t<z; t++) {
            System.out.println("2x" + tabla2[t] + "="+ tabla2[t]*2);    
    }
 }
}
    