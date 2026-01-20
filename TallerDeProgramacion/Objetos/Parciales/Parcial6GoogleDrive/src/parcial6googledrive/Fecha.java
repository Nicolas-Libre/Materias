/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial6googledrive;

/**
 *
 * @author Nicolas
 */
public class Fecha {
    private int dia;
    private int mes;
    private int año;

    public Fecha (int dia, int mes, int año) {
        setDia(dia);
        setMes(mes);
        setAño(año);
    }
    
    public String toString () {
        String aux = "Dia = " + getDia() + ", Mes= " + getMes() + ", Año= " + getAño();
        return aux;
    }
    
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }
    
    
    
    
}
