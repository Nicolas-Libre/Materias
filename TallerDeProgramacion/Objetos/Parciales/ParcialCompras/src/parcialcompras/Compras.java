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
public abstract class Compras {
    private int numero;
    private Producto []vectorProdComprados;
    private int dimL=0;
    private int dimF;

    public Compras (int unNumero, int cantProductos) {
        setNumero (unNumero);
        vectorProdComprados = new Producto [cantProductos];
        setDimF(cantProductos);
    }
    
    
    public void agregarProducto (Producto p) {
        if (getDimL() < getDimF()) {
            vectorProdComprados [dimL] = p;
            dimL++;
        }
    }
    
    public double obtenerPrecioCompra () {
        double aux=0;
        
        int i;
        for (i=0; i < dimL; i++) {
            aux+= vectorProdComprados [i].getPrecio();
        }
        
        return (aux + (dimL * 0.21));  
    }
    
    public int getDimL() {
        return dimL;
    }

    public int getDimF() {
        return dimF;
    }

    private void setDimF(int dimF) {
        this.dimF = dimF;
    }
    
    
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public String imprimirVector () {
        String aux;
        aux = "Productos:" + "\n";
        int i;
        for (i=0; i <getDimL(); i++) {
            aux += vectorProdComprados [i].toString() + "\n";
        }
        return aux;
    }
    
    public String toString () {
        String aux;
        aux = "Numero de compra: " + getNumero() + "\n" +
                this.imprimirVector() + "\n" + 
                "Precio a Pagar: " + this.obtenerPrecioCompra();
    
        return aux;
    }
}
