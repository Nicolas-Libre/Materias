/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5ej3dn;

/**
 *
 * @author Nicolas
 */
public class Gira extends Recital {
    private String nombre;
    private Fecha [] vectorFecha;
    private int actual=0;
    private int dimF;
    private int dimL=0;

    public Gira(String nombre, String banda, int cantTemas, int cantFechas) {
        super(banda, cantTemas);
        setNombre(nombre);
        vectorFecha = new Fecha [cantFechas];
        dimF=cantFechas;
    }

    
    public String actuar() {
        String aux = "Buenas Noches " + vectorFecha[actual].getCiudad() + "\n";
        actual++;
        aux += super.actuar();
        return aux;
    } 
    
    public void agregarFecha (Fecha f) {
        if ((dimL < dimF) && (vectorFecha[dimL] == null)) {
            vectorFecha[dimL] = f;
            dimL++;
        }
    }
    
    public double calcularCosto() {
        double aux= 30000*dimL;
        return aux;
        
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getActual() {
        return actual;
    }

    public void setActual(int actual) {
        this.actual = actual;
    }
    
    
    
    
    
}
