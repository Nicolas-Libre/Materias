/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4ej5dn;

/**
 *
 * @author Nicolas
 */
public class Dibujo {
    private String titulo;
    private Figura[] vector;
    private int guardados;
    private int capMax=10;
    
    public Dibujo (String titulo){
        setTitulo (titulo);
        vector= new Figura [capMax];
        setGuardados(0);
    }
    
    public void agregar(Figura f){
        int i=0;
        int aux = getGuardados();
        while (getGuardados() == aux) {
            if (vector[i] == null) {
                setVector(f,i);
                guardados++;
            } 
            else
                i++;
        }
        System.out.println("la figura " + f.toString() + " se ha guardado");
    }
    
    public double calcularArea(){
        int i;
        double aux=0;
        for(i=0; i<getGuardados(); i++) {
            aux += vector[i].calcularArea();
        }
        return aux;
    }
    
    public void mostrar(){
        System.out.println(getTitulo());
        int i;
        for (i=0; i<getGuardados(); i++) {
            System.out.println(vector[i].toString());
        }
        System.out.println(this.calcularArea());
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setGuardados(int guardados) {
        this.guardados = guardados;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getGuardados() {
        return guardados;
    }

    public int getCapMax() {
        return capMax;
    }

    public void setVector(Figura f, int pos) {
        this.vector[pos]= f;
    }
    
    
}
