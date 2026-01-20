/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication26;

/**
 *
 * @author Nicolas
 */
public class Estante {
    private Libro [] vEstante = new Libro [20];
    private int cant;
    private boolean estaLleno;    
    private Libro libroBuscado;
    
    public Estante (){
        int i;
        Autor aE = new Autor ("x", "x", "x");
        for (i=0; i<20;i++)
            vEstante [i] = new Libro ("x", "x", -1, aE, "x", -1);
        }
    
        
    
    
    public void cacEstante (Libro unL, int unaPos){
        vEstante [unaPos] = unL;
    } 
    
    public boolean estaLleno () {
        boolean auxEstaLleno = true;
        if (this.vEstante [19].getAñoEdicion() == -1) {
            auxEstaLleno=false;
        }
        estaLleno = auxEstaLleno;
        return estaLleno;
    }
    
    public int getCantLibros () {
        int i;
        int auxCant = 0;
        for (i = 0; i < 20; i++) {
            if (this.vEstante[i].getAñoEdicion() != -1) {
                auxCant++;
            }
                
        }
        cant = auxCant; 
        return cant;
    }
    
    public Libro preguntarLibro (String xTitulo){
        int i;
        Libro auxLibroBuscado = new Libro();
        for (i=0; i < 20; i++) {
            if (this.vEstante[i].getTitulo().equals(xTitulo)) {
                auxLibroBuscado = this.vEstante[i];
            }
            
        }
        libroBuscado = auxLibroBuscado;
        return libroBuscado;
    }
    public Libro[] getvEstante() {
        return vEstante;
    }

}



    
