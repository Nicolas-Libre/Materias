/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4ej5;

/**
 *
 * @author Nicolas
 */
public class Triangulo extends Figura {
    private double lado1;
    private double lado2;
    private double lado3;
    
    public Triangulo (String CR, String CL, double unLado1, double unLado2, double unLado3){
        super (CR,CL);
        setLado1 (unLado1);
        setLado2 (unLado2);
        setLado3 (unLado3);
    }
    
    public double calcularPerimetro () {
        double aux = (getLado1() + getLado2() + getLado3());
        return aux;
    }
    public double calcularArea () {
        double aux = (this.calcularPerimetro() / 2);
        double auxTotal = ((aux *(aux - getLado1()) * (aux - getLado2()) * (aux - getLado3())));
        return Math.sqrt(auxTotal);  
    }
    
    public double getLado1() {
        return lado1;
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    public double getLado3() {
        return lado3;
    }

    public void setLado3(double lado3) {
        this.lado3 = lado3;
    }
      
    public String toString () {
        String aux = "Area: " + this.calcularArea()
                    + " Perimetro: " + this.calcularPerimetro();
        return aux;
        
    }
        
    public String auxToString(){
        String aux = " Soy Triangulo";
        return aux;
    }
    
}
