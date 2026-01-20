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
public class Alumno {
    private int dni;
    private String nombre;
    private int asistencias=0;
    private int autoEvaAprobada=0;

    public Alumno(int dni, String nombre) {
        setDni(dni);
        setNombre(nombre);
    }
    
    
    

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
    }

    public int getAutoEvaAprobada() {
        return autoEvaAprobada;
    }

    public void setAutoEvaAprobada(int autoEvaAprobada) {
        this.autoEvaAprobada = autoEvaAprobada;
    }
    
    
    
    
    
}
