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
public class DeDoctorado extends Alumno {
    private String titulo;
    private String universidad;

    public DeDoctorado(String titulo, String universidad, int dni, String nombre, int N) {
        super(dni, nombre, N);
        setTitulo(titulo);
        setUniversidad(universidad);
    }

    public String toString (){
        String aux = super.toString();
        aux+= " Titulo: " + getTitulo() + " en la universidad: " + getUniversidad();
        return aux;
    }
    
    
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }
    
    
    
    
    
}
