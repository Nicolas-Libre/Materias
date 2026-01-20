/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial5googledrive;

/**
 *
 * @author Nicolas
 */
public class Jugador {
    private String nombre;
    private String apellido;
    private int cantApuestasGanadas=0;
    private int puntajeTotal=0;

    public Jugador(String nombre, String apellido) {
        setNombre(nombre);
        setApellido(apellido);
    }

    @Override
    public String toString() {
        return "Nombre del jugador: " + getNombre() + ", Apellido=" + getApellido() + ", cantApuestasGanadas: " + getCantApuestasGanadas() + ", puntajeTotal: " + getPuntajeTotal();
    }

    
    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCantApuestasGanadas() {
        return cantApuestasGanadas;
    }

    public void setCantApuestasGanadas(int cantApuestasGanadas) {
        this.cantApuestasGanadas = cantApuestasGanadas;
    }

    public int getPuntajeTotal() {
        return puntajeTotal;
    }

    public void setPuntajeTotal(int puntajeTotal) {
        this.puntajeTotal = puntajeTotal;
    }
    
    
    
}
