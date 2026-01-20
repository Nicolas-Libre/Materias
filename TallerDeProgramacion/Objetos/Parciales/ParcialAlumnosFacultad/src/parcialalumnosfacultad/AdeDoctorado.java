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
public class AdeDoctorado extends Alumno {
    private String titulo;
    private String origen;
    
    public AdeDoctorado (int unDNI, String unNombre, int unDimF, String unTitulo, String unOrigen){
        super (unDNI, unNombre, unDimF);
        setTitulo (unTitulo);
        setOrigen (unOrigen);
        
        
        
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }
    
    public String toString (){
        String aux;
        aux = super.toString() + "Esta Graduado " + getTitulo() + " y estudio en " + getOrigen();
        return aux;
    }

}