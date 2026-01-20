/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialestadistica;

/**
 *
 * @author Nicolas
 */
public abstract class Sistema {
    private Carrera unaCarrera;
    
    public Sistema (Carrera c) {
        setUnaCarrera (c);
    }

    public Carrera getUnaCarrera() {
        return unaCarrera;
    }

    public void setUnaCarrera(Carrera unaCarrera) {
        this.unaCarrera = unaCarrera;
    }
    public abstract String toString();
    
}
