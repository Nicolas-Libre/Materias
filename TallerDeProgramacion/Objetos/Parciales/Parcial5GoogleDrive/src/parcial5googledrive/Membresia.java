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
public abstract class Membresia {
    private String nombre;
    private String fecha;
    private Jugador [] vecJugadores;
    private int dimL=0;
    private int dimF;

    public Membresia(String nombre, String fecha, int J) {
        setNombre (nombre);
        setFecha(fecha);
        vecJugadores = new Jugador [J];
        dimF=J;
    }

    public int getDimL() {
        return dimL;
    }

    
    public void agregarJugador (Jugador j){
        if (dimL<dimF) {
            vecJugadores[dimL] = j;
            dimL++;
        }
    }
    
    public Jugador retornarJugador (int J) {
        Jugador aux=null;
        if (vecJugadores[J]!= null) {
            aux=vecJugadores[J];
        }
        return aux;
    }   
    
    public void buscarYAumentar(int P, String nombre, String apellido){
        int i=0;
        boolean ok=false;
        while ((i < dimL) && (ok==false)) {
            if ((vecJugadores[i].getNombre() == nombre) && (vecJugadores[i].getApellido()==apellido)) {
                vecJugadores[i].setPuntajeTotal(vecJugadores[i].getPuntajeTotal()+P);
                vecJugadores[i].setCantApuestasGanadas(vecJugadores[i].getCantApuestasGanadas()+1);
                ok=true;
            }
            else
                i++;
        }
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public abstract Jugador obtenerMejorJugador();
    
    
    
    public String toString(){
       String aux= "Nombre de la memebresia: " + getNombre() + ", Fecha: " + getFecha() 
                    + "\n" + "Mejor Jugador:" + "\n";
       aux += this.obtenerMejorJugador().toString() + "\n";
       return aux;
   }
    
}
