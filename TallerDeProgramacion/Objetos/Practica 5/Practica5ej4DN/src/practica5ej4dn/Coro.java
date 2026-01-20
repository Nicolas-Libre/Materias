/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5ej4dn;

/**
 *
 * @author Nicolas
 */
public abstract class Coro {
    private Director direc;
    private String nombre;

    public Coro(Director direc, String nombre) {
        setDirec(direc);
        setNombre(nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDirec(Director direc) {
        this.direc = direc;
    }

    public Director getDirec() {
        return direc;
    }
    
    
    public abstract void agregarCorista(Corista cor);
    public abstract boolean estaLLeno();
    public abstract boolean bienFormado();
    public String toString() {
        String aux= "Nombre del coro: " + getNombre() + "Director: " + getDirec().toString() +"\n";
        return aux;
    }
}
