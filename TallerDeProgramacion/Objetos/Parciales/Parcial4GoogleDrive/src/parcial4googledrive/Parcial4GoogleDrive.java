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
public class Parcial4GoogleDrive {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Tradicional trad = new Tradicional ("220","la plata", "robamos", 22, 3);
        Digital dig = new Digital ("google", "ellos roban", 14,2);
        
        Cuenta c1 = new Cuenta (3,"nico",46,"dolares");
        Cuenta c2 = new Cuenta (2,"Brisa",28,"dolares");
        Cuenta c3 = new Cuenta (32,"Anita",98,"pesos");
        Cuenta c4 = new Cuenta (1,"Pedro",46,"dolares");
        Cuenta c5 = new Cuenta (12,"Wancho",6,"pesos");
        Cuenta c6 = new Cuenta (333,"Palme",31,"pesos");
        
        trad.agregarCuenta(c1);
        trad.agregarCuenta(c2);
        trad.agregarCuenta(c3);
        
        dig.agregarCuenta(c4);
        dig.agregarCuenta(c5);
        dig.agregarCuenta(c6);
        System.out.println(c1.toString());
        trad.depositarDinero2(3, 1000);
        System.out.println(c1.toString());
        
        Cuenta auxC= dig.obtenerCuenta(12);
        System.out.println(auxC.toString());
        
        boolean aux = trad.puedeRecibirTarjeta(3);
        if (aux == true) {
            System.out.println("El cbu 1 ingresado puede recibir la tarjeta");
        }
        else
            System.out.println("El cbu 1 ingresado NO puede recibir la tarjeta");
        boolean aux2 = dig.puedeRecibirTarjeta(12);
        if (aux2 == true) {
            System.out.println("El cbu 2 ingresado puede recibir la tarjeta");
        }
        else
            System.out.println("El cbu 2 ingresado NO peude recibir la tarjeta");
    }
    
}
