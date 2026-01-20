/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication23;
import PaqueteLectura.Lector;
/**
 *
 * @author Nicolas
 */
public class JavaApplication23 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int dimF = 20;
        int dimL = 0;
        int i;
        Partido [] vectorPartidos = new Partido [dimF];
        for (i=0; i < dimF; i++) {
            vectorPartidos[i] = new Partido ("x", "z", -1, -1);
        }
        System.out.println("Ingrese el equipo Visitante ");
        String vis = Lector.leerString();
        while (!vis.equals("ZZZ") && dimL < 20) {
            System.out.println("Ingrese el Equipo Local");
            String loc = Lector.leerString();
            System.out.println("Ingrese los goles de " + vis);
            int golVis = Lector.leerInt();
            System.out.println("Ingrese los goles de " + loc);
            int golLoc = Lector.leerInt();
            vectorPartidos[dimL] = new Partido (loc,vis,golLoc,golVis);
            System.out.println("Ingrese el equipo Visitante ");
            vis = Lector.leerString();
            dimL++;
        }
        
        for (i=0; i < dimL; i++) {
            System.out.println(vectorPartidos[i].getLocal()+ " " + vectorPartidos[i].getGolesLocal() + " VS " + vectorPartidos[i].getVisitante() + " " + vectorPartidos[i].getGolesVisitante() + " " );
        }
        int sumaRiver=0;
        int golesBoca=0;
        for (i=0; i < dimL; i++) {
            if ( vectorPartidos[i].getGanador().equals("river")){
                sumaRiver++;
            }
             
                 
             if ( vectorPartidos[i].getLocal().equals("boca")) {               
                 golesBoca = golesBoca + vectorPartidos[i].getGolesLocal();
             }
        }
         System.out.println("River gano " + sumaRiver + " partidos");
         System.out.println("Boca de local hizo " + golesBoca + " goles");
             
                 
                 
         
    }
    
}
