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
public class VIP extends Membresia {
    private double costoPermanencia;

    public VIP(String nombre, String fecha, int J, double costoPermanencia) {
        super(nombre, fecha, J);
        setCostoPermanencia (costoPermanencia);
    }

    
    @Override
    public Jugador obtenerMejorJugador(){
        int i;
        Jugador aux=null;
        int maxPuntaje=0;
        for (i=0; i< getDimL(); i++){
            if ( this.retornarJugador(i).getPuntajeTotal()> maxPuntaje ){
                maxPuntaje = this.retornarJugador(i).getPuntajeTotal();
                aux = this.retornarJugador(i);
            }
        }
        return aux;
    }
    
    public String toString(){
       String aux = super.toString();
       return aux;
   }
    public double getCostoPermanencia() {
        return costoPermanencia;
    }

    public void setCostoPermanencia(double costoPermanencia) {
        this.costoPermanencia = costoPermanencia;
    }
    
    
    
}
