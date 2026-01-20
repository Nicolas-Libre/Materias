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
public abstract class Banco {
    private String nombre;
    private int cantEmpleados;
    private Cuenta [] vecCuentas;
    private int dimF;
    private int dimL=0;

    
    
    public Banco (String nombre, int cantEmpleados, int N){
        setNombre(nombre);
        setCantEmpleados (cantEmpleados);
        vecCuentas = new Cuenta [N];
        dimF=N;
        
    
    }
    
    public boolean agregarCuenta (Cuenta c){
        boolean aux;
        if (dimL < dimF) {
            vecCuentas [dimL] = c;
            dimL++;
            aux= true;
        }
        else
            aux=false;
        return aux;
    }
    
    
    public Cuenta obtenerCuenta (int CBU) {
        Cuenta aux=null;
        int i=0;
        boolean ok=false;
        while ((i < dimL) && (ok == false)){
            if (vecCuentas[i].getCBU() == CBU) {
                aux = vecCuentas[i];
                ok=true;
            }
            else i++;
        }
        return aux;
    }
    
    
    public void depositarDinero2 (int CBU, double monto) {
        Cuenta aux = this.obtenerCuenta(CBU);
        aux.setMonto(monto + aux.getMonto());
        
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantEmpleados() {
        return cantEmpleados;
    }

    public void setCantEmpleados(int cantEmpleados) {
        this.cantEmpleados = cantEmpleados;
    }
    
    public abstract boolean puedeRecibirTarjeta(int CBU);
    
    
    
}
