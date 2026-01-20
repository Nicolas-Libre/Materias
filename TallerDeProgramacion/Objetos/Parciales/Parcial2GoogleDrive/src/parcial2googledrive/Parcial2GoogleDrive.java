/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2googledrive;

/**
 *
 * @author Nicolas
 */
public class Parcial2GoogleDrive {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Persona nico = new Persona ("nico", 22,20);
        Persona bri = new Persona ("bri", 46,21);
        Persona wancho = new Persona ("wancho", 22,17);
        Persona sofi = new Persona ("sofi", 12,15);
        
        Pareja par1 = new Pareja (nico,bri, "Cualquiera");
        Pareja par2 = new Pareja (wancho,sofi, "futbol");
        
        Concurso con = new Concurso (2);
        con.agregarPareja(par1);
        con.agregarPareja(par2);
        System.out.println("La pareja con mas edad es la siguiente " + "\n"
                +con.masDifEdad().toString());
        
        
        
    }
    
}
