package parcialconcursobaile;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nicolas
 */
public class Concurso {
    private Pareja [] vectorParejas;
    private int dimF;
    private int dimL=0;
    
    
    public Concurso (int cantParejas) {
        vectorParejas = new Pareja [cantParejas];
    }

    public void agregarPareja (Pareja P) {
        vectorParejas[dimL] = P;
        dimL++;
    }

    public Pareja[] getVectorParejas() {
        return vectorParejas;
    }
    
    public int mayorDifEdad () {
        int i;
        int mayorPareja=-1;
        int mayorDifPareja=-1;
        for (i=0; i < dimL; i++) {
            if (vectorParejas[i].difEdad() > mayorDifPareja ) {
                mayorPareja = i;
                mayorDifPareja = vectorParejas[i].difEdad();
            }
        }
        return mayorPareja;
    }
}
