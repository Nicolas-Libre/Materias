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
public class Cuenta {
    private int CBU;
    private String alias;
    private int DNIdelTitular;
    private String moneda;
    private double monto=0;

    public Cuenta (int unCBU, String unAlias, int unDNITitular, String unMoneda) {
        setCBU (unCBU);
        setAlias (unAlias);
        setDNIdelTitular (unDNITitular);
        setMoneda (unMoneda);
    }
    
    
    public void setMonto (int monto) {
        this.monto = monto;
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

    public int getDNIdelTitular() {
        return DNIdelTitular;
    }

    public void setDNIdelTitular(int DNIdelTitular) {
        this.DNIdelTitular = DNIdelTitular;
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
