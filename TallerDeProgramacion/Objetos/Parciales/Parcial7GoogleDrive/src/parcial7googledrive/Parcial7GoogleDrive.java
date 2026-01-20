/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial7googledrive;

/**
 *
 * @author Nicolas
 */
public class Parcial7GoogleDrive {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Estadio esta = new Estadio ("el mejor", "laPlata", 25);
        Concierto con1 = new Concierto ("nico", 120,22);
        Concierto con2 = new Concierto ("bri", 36,5);
        Concierto con3 = new Concierto ("juan", 2000,2);
        Concierto con4 = new Concierto ("pedro", 4,120);
        Concierto con5 = new Concierto ("anita", 85,85);
        
        
        esta.agregarConcierto(con1, 2);
        esta.agregarConcierto(con2, 1);
        esta.agregarConcierto(con3, 2);
        esta.agregarConcierto(con4, 8);
        esta.agregarConcierto(con5, 4);
        
        System.out.println(esta.listarMes(2));
        System.out.println("----------------------------");
        int mes = 8;
        System.out.println("ganancia del mes " +  mes + "= " + esta.calcularGanancia(mes));
        System.out.println("-------------------------");
        System.out.println(esta.toString());
    }
    
}
