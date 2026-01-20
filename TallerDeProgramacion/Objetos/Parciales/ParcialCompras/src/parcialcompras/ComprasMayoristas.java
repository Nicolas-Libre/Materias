/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialcompras;

/**
 *
 * @author Nicolas
 */
public class ComprasMayoristas extends Compras {
    private int CUIT;

    public ComprasMayoristas (int unNumero, int cantProductos, int unCUIT) {
        super (unNumero, cantProductos);
        setCUIT (unCUIT);
    }
    
    public int getCUIT() {
        return CUIT;
    }

    public void setCUIT(int CUIT) {
        this.CUIT = CUIT;
    }
    
    public String toString () {
        String aux = "Compra Mayorista: ";
        aux +=  super.toString() + "\n" +
                "CUIT: " + getCUIT();
    
        return aux;
    } 
}
