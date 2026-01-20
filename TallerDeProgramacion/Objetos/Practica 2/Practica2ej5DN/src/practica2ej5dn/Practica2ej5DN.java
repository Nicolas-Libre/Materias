/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2ej5dn;
import PaqueteLectura.Lector;
/**
 *
 * @author Nicolas
 */
public class Practica2ej5DN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int dimF=20;
        int dimL=0;
        Partido torneo [] = new Partido [dimF];
        System.out.println("Ingrese el equipo Visitante");
        String visitante = Lector.leerString();
        int golLocal;
        int golVisitante;
        String local;
        while (!visitante.equals("ZZZ") && (dimL < dimF) ) {
            System.out.println("Ingrese el equipo Local");
            local = Lector.leerString();
            System.out.println("Ingrese los goles de " + visitante);
            golVisitante=Lector.leerInt();
            System.out.println("Ingrese los goles de " + local);
            golLocal = Lector.leerInt();
            torneo [dimL] = new Partido (local,visitante,golLocal,golVisitante);
            dimL++;
            System.out.println("Ingrese el equipo Visitante");
            visitante = Lector.leerString();
        }
        int i;
        int ganoRiver=0;
        int golesLocalBoca=0;
        for (i=0; i<dimL; i++) {
            System.out.println(torneo[i].toString());
            if (torneo[i].getGanador().equals("River")){
                ganoRiver++;
            }
            if (torneo[i].getLocal().equals("Boca")){
                golesLocalBoca+= torneo[i].getGolesLocal();
            }
        }
        System.out.println("River gano " + ganoRiver + " partidos");
        System.out.println("Boca de local hizo " + golesLocalBoca + " goles");
    }
    
}
