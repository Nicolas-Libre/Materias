/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialconciertos;

/**
 *
 * @author Nicolas
 */
public class ParcialConciertos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Estadio e = new Estadio ("gran rrex", "la Plata", 20000);
        Concierto c1 = new Concierto ("ysy a", 15000, 30);
        Concierto c2 = new Concierto ("los piojos", 150000, 15);
        Concierto c3 = new Concierto ("redondos", 10000, 20);
        Concierto c4 = new Concierto ("las pelotas", 5500, 80);
        Concierto c5 = new Concierto ("divididos", 5000, 10);
        Concierto c6 = new Concierto ("los del fuego", 12000, 48);
        
        e.agregarConcierto (1, c1);
        e.agregarConcierto (1, c2);
        e.agregarConcierto (2, c3);
        e.agregarConcierto (1, c4);
        e.agregarConcierto (1, c5);
        e.agregarConcierto (2, c6);
        e.agregarConcierto (2, c6);
        
        System.out.println(e.getDLC());
        System.out.println(e.mostrarMesM (1));
        System.out.println("La ganancia del mes es: " + e.calcularGananciaMesM (1));
        
        
        
        System.out.println(e.toString());
    }
    
}
