/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5ej1;

/**
 *
 * @author Nicolas
 */
public class Proyecto {
    private String nombre;
    private int codigo;
    private String nomDirector;
    private Investigador [] vectorInves = new Investigador [50]; 
    private int dimL=0;

    public Proyecto(String nombre, int codigo, String nomDirector) {
       setNombre(nombre);
       setCodigo(codigo);
       setNomDirector (nomDirector);
    }
    
    public void otorgarTodos (String xNombre){
        int i;
        
        for (i=0; i < 50; i++){
            if (this.vectorInves [i].getNombre() == xNombre) {
                this.vectorInves[i].otorgarCadaSubsidio();
        
              
            }
        }
    }
    
    public double dineroTotalOtorgado () {
        int i;
        
        double aux=0;
        for (i=0; i < (getDimL()+1); i++){
            
                if (vectorInves[i].getCantSubsidios(getDimL()).isFueOtorgado() == true) {
                    aux = aux + vectorInves[i].getCantSubsidios(getDimL()).getMontoPedido();
                }
                vectorInves[i].setDimL (vectorInves[i].getDimL() + 1);
            
            vectorInves[i].setDimL (0);
        }
        return aux;
    }
    
    public int getDimL() {
        return dimL;
    }

    public void setDimL(int dimL) {
        this.dimL = dimL;
    }

    public void agregarInvestigaor (Investigador unInvestigador) {
        if (vectorInves[getDimL()] == null){
            vectorInves[getDimL()] = unInvestigador;
        }
        dimL = dimL +1;
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomDirector() {
        return nomDirector;
    }

    public void setNomDirector(String nomDirector) {
        this.nomDirector = nomDirector;
    }
    
    public void imprimirVector(){
        int i;
        for (i=0; i < dimL+1; i++) {
            System.out.println(this.vectorInves[i].toString());
        }
}
    
    
    public String toString (){
        String aux;
        
        aux = "Nombre del Proyecto: " + getNombre() + 
                ", codigo: " + getCodigo() + 
                ", nombre del Director: " + getNomDirector() +
                ", el dinero total es: " + dineroTotalOtorgado();
                
        return aux;
    
    }     
    
}
