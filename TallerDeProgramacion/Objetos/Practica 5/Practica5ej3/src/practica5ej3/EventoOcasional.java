/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5ej3;

/**
 *
 * @author Nicolas
 */
public class EventoOcasional extends Recital {
    private int nMotivo;
    private String [] motivo = new String [3];
    private String contratante;
    private String dia;

    public EventoOcasional (String banda, int temas, int unMotivo, String unContratante, String unDia) {
        super (banda,temas);
        getMotivo ((unMotivo - 1));
        setNMotivo ((unMotivo - 1));
        setContratante (unContratante);
        setDia (unDia);
    }

    public double calcularCosto () {
        double aux=0;
        if (getNMotivo () == 1) {
            aux = 50000;
        }
        else if (getNMotivo() == 2) {
            aux =150000;
        }
        return aux;
           
    }
    
    public void setNMotivo(int nMotivo) {
        this.nMotivo = nMotivo;
    }

    public int getNMotivo() {
        return nMotivo;
    }
    
    public String actuar () {
        String aux;
        if (getNMotivo () == 0) {
            aux = "Recuerden colaborar con " + getContratante();
        } 
        else if (getNMotivo() == 1) {
            aux = "Saludos Televidentes ";
        }
        else {
            aux = "Un feliz cumpleaños a " + getContratante ();
        }
        aux =  aux + super.actuar();
        return aux;
    }
    
    public void generarVectorMotivo () {
        this.motivo[0] = "a beneficio";
        this.motivo [1] = "show de TV";
        this.motivo[2] = "show privado";
    }
    public String getMotivo(int unMotivo) {
        String aux;
        aux = this.motivo [unMotivo];
        return aux;
    }



    public String getContratante() {
        return contratante;
    }

    public void setContratante(String contratante) {
        this.contratante = contratante;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
    
    
    
    
    
    
    
}
