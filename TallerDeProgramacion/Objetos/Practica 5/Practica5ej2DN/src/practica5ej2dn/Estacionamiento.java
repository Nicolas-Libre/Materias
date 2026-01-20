/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5ej2dn;

/**
 *
 * @author Nicolas
 */
public class Estacionamiento {
    private String nombre;
    private String direc;
    private double apertura;
    private double cierre;
    private Auto [][] matriz;
    private int totPlazas;
    private int totPisos;

    public Estacionamiento(String nombre, String direc) {
        setNombre(nombre);
        setDirec (direc);
        setApertura(8.00);
        setCierre(21.00);
        totPisos=5;
        totPlazas=10;
        matriz = new Auto [totPisos] [totPlazas];  
    }
    
    public Estacionamiento(String nombre, String direc, double apertura, double cierre, int pisos, int plazas){
    
        setNombre(nombre);
        setDirec (direc);
        setApertura(apertura);
        setCierre(cierre);
        totPisos=pisos;
        totPlazas=plazas;
        matriz = new Auto [pisos] [plazas];  
    }

    
    public void agregarAuto (Auto A, int X, int Y){
        matriz [X-1][Y-1] = A;
    }
    
    public String buscarPatente(int pat) {
        String aux;
        boolean fin=false;
        int i=0;
        int j=0;
        while ((fin == false) && (i< totPisos)) {
            if (matriz [i][j].getPatente() == pat) {
                fin = true;
                aux= "Piso: " + (i+1) + ", plaza: " + (j+1);
            }
            j++;
            if ((j==totPlazas) && (i< totPisos)){
                i++;
                j=0;
            }
        }
        if (false== false) {
            aux= "Auto inexistente";
        }
        return aux;   
    }
    
    public String toString(){
        int i;
        int j;
        String aux="";
        for (i=0; i<totPisos; i++){
            for (j=0; j < totPlazas; j++){
                aux+="-----------------------------" + "\n";
                aux += "Piso " +(i+1) + ", Plaza " + (j+1) + "\n";
                
                if (matriz[i][j] != null) {
                    aux+= matriz[i][j].toString() + "\n";
                    
                }
                else
                    aux+= "libre" + "\n" + "\n";
                
            }
        }
        return aux;
    }
    
    public int autosEnPlaza (int Y) {
        int i;
        int aux=0;
        for (i=0; i < totPisos; i++){
            if (matriz[i][Y-1] !=null) {
                aux++;
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

    public String getDirec() {
        return direc;
    }

    public void setDirec(String direc) {
        this.direc = direc;
    }

    public double getApertura() {
        return apertura;
    }

    public void setApertura(double apertura) {
        this.apertura = apertura;
    }

    public double getCierre() {
        return cierre;
    }

    public void setCierre(double cierre) {
        this.cierre = cierre;
    }
    
    
    
}
