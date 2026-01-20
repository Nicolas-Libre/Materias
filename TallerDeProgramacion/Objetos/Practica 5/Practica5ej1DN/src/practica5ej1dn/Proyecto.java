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
public class Proyecto {
    private int dimF=50;
    private String nombre;
    private int codigo;
    private String director;
    private int dimL=0;
    private Investigador [] vector = new Investigador [dimF];

    public Proyecto(String nombre, int codigo, String director) {
        setNombre(nombre);
        setCodigo(codigo);
        setDirector(director);
    }

    public void agregarInvestigador(Investigador inves) {
        this.vector[dimL] = inves;
        dimL++;
    }
    
    public double dineroTotalOtorgado () {
        int i;
        double aux=0;
        for (i=0; i<dimL; i++) {
            aux += vector[i].montoTotal();
        }
        return aux;
    }
    
    public void otorgarTodos (String nombre_completo){
        int i;
        for (i=0; i < dimL; i++){
            if (vector[i].getNombre() == nombre_completo){
                vector[i].otorgarTodo();
            }
        }
    }
    
    
    private String imprimirVector(){
        String aux="";
        int i;
        for (i=0; i<dimL; i++) {
            aux += vector[i].toString() + "\n" 
                    + "----------------------------------------------------" + "\n";
        } 
        return aux;
    }
    
    public String toString() {
        String aux;
        aux= "Proyecto: " + getNombre() + ", codigo: " + getCodigo() + ". Director: " + getDirector() + "\n" 
                + "Dinero Total Orotgado: " + dineroTotalOtorgado() + "\n" + "-------------------------------------------------" + "\n"
                    + imprimirVector();
        return aux;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    

    
    
    
}
