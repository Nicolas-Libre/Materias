/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialwspturnoh2024;

/**
 *
 * @author Nicolas
 */
public class Supermercado {
    private String nombre;
    private String direccion;
    private Producto [] [] matrizGondola;
    private int [] vecDimL;
    private int maxEstantes;
    private int maxGondolas;
    public Supermercado (String nombre, String direccion, int G, int E){
        setNombre (nombre);
        setDireccion (direccion);
        matrizGondola= new Producto [G][E];
        vecDimL = new int [G];
        inicializarVecDimL (G);
        maxEstantes=E;
        maxGondolas=G;
    
    }
    
    private void inicializarVecDimL (int max){
        int i;
        for (i=0;i<max;i++){
            vecDimL[i]=0;
        }
    }
    public void agregarProducto (Producto p){
        int i=0;
        boolean aux = false;
        while ((aux==false) && (i<maxGondolas)){
            if (vecDimL[i]<maxEstantes) {
                matrizGondola [i] [vecDimL[i]] =p;
                vecDimL[i]++;
                aux=true;
            }
            else 
                i++;
        }
    }
    
    
    public String listarProductoM (String M, int X) {
        int i;
        String aux="";
        for (i=0; i<vecDimL[X-1]; i++){
            if (matrizGondola [X-1][i].getMarca().equals(M)){
                aux+= matrizGondola [X-1][i].toString() + "\n";
            }
        }
        return aux;
    }
    
    
    
    private int obtenerCantUni (int X){
        int i;
        int aux=0;
        for (i=0; i < vecDimL[X]; i++){
            aux+= matrizGondola[X][i].getCantUni();
        }
        return aux;
    }
    
    public int mayorGondola (){
        int maxUni=0;
        int maxGondola=-1;
        int i;
        int aux;
        for (i=0; i< maxGondolas; i++){
            aux = this.obtenerCantUni(i);
            if (aux > maxUni) {
                maxUni=aux;
                maxGondola=i;
            }
        }
        return (maxGondola+1);
    }
    
    private String imprimirMatriz() {
        int i;
        int j;
        String aux="";
        for (i=0;i< maxGondolas; i++){
            aux+= "Gondola " + (i+1) + "\n";
            for (j=0; j<maxEstantes;j++){
                aux+= "Estante "  + (j+1) +" "+ matrizGondola[i][j].toString() + "\n";
            }
        }
        return aux;
    }
    public String toString (){
        String aux = "Supermercado: " + getNombre() + ", " + getDireccion() + "\n";
        aux+= this.imprimirMatriz();
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

    public void setDireccion(String diceccion) {
        this.direccion = diceccion;
    }
    
    
    
    
    
}
