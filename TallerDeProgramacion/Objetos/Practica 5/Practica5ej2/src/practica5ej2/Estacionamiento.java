/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5ej2;

import java.util.Arrays;

/**
 *
 * @author Nicolas
 */
public class Estacionamiento {
    private String nombre;
    private String direc;
    private double horaApertura;
    private double horaCierre;
    private int DFC;
    private int DFF;
    private Auto  [][] ubicacion  ;

    
    public Estacionamiento (String unNombre, String unDirec, double unHoraApertura, double unHoraCierre, int unDFF, int unDFC){
        setDFC (unDFC);
        setDFF (unDFF);
        setDirec (unDirec);
        setHoraApertura (unHoraApertura);
        setHoraCierre (unHoraCierre);
        setNombre (unNombre);
        setUbicacion (unDFF,unDFC);
        
    }
            
    
    public Estacionamiento (String unNombre, String unaDirec){
        setNombre (unNombre);
        setDirec (unaDirec);
        setHoraCierre (8);
        setHoraApertura (21);
        setUbicacion (5,10);
    }

    public Auto[][] getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Auto[][] ubicacion) {
        this.ubicacion = ubicacion;
    }
    

    
    public void setAuto (Auto a, int x, int y) {
        this.ubicacion [x] [y] = a;
        
    }
    
    public Auto getAuto (int x, int y) {
        return this.ubicacion [x][y];
    }
    
    public void setUbicacion (int unDFF, int unDFC) {
        this.ubicacion = new Auto [unDFF][unDFC];
 
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

    public double getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(double horaApertura) {
        this.horaApertura = horaApertura;
    }

    public double getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(double horaCierre) {
        this.horaCierre = horaCierre;
    }

    public int getDFC() {
        return DFC;
    }

    public void setDFC(int DFC) {
        this.DFC = DFC;
    }

    public int getDFF() {
        return DFF;
    }

    public void setDFF(int DFF) {
        this.DFF = DFF;
    }

    
    private String imprimirMatriz () {
        int i;
        int z;
        String aux ="";
        for (i=0; i < DFF; i++) {
            aux += "\n"+"-------------------------------------------------------------------------------------" + "\n";
            for (z=0; z < DFC; z++) {
                if (ubicacion [i][z] != null) {
                    aux += (ubicacion[i][z].toString() +
                         " y esta ubicado en la fila " + (i+1) +
                         " y en la columna " + (z+1));
                }
                else {
                    aux +=" | No hay Auto";
                }
            }
        }
        return aux;
    }
    
    @Override
    public String toString() {
        String aux="";
        aux += "Nombre= " + getNombre() + 
                ", direc= " + getDirec() + 
                ", horaApertura= " + getHoraApertura() + 
                ", horaCierre= " + getHoraCierre()+ "\n" + 
                "info de los autos en el estacionamiento: " + "\n"+
                imprimirMatriz();
        return aux;
    }

    public String buscarPatente (int pat) {
        int i;
        int j;
        String aux="";
        for (i=0; i < DFF; i ++) {
            for (j=0; j < DFC; j++) {
                if (ubicacion[i][j] != null) {
                    if (ubicacion [i][j].getPatente() == pat){
                        aux = "Dicha patente se encuentra en el piso " + (i+1) + "\n"+
                                "y en la plaza " + (j+1);
                                j=25;
                                i=25;
                        }
                    
                  
                }
        
            }
        }
        if (aux.equals ("")) {
            aux = "Auto Inexistente";
        }
        return aux;
    }  
    
    public int cantAutosEnPlaza (int y) {
        int i;
        int cant=0;
        for (i=0; i < DFF; i++){
            if (ubicacion [i][y] != null){
                cant++;
            }
        }
        return cant;         
    }
}
