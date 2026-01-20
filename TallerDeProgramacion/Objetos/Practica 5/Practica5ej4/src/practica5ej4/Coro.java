/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5ej4;

/**
 *
 * @author Nicolas
 */
public abstract class Coro {
    private String nombre;
    private Director elDirector;

    
    public Coro (String unNombre, Director unDirector) {
        setNombre (unNombre);
        setElDirector (unDirector);
    }
    
    public Director getElDirector() {
        return elDirector;
    }

    public void setElDirector(Director unDirector) {
        this.elDirector = unDirector;
    }
    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String unNombre) {
        this.nombre = unNombre;
    }
    
    public abstract void agregarAlCoro (Corista c);
    public abstract boolean estaLleno ();
    public abstract boolean estaOrdenado ();
    public abstract String toString();
}
