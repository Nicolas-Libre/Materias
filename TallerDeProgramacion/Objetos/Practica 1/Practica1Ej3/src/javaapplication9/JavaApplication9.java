/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication9;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
/**
 *
 * @author Nicolas
 */
public class JavaApplication9 {

    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
	    //Paso 2. iniciar el generador aleatorio     
	 int [][] matriz = new int [5][5];
        //Paso 3. definir la matriz de enteros de 5x5 e iniciarla con nros. aleatorios 
        int i,j;
        for (i=0; i <5; i++) {
            for (j=0; j<5;j++)
                matriz [i][j]= GeneradorAleatorio.generarInt(5);
        }
           for (i=0; i <5; i++) {
               System.out.println("---------------");
               for (j=0; j<5;j++)
                   System.out.print(matriz[i][j] + " | ");
        
           }
        //Paso 4. mostrar el contenido de la matriz en consola
           int sumaFila1=0;
           for (j=0; j < 5; j++){
               sumaFila1=sumaFila1 + matriz [0][j];
           }
           System.out.println("la suma de la fila 1 es " + sumaFila1);
        //Paso 5. calcular e informar la suma de los elementos de la fila 1
    
        //Paso 6. generar un vector de 5 posiciones donde cada posición j contiene la suma de los elementos de la columna j de la matriz. 
        //        Luego, imprima el vector.
        int DF=5;
        int z=0;
        
        int [] tabla = new int [DF];
        for (i=0; i<5;i++) {
            tabla[i]=0;
        }
        for (j=0; j < 5; j++){
            for (i=0; i < 5; i++){
                z= z + matriz [i][j];
                tabla [j]=z;
               
            }
            z=0;
                        
        }
        //Paso 7. lea un valor entero e indique si se encuentra o no en la matriz. En caso de encontrarse indique su ubicación (fila y columna)
        //   y en caso contrario imprima "No se encontró el elemento".
        int x = Lector.leerInt();
        int p=0;
        for (i=0; i < 5; i++){
            for (j=0; j<5; j++){
                if (matriz [i][j] == x) {
                        System.out.println("El valor se encuentra en la fila " + (i+1) + " y en la columna " + (j+1));
                        p=1;
                }
            }
                 
        }
        if (p == 0)
           System.out.println("No se encontro el elemento");
    
}}
