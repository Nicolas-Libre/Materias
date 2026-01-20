/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialalumnosfacultad;

/**
 *
 * @author Nicolas
 */
public class Materia {
    private String nombre;
    private int nota;
    private String fecha;
    
    public Materia (String unNombre, int unaNota, String unFecha) {
        setNombre (unNombre);
        setNota (unaNota);
        setFecha (unFecha);
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
    
    public String toString (){
        String aux;
        aux = "Nombre de la Materia: " + getNombre () + ", Nota: " + getNota() + ", Fecha: " + getFecha();
        return aux;
    }
    
}
