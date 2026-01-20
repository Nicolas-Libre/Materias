package parcialestadistica;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nicolas
 */
public class SistemaAño extends Sistema {
    
    private SistemaTrimestre [] añosAcademicos;
    private int dimF;
    
    public SistemaAño (Carrera c, int NAños) {
        super (c);
        añosAcademicos = new SistemaTrimestre [NAños];
        dimF=NAños;
        int i;
        for (i=0; i< NAños; i++) {
            añosAcademicos[i] = new SistemaTrimestre (c, NAños);
        }
    }
    
    public void setCantidadEgresados (int añoX, int trimestreY, int cant) {
        
        añosAcademicos[(añoX -1)].devolverSetEgresados((trimestreY), cant);
        
    }
    
    public int getCantidadEgresados (int añoX, int trimestreY) {
        int aux;
        aux = añosAcademicos [añoX-1].getCantEgresados(trimestreY);
        return aux;
        
    }
    
    public int cantidadTrimestresConXAlumnos (int alumnosX) {
        int i;
        int aux=0;
        for (i=0; i < dimF; i++){
            aux +=añosAcademicos[i].devolverCantAlumnos (alumnosX);
        }
        return aux;
    }
    
    public String imprimirVector() {
        String aux="";
        int i;
        for(i=0; i < dimF; i++) {
            aux += "Año: " + (this.getUnaCarrera().getAñoCreacion()+i) +
                    "-- CantEgresados= " + añosAcademicos[i].devolverTotalEgresados() 
                    +"\n";
        }
        return aux;
    }
    
    public String toString () {
        String aux;
        aux = super.getUnaCarrera().toString()+ "\n" 
                + imprimirVector();
        return aux;
    }
}
