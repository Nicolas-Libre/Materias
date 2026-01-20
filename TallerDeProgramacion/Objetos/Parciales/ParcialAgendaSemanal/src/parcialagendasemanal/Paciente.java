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
public class Paciente {
    private String nombre;
    private String obraSocial;
    private double costoSesion;

    public Paciente (String unNombre, String unaObraSocial, double unCostoSesion){
        setNombre (unNombre);
        setObraSocial (unaObraSocial);
        setCostoSesion (unCostoSesion);
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(String obraSocial) {
        this.obraSocial = obraSocial;
    }

    public double getCostoSesion() {
        return costoSesion;
    }

    public void setCostoSesion(double costoSesion) {
        this.costoSesion = costoSesion;
    }
    
    public String toString () {
        String aux;
        aux = "Nombre: " + getNombre() + ", Obra Social: " + getObraSocial() + ", Costo: " + getCostoSesion();
        return aux;
    }
    
    
}
