/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialestadistica;

/**
 *
 * @author Nicolas
 */
public class ParcialEstadistica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Carrera car1 = new Carrera ("licenciatura", "informatica", 2015);
        Carrera car2 = new Carrera ("ingenieria", "informatica", 2010);
        
        SistemaAño SA = new SistemaAño (car1, 2);
        
        
        SA.setCantidadEgresados (1, 1, 6);
        
        
        SA.setCantidadEgresados (1, 2, 2);
        SA.setCantidadEgresados (1, 3, 8);
        SA.setCantidadEgresados (1, 4, 1);
        
        SA.setCantidadEgresados (2, 1, 2);
        SA.setCantidadEgresados (2, 2, 3);
        SA.setCantidadEgresados (2, 3, 5);
        SA.setCantidadEgresados (2, 4, 8);
        
        System.out.println(SA.toString());
        
}
    
}
