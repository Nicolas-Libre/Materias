/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial5googledrive;

/**
 *
 * @author Nicolas
 */
public class Parcial5GoogleDrive {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        VIP viaipi = new VIP ("caca", "12/9", 3, 25);
        Profesional pro = new Profesional ("caconaaa", "6/8",2);
        
        Jugador j1 = new Jugador ("nico", "rodri");
        Jugador j2 = new Jugador ("Bri", "amor");
        Jugador j3 = new Jugador ("pedro", "crack");
        Jugador j4 = new Jugador ("ani", "crackisima");
        
        viaipi.agregarJugador(j1);
        viaipi.agregarJugador(j2);
        
        
        pro.agregarJugador(j4);
        pro.agregarJugador(j3);
        
        Jugador aux = viaipi.obtenerMejorJugador();
       // if (aux!=null){
         //   System.out.println(aux.toString());
        //}
        
        viaipi.buscarYAumentar(5, "nico", "rodri");
        viaipi.buscarYAumentar(5, "nico", "rodri");
        viaipi.buscarYAumentar(11, "Bri", "amor");
        Jugador aux2 = viaipi.obtenerMejorJugador();
        //if (aux2!=null){
          //  System.out.println(aux2.toString());
        //}
        
        pro.buscarYAumentar(4, "ani", "crackisima");
        pro.buscarYAumentar(8, "pedro", "crack");
        pro.buscarYAumentar(8, "pedro", "crack");
        System.out.println(viaipi.toString());
        System.out.println("--------------------------------------------------");
        System.out.println(pro.toString());
        
        
        
        
        
        
    }
    
}
