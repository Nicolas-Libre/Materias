/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5ej1dn;

/**
 *
 * @author Nicolas
 */
public class Investigador {
    private int dimF=5;
    private int dimL=0;
    private String nombre;
    private int categoria;
    private String especialidad;
    private Subsidio [] vector = new Subsidio [dimF];

    public Investigador(String nombre, int categoria, String especialidad) {
        setNombre(nombre);
        setCategoria(categoria);
        setEspecialidad(especialidad);
    }

    public double montoTotal() {
        int i;
        double aux=0;
        for (i=0; i<dimL; i++) {
            if (vector[i].isOtorgado() == true) {
                aux += vector[i].getMonto();
            }
        }
        return aux;
    }
    
    public void otorgarTodo () {
        int i;
        for (i=0; i<dimL; i++) {
            vector[i].setOtorgado (true);
        }
    }
    
    
    public String toString() {
        String aux;
        aux = "Nombre: " + getNombre() + " categoria: " + getCategoria() + ", especialidad: " + getEspecialidad() + "\n" + "\n";
        aux += "Dinero total otorgado " + this.montoTotal();
        return aux;
    }
    
    public void agregarSubsidio(Subsidio subs) {
        this.vector[dimL] = subs;
        dimL++;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Subsidio[] getVector() {
        return vector;
    }

    
    
    
    
    
}
