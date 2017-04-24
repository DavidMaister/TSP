/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travellingsalesmanproblem;

/**
 *
 * @author david
 */
public class Ruta {
    private int nciudades;
    private int ciudades[];
    
    public Ruta(int n){
        nciudades = 0;
        ciudades = new int[n];
    }
    
    
    public int getNumeroCiudades(){
    return nciudades;
    }
    
    //Devuelve el contenido del vector ciudades[] en la posicion n.
    public int getCiudad(int i){
        return ciudades[i];    
    }
    
    boolean contains(int ciudad){
        boolean existe = false;
        for(int i = 0; i < nciudades; i++){
            if(ciudades[i] == ciudad)
                existe = true;
        }
        return existe;
    }
    
    //añade como siguiente salto a la ruta la ciudad 'ciudad'
    public void añadirCiudad(int ciudad){
        ciudades[nciudades] = ciudad;
        nciudades = nciudades + 1;
    }
    
    
}
