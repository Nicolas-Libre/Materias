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
public class Paciente {
    private String nombre;
    private boolean obraSocial;
    private double costo;

    public Paciente(String nombre, boolean obraSocial, double costo) {
        setNombre(nombre);
        setObraSocial(obraSocial);
        setCosto(costo);
    }

    @Override
    public String toString() {
        return "Nombre: " + getNombre() + ", obraSocial= " + isObraSocial() + ", costo= " + getCosto();
    }

    
    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(boolean obraSocial) {
        this.obraSocial = obraSocial;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    
    
    
}
