/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial7googledrive;

/**
 *
 * @author Nicolas
 */
public class Estadio {
    private String nombre;
    private String direccion;
    private int capacidad;
    private Concierto [][] matriz = new Concierto [12][31];
    private int [] vecDimL = new int [12];
    private int maxDias=31;
    
    public Estadio(String nombre, String direccion, int capacidad) {
        setNombre(nombre);
        setDireccion(direccion);
        setCapacidad(capacidad);
        inicializarDimL();
    }

    private void inicializarDimL(){
        int i;
        for (i=0; i<12;i++){
            vecDimL[i]=0;
        }
    }
    
    
    public boolean agregarConcierto (Concierto C,int mes){
        boolean aux=false;
        while ((aux == false) && (mes < 12)) {
          if (vecDimL[mes-1] < maxDias) {
            matriz [mes-1] [vecDimL[mes-1]] = C;
            aux=true;
            vecDimL[mes-1] ++;
          }
          else {
             mes++; 
          }
        }
        return aux;
    }
    
    public boolean agregarConcierto (Concierto C, int mes){
        boolean aux=false;
        if (vecDimL[mes-1] < maxDias) {
            matriz [mes-1] [vecDimL[mes-1]] = C;
            aux=true;
            vecDimL[mes-1] ++;
        }
        return aux;
    }
    
    public String listarMes(int mes){
        String aux ="Mes: " + mes + "\n";
        int i;
        for (i=0; i<vecDimL[mes-1]; i++){
            aux += matriz[mes-1] [i].toString() + "\n";
        }
        return aux;
    }
    
    
    public double calcularGanancia(int mes){
        double aux=0;
        int i;
        for (i=0; i<vecDimL[mes-1];i++){
            aux+=matriz[mes-1][i].calcularPrecioFinal();
        }
        aux = aux/2;
        return aux;
    }
    
    public String toString(){
        String aux = "Estadio: Nombre: " + getNombre() + " - Direccion: " + getDireccion() + " - Capacidad: " + getCapacidad() + "\n";
        int i;
        int j;
        for (i=0; i<12;i++){
            aux+= "Mes: " + (i+1) + "\n";
            for (j=0; j< vecDimL[i];j++){
                aux+= "Dia: " + (j+1) + " " + matriz[i][j].toString() + "\n";
            }
        }
        return aux;
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
    
    
    
    
    
}
