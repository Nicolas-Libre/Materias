/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialempresainformatica;

/**
 *
 * @author Nicolas
 */
public class Empresa {
    private String nombre;
    private Lider lider;
    private Programador [] vectorProgramadores;
    private int dimL=0;
    private int dimF;
    
    public Empresa (String unNombre, Lider unLider, int cantProgramadores) {
        setNombre (unNombre);
        setLider (unLider);
        vectorProgramadores = new Programador [cantProgramadores]; 
        dimF = cantProgramadores;
    }
    
    
    
    public void agregarProgramador (Programador comun) {
        if (dimL < dimF) {
            vectorProgramadores [dimL] = comun;
            dimL++;
        }
    }

    public Programador[] getVectorProgramadores() {
        return vectorProgramadores;
    }

    
    
    
    public double montoTotalEmpresa () {
        double aux=0;
        int i;
        for (i=0; i < dimL; i++ ) {
            aux += vectorProgramadores[i].calcularSueldoFinal();
        }
        aux+= lider.sueldoFinalLider();
        return aux;
    }
    
    
    public void aumentarSueldoTotal (double M) {
        int i;
        for (i=0; i < dimL; i++) {
            vectorProgramadores[i].aumentarSueldo(M);
        }
        lider.aumentarSueldo (M);
    }
    
    public Programador getLider() {
        return lider;
    }

    public void setLider(Lider lider) {
        this.lider = lider;
    }
    
    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String unNombre) {
        this.nombre = unNombre;
    }
    
    
    private String imprimirVector () {
        String aux="";
        int i;
        for (i=0; i < dimL; i++) {
            aux += "Programador: " + (i+1) + vectorProgramadores[i].toString() + "\n";
        }
        return aux;
    }
    
    public String toString () {
        String aux = "Nombre de Empresa: " + getNombre() + "\n"
                + "Programador lider: " + lider.toStringLider() +"\n"
                + imprimirVector() +"\n" +
                "Monto total a abonar por la empresa: " + montoTotalEmpresa();
        return aux;
        
    }
    
    
    
    
}
