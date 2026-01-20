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
public class Profesional extends Membresia {

    public Profesional(String nombre, String fecha, int J) {
        super(nombre, fecha, J);
    }
    
    public Jugador obtenerMejorJugador(){
        int i;
        Jugador aux=null;
        int maxApuestas=0;
        for (i=0; i< getDimL(); i++){
            if ( this.retornarJugador(i).getCantApuestasGanadas() > maxApuestas ){
                maxApuestas = this.retornarJugador(i).getCantApuestasGanadas();
                aux = this.retornarJugador(i);
            }
        }
        return aux;
    }
    
   public String toString(){
       String aux = super.toString();
       return aux;
   }
}
