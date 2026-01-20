/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4ej5;

/**
 *
 * @author Nicolas
 */
public class Dibujo {
    private String titulo;
    private Figura [] vector;
    private int guardadas;
    private int capMax = 10;
    
    public Dibujo (String unTitulo){
        setTitulo(unTitulo);
    }

    public Figura[] getVector() {
        return vector;
    }

    public void setVector(Figura F) {
        int i=0;
        while (i != getCapMax()) {
            if (vector[i].getColorRelleno().equals("x") ) {
                vector[i] = F;
                i=getCapMax();
            }
            i++;
        }
            
    }

    public void agregar (Figura f) {
        setVector (f);
        System.out.println("La figura " + f.toString() + "se ha guardado ");
    } 
    
    public double calcularArea (int dimL) {
        int i;
        double aux=0;
        for (i=0; i < (dimL+1); i++){
            aux = aux + vector[i].calcularArea();
        }
        return aux;
    }
        
    public void mostrar () {
        System.out.println(getTitulo());
        int i=0;
        int dimL=0;
        while (i != getCapMax()) {
            if (vector[i] != null) {
                vector[i].toString();
                dimL++;
                i++;
            }
            else i= getCapMax();
        }
        System.out.println(this.calcularArea(dimL));
        
        
    }
    
    public boolean estaLleno () {
        return (guardadas == capMax);
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getGuardadas() {
        return guardadas;
    }

    public void setGuardadas(int guardadas) {
        this.guardadas = guardadas;
    }

    public int getCapMax() {
        return capMax;
    }

    public void setCapMax(int capMax) {
        this.capMax = capMax;
    }
    
    
    
    
}
