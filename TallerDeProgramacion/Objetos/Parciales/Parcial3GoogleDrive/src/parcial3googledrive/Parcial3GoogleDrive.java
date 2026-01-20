/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial3googledrive;

/**
 *
 * @author Nicolas
 */
public class Parcial3GoogleDrive {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Paciente p1 = new Paciente ("Nico", true, 5000);
        Paciente p2 = new Paciente ("Bri", false, 4513);
        Paciente p3 = new Paciente ("Anita", true, 9568);
        Paciente p4 = new Paciente ("Pedro", true, 2245);
        Paciente p5 = new Paciente ("Wancho", false, 2222);
        
        Agenda ag = new Agenda ();
        ag.agregarPaciente(5, 4, p5);
        ag.agregarPaciente(4, 2, p4);
        ag.agregarPaciente(1, 3, p3);
        ag.agregarPaciente(2, 2, p2);
        ag.agregarPaciente(2, 5, p1);
        
        System.out.println(ag.toString());
        ag.liberarTurno("Nico");
        System.out.println("---------");
        System.out.println(ag.toString());
    }
    
}
