/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial8googledrive;

/**
 *
 * @author Nicolas
 */
public class Parcial8GoogleDrive {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Presencial prese = new Presencial (2,22,4);
        
        Distancia dist = new Distancia ("lincoln", 48,6);
        
        Alumno a1 = new Alumno (22,"nico");
        Alumno a2 = new Alumno (2,"wancho");
        Alumno a3 = new Alumno (82,"pedro");
        Alumno a4 = new Alumno (49,"anita");
        Alumno a5 = new Alumno (5,"brisa");
        Alumno a6 = new Alumno (52,"palme");
        
        prese.agregarAlumno(a1);
        prese.agregarAlumno(a2);
        prese.agregarAlumno(a3);
        prese.agregarAlumno(a4);
        
        
        dist.agregarAlumno(a5);
        dist.agregarAlumno(a6);
        
        prese.aprobarAutoEvaluacion(22);
        prese.aprobarAutoEvaluacion(2);
        prese.incrementarAsistencia(22);
        prese.incrementarAsistencia(2);
        prese.incrementarAsistencia(22);
        prese.incrementarAsistencia(22);
        prese.incrementarAsistencia(22);
        
        
        dist.aprobarAutoEvaluacion(5);
        dist.aprobarAutoEvaluacion(52);
        dist.incrementarAsistencia(5);
        dist.incrementarAsistencia(52);
        dist.aprobarAutoEvaluacion(5);
        dist.aprobarAutoEvaluacion(5);
        dist.aprobarAutoEvaluacion(5);
        
        System.out.println(" el alumno 1 puede rendir ? " + prese.puedeRendir(a1));
        System.out.println(" el alumno 2 puede rendir ? " + prese.puedeRendir(a2));
        System.out.println(" el alumno 3 puede rendir ? " + dist.puedeRendir(a5));
        System.out.println(" el alumno 4 puede rendir ? " + dist.puedeRendir(a6));
        
        
    }
    
}
