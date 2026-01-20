/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5ej1;

/**
 *
 * @author Nicolas
 */
public class Investigador {
    private String nombre;
    private int categoria;
    private String especialidad;
    private Subsidio [] cantSubsidios = new Subsidio [5];
    private int dimL =0;

    public Investigador(String nombre, int numCateogria, String especialidad) {
        setNombre(nombre);
        setEspecialidad (especialidad);

        setCategoria (numCateogria);
    }

    public void agregarSubsidio (Subsidio unSubsidio) {
        if (cantSubsidios [getDimL()] == null) {
            cantSubsidios[getDimL()] = unSubsidio;
        }
        setDimL(dimL++);
        if (getDimL() == 5)
            System.out.println("No se pueden tener mas subsidios");
        
        
    }
    
    public void otorgarCadaSubsidio () {
        int i;
        for (i=0; i < 5; i++) {
            this.cantSubsidios[i].setFueOtorgado(true);
        }
    }
            
            
    public Subsidio getCantSubsidios(int z) {
        return cantSubsidios[z];
    }

    public int getDimL() {
        return dimL;
    }

    public void setDimL(int dimL) {
        this.dimL = dimL;
    }
    
    
    public void setCategoria (int x) {
        if (x < 1)
            categoria = 1;
        else if (x > 5)
            categoria = 5;
        else categoria = x;
    }
    
    public int getCategoria () {
        return this.categoria;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }


    public String toString() {
        String aux;
        double dineroTotal=0;
        int i;
        for (i=0; i < 5; i++) {
            if (cantSubsidios[i].isFueOtorgado() == true) {
                dineroTotal = dineroTotal + cantSubsidios[i].getMontoPedido();
            }
        }
        aux = "Nombre del investigador: " + getNombre() + 
                ", categoria: " + getCategoria() + 
                " y su especialidad es " + getEspecialidad() + 
                ". El dinero de sus subsidios es: " + dineroTotal;
        return aux;
    } 
    
    
}
