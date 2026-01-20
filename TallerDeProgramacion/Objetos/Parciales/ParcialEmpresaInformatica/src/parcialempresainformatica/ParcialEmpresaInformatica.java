/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialempresainformatica;

import java.util.Arrays;

/**
 *
 * @author Nicolas
 */
public class ParcialEmpresaInformatica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Lider unLider = new Lider ("nico", 22, 100, 300, "pyton", 3,2);
        Empresa caca = new Empresa ("caca", unLider, 3);
        
        Programador p1 = new Programador ("juan", 14, 20, 100, "java");
        Programador p2 = new Programador ("brisa", 47, 30, 250, "c++");
        Programador p3 = new Programador ("roberto", 6, 10, 201, "html");
        
        caca.agregarProgramador (p1);
        caca.agregarProgramador (p2);
        caca.agregarProgramador (p3);
        
        
        
        System.out.println(caca.toString());
        
        caca.aumentarSueldoTotal ( 1000);
        System.out.println(caca.toString());
    }
    
}
