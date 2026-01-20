/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialagendasemanal;

/**
 *
 * @author Nicolas
 */
public class ParcialAgendaSemanal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Sistema S = new Sistema ();
        
        Paciente P1 = new Paciente ("nico", "OSDE", 22);
        Paciente P2 = new Paciente ("brisa", "OSDE", 23);
        Paciente P3 = new Paciente ("anita", "OSDE", 50);
        
        S.agregarPaciente(2, 4, P1);
        S.agregarPaciente(4, 2, P2);
        S.agregarPaciente(3, 1, P3);
        
        System.out.println(S.toString());
        
        S.liberarTurnos ("nico");
        
        System.out.println(S.toString());
        
    }
    
}
