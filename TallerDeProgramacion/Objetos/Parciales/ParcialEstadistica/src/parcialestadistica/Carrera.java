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
public class Carrera {
    private String nombre;
    private String facultad;
    private int añoCreacion;

    
    public Carrera (String unNombre, String unaFacultad, int unAñoCreacion){
        setNombre (unNombre);
        setFacultad (unaFacultad);
        setAñoCreacion (unAñoCreacion);
        
    }    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public int getAñoCreacion() {
        return añoCreacion;
    }

    public void setAñoCreacion(int añoCreacion) {
        this.añoCreacion = añoCreacion;
    }
    
    public String toString (){
        String aux;
        aux= "Nombre: " + getNombre() + " Facultad: " + getFacultad() + 
                " AñoCreacion: " + getAñoCreacion();
        return aux;
    }
    
    
    
}
