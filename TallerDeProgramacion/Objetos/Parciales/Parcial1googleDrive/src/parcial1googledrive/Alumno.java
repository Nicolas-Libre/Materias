/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial1googledrive;

/**
 *
 * @author Nicolas
 */
public abstract class Alumno {
    private int dni;
    private String nombre;
    private Materia [] vecMateriasAprobadas; 
    private int dimF;
    private int dimL=0;

    
    
    public Alumno (int dni, String nombre, int N) {
        setDni(dni);
        setNombre(nombre);
        vecMateriasAprobadas = new Materia [N];
        dimF=N;
    }
    
    public void agregarMateriaAprobada (Materia mat){
        if (dimL < dimF) {
            vecMateriasAprobadas [dimL] = mat;
            dimL++;
        }
    }
    
    private boolean buscarTesis (){
        int i=0;
        boolean ok=false;
        while ((ok==false) && (i < dimL)) {
            if (vecMateriasAprobadas[i].getNombre().equals("Tesis")) {
                ok =true;
            }
            else 
                i++;
        }
        return ok;
    }
    
    public boolean estaGraduado (int N) {
        boolean ok;
        if ((this.buscarTesis()==true) && (dimL >= N)) {
            ok=true;
        }
        else
            ok=false;
        return ok;
    }
    
    public String imprimirVector() {
        int i;
        String aux="Materias Aprobadas " + "\n";
        for (i=0;i<dimL;i++) {
            aux+= vecMateriasAprobadas[i].toString() + "\n";
        }
        return aux;
    }
    
    public String toString() {
        String aux= "Dni: " + getDni() + ", Nombre: " + getNombre() + "\n" 
                    + this.imprimirVector();
        if (this.estaGraduado(4) == true ){
            aux += "Esta Graduado.";
        }
        else
            aux += "No esta graduado.";
        return aux;
    }
    
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    
    
}
