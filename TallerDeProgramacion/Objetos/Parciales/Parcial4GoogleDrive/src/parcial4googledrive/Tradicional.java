/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial4googledrive;

/**
 *
 * @author Nicolas
 */
public class Tradicional extends Banco {
    private String direccion;
    private String localidad;
    private int cantCuentasDolares;

    public Tradicional(String direccion, String localidad, String nombre, int cantEmpleados, int N) {
        super(nombre, cantEmpleados, N);
        setDireccion(direccion);
        setLocalidad(localidad);
        setCantCuentasDolares(0);
    }
    
    public boolean puedeRecibirTarjeta(int CBU) {
        Cuenta aux = super.obtenerCuenta(CBU);
        boolean auxB;
        if ((aux.getMoneda().equals("dolares")) && (aux.getMonto() > 500)) {
            auxB=true;
        }
        else  
            if ((aux.getMoneda().equals("pesos")) && (aux.getMonto() > 70000)) {
                auxB=true;
            }
            else
                auxB=false;
        return auxB;
    }
    
    public boolean verificarSiPuedo(Cuenta c){
        boolean aux;
        if (cantCuentasDolares < 100){
            aux = super.agregarCuenta(c);
        }
        else
            aux=false;
        return aux;
    }
    
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getCantCuentasDolares() {
        return cantCuentasDolares;
    }

    public void setCantCuentasDolares(int cantCuentasDolares) {
        this.cantCuentasDolares = cantCuentasDolares;
    }
    
    
    
    
    
    
}
