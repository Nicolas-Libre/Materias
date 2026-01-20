/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialconciertos;

/**
 *
 * @author Nicolas
 */
public class Estadio {
    private String nombre;
    private String direccion;
    private int capacidad;
    private Concierto [][] matrizAgenda = new Concierto [12][31];
    private int DLF=0;
    private int DLC=0;
    private int [] vectorDimL = new int [12];
    
    
    public Estadio (String unNombre, String unaDireccion, int unaCapacidad){
        setNombre (unNombre);
        setDireccion (unaDireccion);
        setCapacidad (unaCapacidad);
        ;
        
    }
    
    
    public void agregarConcierto (int M, Concierto C) {
        if ((M < 12) && (vectorDimL[11] < 31)){
            matrizAgenda [M-1][vectorDimL[M-1]] = C;
            vectorDimL[M-1]++;
        }
    }

    public int getDLF() {
        return DLF;
    }

    public int getDLC() {
        return DLC;
    }
    
    
    public String mostrarMesM (int M) {
        String aux="";
        int i;
        for (i=0; i < vectorDimL[M]; i++) {
            aux+= matrizAgenda[M][i].toString() + "\n";
        }
        return aux;
    }
    
    
    public double calcularGananciaMesM (int M) {
        double auxRetornar;
        double auxCuenta=0;
        int i;
        for (i=0; i < vectorDimL[M]; i++){
            auxCuenta+= (matrizAgenda[M][i].getCantVendidas() * matrizAgenda[M][i].getPrecioEntrada());
        }
        auxRetornar= (auxCuenta/2.0);
        return auxRetornar;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    public String imprimirMatriz() {
        String aux="";
        int i;
        int j;
        for (i=0; i < 12; i++){
            aux += "Mes " + (i+1) +":"+ "\n";
            for (j=0; j < vectorDimL[i]; j++){
                aux +=  "Dia " + (j+1) + ": " + matrizAgenda[i][j].toString() + "\n";
            }
        }
        return aux;
    }
    
    public String toString () {
        String aux="";
        aux+= "Estadio: " + getNombre() + ", Direccion: " + getDireccion()
                + ", Capacidad: " + getCapacidad() + "\n" +
                imprimirMatriz();
        return aux;
    }
    
    
    
}
