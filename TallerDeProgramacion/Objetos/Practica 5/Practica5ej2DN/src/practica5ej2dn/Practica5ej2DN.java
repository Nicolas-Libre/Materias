/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5ej2dn;

/**
 *
 * @author Nicolas
 */
public class Practica5ej2DN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Estacionamiento esta= new Estacionamiento ("shell", "59 y 18", 8.00, 12.00, 3,3);
        Auto au1 = new Auto ("Nico", 063);
        Auto au2 = new Auto ("Pedro", 072);
        Auto au3 = new Auto ("Anita", 642);
        Auto au4 = new Auto ("Brisa", 321);
        Auto au5 = new Auto ("Wancho", 856);
        Auto au6 = new Auto ("Oso", 128);
  
        esta.agregarAuto(au1, 2, 2);
        esta.agregarAuto(au2, 1, 1);
        esta.agregarAuto(au3, 3, 3);
        esta.agregarAuto(au4, 2, 2);
        esta.agregarAuto(au5, 1, 3);
        esta.agregarAuto(au6, 3, 1);
        
        System.out.println(esta.toString());
        System.out.println("Autos en la plaza 1 = " + esta.autosEnPlaza(1));
    }
    
}
