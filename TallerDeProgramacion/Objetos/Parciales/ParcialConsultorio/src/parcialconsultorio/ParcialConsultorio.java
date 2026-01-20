/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialconsultorio;

/**
 *
 * @author Nicolas
 */
public class ParcialConsultorio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Medico M = new Medico (12, "Silva", "Liliana", 36, "Partos", 5120);
        Consultorio deTia = new Consultorio ("cacona", "54 y 22", M, 3);
        
        Paciente P1 = new Paciente (22, "Libre", "Nicolas", 19, "Osde");
        Paciente P2 = new Paciente (4, "Libre", "Agustin", 8, "Osde");
        Paciente P3 = new Paciente (5, "Libre", "Pedro", 12, "Osde");
        Paciente P4 = new Paciente (6, "Silva", "Analia", 2, "Osde");
        Paciente P5 = new Paciente (22, "Morera", "Brisa", 4, "Osde");
        
        deTia.reservarTurno (P1, 2, 3);
        deTia.reservarTurno (P2, 4, 2);
        deTia.reservarTurno (P3, 1, 1);
        deTia.reservarTurno (P4, 2, 2);
        deTia.reservarTurno (P5, 3, 2);
        
        System.out.println(deTia.toString());
        int aux = deTia.cantPacienteXObraSocial ("Osde");
        System.out.println(aux);
        
        
    }
    
}
