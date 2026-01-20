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
public class ParcialBanco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BancoTradicional BT = new BancoTradicional ("caca", 3, "la plata", "colitis");
        
        Cuenta c1 = new Cuenta (22, "nikito", 12, "dolares");
        Cuenta c2 = new Cuenta (20, "ccona", 18, "pesos");
        
        BT.agregarCuenta (c1);
        
        BT.depositarDinero(20, 9999);
        
        //System.out.println(BT.puedeRecibirTarjeta(22));
        BT.agregarCuenta (c2);
        BT.depositarDinero (20, 100000);
        
        //System.out.println(BT.puedeRecibirTarjeta(20));
        
        BancoDigital BS = new BancoDigital ("kaka", 2, 3, "BS AS");
        
        Cuenta bsc1 = new Cuenta (2, "brisa", 12, "dolares");
        Cuenta bsc2 = new Cuenta (4, "la mejor", 18, "pesos");
        Cuenta bsc3 = new Cuenta (0,"",0,"");
        
        BS.agregarCuenta (bsc1);
        BS.depositarDinero (2, 5);
        //System.out.println(BS.puedeRecibirTarjeta (2));
        
        BS.agregarCuenta (bsc2);
        BS.depositarDinero (4, 250000);
        //System.out.println(BS.puedeRecibirTarjeta (4));
        
        System.out.println(BT.puedeRecibirTarjeta (22));
        System.out.println(BT.puedeRecibirTarjeta (20));
        System.out.println(BS.puedeRecibirTarjeta (2));
        System.out.println(BS.puedeRecibirTarjeta (4));
        
        
    }
    
}
