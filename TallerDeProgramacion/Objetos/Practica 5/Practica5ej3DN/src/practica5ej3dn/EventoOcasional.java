/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5ej3dn;

/**
 *
 * @author Nicolas
 */
public class EventoOcasional extends Recital {
    private String [] motivo = new String [3];
    private String contratante;
    private String fecha;
    private int mot;

    public EventoOcasional(int motivo, String contratante, String fecha, String banda, int cantTemas) {
        super(banda, cantTemas);
        setMot(motivo-1);
        setContratante(contratante);
        setFecha(fecha);
        setMotivo();
    }

    public String actuar() {
        String aux = getMotivo(mot) + "\n";
        aux += super.actuar();
        return aux;
    }
    
    public void setMot(int mot) {
        this.mot = mot;
    }

    public double calcularCosto () {
        if (mot == 0) {
            return 0;
        }
        else if (mot==1){
            return 50000;
        }
        else
            return 150000;
            
    }
    
    private void setMotivo(){
        motivo[0]="Recuerden colaborar con " + getContratante();
        motivo[1]="Saludos amigos televidentes";
        motivo[2]="Un feliz cumpleaños para " + getContratante();
    }
    
    public String getMotivo(int pos) {
        return motivo[pos];
    }

    

    public String getContratante() {
        return contratante;
    }

    public void setContratante(String contratante) {
        this.contratante = contratante;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
    
    
    
}
