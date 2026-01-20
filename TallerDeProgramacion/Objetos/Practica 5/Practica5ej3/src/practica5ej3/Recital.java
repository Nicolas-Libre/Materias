/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5ej3;

/**
 *
 * @author Nicolas
 */
public abstract class Recital {
    private String banda;
    private String [] listaTemas;
    private int dimF;
    
    public Recital (String unaBanda, int cantTemas) {
        setBanda (unaBanda);
        generarLista (cantTemas);
        setDimF(cantTemas);
    }
    
    public void agregarTema (String tema) {
        int i=0;
        while (i < getDimF()){
            if (this.listaTemas[i] == null) {
                setListaTemas (tema, i);
                i=dimF;
            }
            i++;
        } 
    }
    
    public String  actuar () {
        int i;
        String aux;
        aux = "La lista de temas es: ";
        for (i=0; i < dimF; i++){
            aux+= "\n" + this.listaTemas [i];
            
        }
        return aux;
    }
        
    

    
    private void setDimF (int x) {
        this.dimF=x;
    }

    public int getDimF() {
        return dimF;
    }
    
    
    private void generarLista (int nTemas) {
        this.listaTemas = new String [nTemas];
    }
    public String getBanda() {
        return banda;
    }

    private void setBanda(String banda) {
        this.banda = banda;
    }

    public String[] getListaTemas() {
        return listaTemas;
    }

    public void setListaTemas(String y, int x) {
        this.listaTemas [x] = y;
    }



    public abstract double calcularCosto ();


}
