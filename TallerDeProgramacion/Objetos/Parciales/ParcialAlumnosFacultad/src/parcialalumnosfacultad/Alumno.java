/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialalumnosfacultad;

/**
 *
 * @author Nicolas
 */
public abstract class Alumno {
    private int DNI;
    private String nombre;
    private Materia [] vectorMaterias;
    private int dimL=0;
    private int dimF;

    
    public Alumno (int unDNI, String unNombre, int unDimF ) {
        setDNI (unDNI);
        setNombre (unNombre);
        generarVectorMaterias (unDimF);
        
    }
    
    
    public void agregarMateria (Materia nMateria) {
        if ((nMateria.getNota() >= 4) && (nMateria.getNota() <=10) && (dimL < dimF)) {
            vectorMaterias [dimL] = nMateria;
            dimL++;
        }
    }
    

    private boolean buscarTesis () {
        boolean aux =false;
        int i=0;
        while ((i <= dimL) && (aux == false)){
            if (vectorMaterias[i].getNombre().equals ("Tesis")) {
                aux=true;
            }
            i++;
        }
        return aux;
    }
    
    public boolean estaGraduado (int N){
        boolean aux = false;
        if ((dimL == N) && (buscarTesis() == true)) {
            aux= true;
        }
        return aux;
    }
    
    public void generarVectorMaterias (int x){
        vectorMaterias = new Materia [x];
    }
    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDimF() {
        return dimF;
    }

    public void setDimF(int dimF) {
        this.dimF = dimF;
    }

    public int getDimL() {
        return dimL;
    }
    
    public String imprimirVector () {
        String aux="";
        int i;
        for (i=0; i < dimL; i++) {
            aux += vectorMaterias[i].toString() + "\n";
        }
        return aux;
    }
    
    public  String toString(){
        String aux;
        aux = "DNI: " + getDNI() + " Nombre: " + getNombre() + "\n"
                + "Materias Aprobadas: " + "\n"+ imprimirVector() + "\n"; 
        return aux;
    }
        
    
}
