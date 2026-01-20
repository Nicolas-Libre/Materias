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
public class Cuenta {
    private int CBU;
    private String alias;
    private int dni;
    private String moneda;
    private double monto;

    public Cuenta(int CBU, String alias, int dni, String moneda) {
        setCBU (CBU);
        setAlias (alias);
        setDni(dni);
        setMoneda(moneda);
        setMonto (0);
    }

    @Override
    public String toString() {
        return "CBU= " + getCBU() + ", alias= " + getAlias() + ", dni= " + getDni() + ", moneda= " + getMoneda() + ", monto= " + getMonto();
    }

    
    
    
    
    public int getCBU() {
        return CBU;
    }

    public void setCBU(int CBU) {
        this.CBU = CBU;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    
    
    
    
}
