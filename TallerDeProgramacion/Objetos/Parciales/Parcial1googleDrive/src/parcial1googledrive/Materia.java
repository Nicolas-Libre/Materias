/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial1googledrive;

/**
 *
 * @author Nicolas
 */
public class Materia {
    private String nombre;
    private int nota;
    private String fecha;

    public Materia(String nombre, int nota, String fecha) {
        setNombre(nombre);
        setNota(nota);
        setFecha(fecha);
    }

    @Override
    public String toString() {
        return "Materia;: " + getNombre() + ", nota: " + getNota() + ", fecha: " + getFecha();
    }

    
    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
}
