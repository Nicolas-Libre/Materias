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
public class Consultorio {
    private String nombre;
    private String direccion;
    private Medico unMedico;
    private Paciente [][] matrizPaciente;
    private int dimF;

    
    
    public Consultorio (String unNombre, String unDireccion, Medico M, int NTurnos){
        setNombre (unNombre);
        setDireccion(unDireccion);
        setUnMedico (M);
        matrizPaciente = new Paciente [5][NTurnos];
        dimF = NTurnos;
    }
    
    public void reservarTurno (Paciente P, int D, int T) {
        matrizPaciente [D-1][T-1] = P;
    }
    
    
    public int diaMasDisponible () {
        int cantMayorDia=0;
        int cantTurnosDispo=0;
        int maxTurnosDispo=0;
        int i;
        int j;
        for (i=0; i < 5; i++) {
            for (j=0; j < dimF; j++) {
                if (matrizPaciente [i][j] == null) {
                    cantTurnosDispo++;
                }
            }
            if (cantTurnosDispo > maxTurnosDispo) {
                maxTurnosDispo = cantTurnosDispo;
                cantMayorDia = i;
            }
            cantTurnosDispo =0;
        }
        return cantMayorDia;
    }
    
    public int cantPacienteXObraSocial (String xSocial){
        int aux=0;
        int i;
        int j;
        for (i=0; i < 5; i++){
            for (j=0; j<dimF; j++) {
                if ((matrizPaciente[i][j] != null) && (matrizPaciente [i][j].getObraSocial().equals (xSocial))) {
                    aux++;
                }
            }
        }
        return aux;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Medico getUnMedico() {
        return unMedico;
    }

    public void setUnMedico(Medico M) {
        this.unMedico = M;
    }
    
    public String imprimirMatriz () {
        String aux="";
        int i;
        int j;
        for (i=0; i < 5; i++){
            aux+= "Dia " + (i+1);
            for (j=0; j <dimF; j++) {
                aux += " turno: " + (j+1);
                if (matrizPaciente[i][j] == null) {
                    aux+= " disponible" + "\n";
                }
                else {
                    aux += matrizPaciente[i][j].toString() + "\n";
                }
            }
        }
        return aux;
    }
    
    public String toString () {
        String aux="";
        aux += "Nombre: " + getNombre() + ", direccion: " + getDireccion() + ". Mas turnos en el dia: " + (diaMasDisponible() +1) + "\n" 
               + getUnMedico().toString() + "\n" + imprimirMatriz();
        return aux;
    }
    
    
    
}
