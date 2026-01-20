/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialbanco;

/**
 *
 * @author Nicolas
 */
public abstract class Banco {
    private String nombre;
    private int empleados;
    private Cuenta [] vectorCuentas;
    private int dimL=0;
    private int dimF;

    public Banco (String unNombre, int cantEmpleados, int cantCuentas) {
        setNombre (unNombre);
        setEmpleados (cantEmpleados);
        vectorCuentas = new Cuenta [cantCuentas];
        setDimF (cantCuentas);
    }

    
    public boolean agregarCuenta (Cuenta c){
        boolean aux=false;
        if (getDimL() < getDimF()) {
            vectorCuentas [dimL] = c;
            aux=true;
        }
        return aux;
    }
    
    public Cuenta obtenerCuenta (int numCBU) {
        Cuenta aux = null;
        boolean corte=false;
        int i=0;
        while ((i < dimL) && (corte == false)) {
            if (vectorCuentas [i].getCBU() == numCBU) {
                corte = true;
                aux = vectorCuentas[i];
            }
            i++;
        }
        return aux;
    }
    
    public void depositarDinero (int numCBU, double unMonto) {
        Cuenta aux = this.obtenerCuenta(numCBU);
        double auxMonto = 0 ;//aux.getMonto();
        auxMonto = auxMonto + unMonto;
        aux.setMonto(auxMonto);
    }
    public int getDimL() {
        return dimL;
    }

    public void setDimL(int dimL) {
        this.dimL = dimL;
    }

    public int getDimF() {
        return dimF;
    }

    public void setDimF(int dimF) {
        this.dimF = dimF;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEmpleados() {
        return empleados;
    }

    public void setEmpleados(int empleados) {
        this.empleados = empleados;
    }
    
    public abstract boolean puedeRecibirTarjeta (int numCBU);
    
}
