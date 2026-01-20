
package tema1;

//Paso 1: Importar la funcionalidad para lectura de datos

import PaqueteLectura.Lector;



public class Ej02Jugadores {

  
    public static void main(String[] args) {
        int i;
        int DF=16;
        int total=0;
        double sumaAlt=0;
        double [] tabla = new double [DF];
        for (i=0; i <DF; i++){
            double altura= Lector.leerDouble();
            tabla[i]=altura;
            total++;
            sumaAlt=sumaAlt+altura;
        }
        System.out.println("el promedio es " + sumaAlt/total);
        int z=0;
        for (i=0; i < DF; i++){
            if (tabla [i] > (sumaAlt/total));
                z++;
    }
    } 
}
