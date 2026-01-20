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
public class PorMayor extends Compra {
    private int CUIL;
    private String nombre;

    public PorMayor(int CUIL, String nombre, int numero, int dia, int mes, int año, int N) {
        super(numero, dia, mes, año, N);
        setCUIL(CUIL);
        setNombre(nombre);
    }

    
    public void agregarProducto(Producto prod){
        if (prod.getCantUnidades() > 6) {
            super.agregarProducto(prod);
        }
    }
    
    public double devolverPrecioFinal() {
        double aux = super.devolverPrecioFinal();
        aux =(double) (aux * 21) / 100;
        return aux;
    }
    
    public int getCUIL() {
        return CUIL;
    }

    public void setCUIL(int CUIL) {
        this.CUIL = CUIL;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    
}
