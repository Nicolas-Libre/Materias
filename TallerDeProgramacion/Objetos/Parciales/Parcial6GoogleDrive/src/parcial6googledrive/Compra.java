/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial6googledrive;

/**
 *
 * @author Nicolas
 */
public class Compra {
    private int numero;
    private Fecha fecha;
    private Producto [] vecProductos;
    private int dimF;
    private int dimL=0;
    
    public Compra(int numero, int dia, int mes, int año, int N) {
        setNumero(numero);
        fecha = new Fecha (dia,mes,año);
        vecProductos = new Producto [N];
        dimF=N;
    }

    
    public void agregarProducto (Producto prod){
        if (dimL<dimF) {
            vecProductos[dimL] = prod;
            dimL++;
        }
    }

    public double devolverPrecioFinal () {
        int i;
        double aux=0;
        for (i=0;i<dimL;i++){
            aux += vecProductos[i].precioFinal();
        }
        return aux;
    }
    
    
    
    public String imprimirVector(){
        String aux="";
        int i;
        for (i=0; i<dimL;i++){
            aux += vecProductos[i].toString() + ", precio Final = " + vecProductos[i].precioFinal() +"\n";
        }
        return aux;
    }
    
    public String toString () {
        String aux= "Numero de compra= " + getNumero() + ", Fecha= " + getFecha().toString() + "\n"
                    +   this.imprimirVector() + "Precio final de la compra = " + this.devolverPrecioFinal();
        return aux;
    }
    
    
    public boolean abonableEnCuotas() {
        boolean aux;
        if (this.devolverPrecioFinal() > 100000) {
            aux = true;
        }
        else
            aux=false;
        return aux;
    }
    
    public int getDimF() {
        return dimF;
    }

    public int getDimL() {
        return dimL;
    }
    
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    

    public Fecha getFecha() {
        return fecha;
    }
    
    
    
}
