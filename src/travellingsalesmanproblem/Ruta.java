/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travellingsalesmanproblem;

/**
 * Clase en la que se define una ruta.
 * Los datos miembro son:
 * int nciudades que indica el numero de ciudades de la ruta.
 * int ciudades[] es un vector de enteros donde en cada posicion se encuentra un entero que representa una ciudad.
 * Cada ciudad se representa con un numero entero, este numero es el mismo que la posicion que tiene en la matriz de distancias
 * @author david
 */
public class Ruta {
    private int nciudades;
    private int ciudades[];
    
    
    /**
     * Contructor. n especifica el numero de ciudades que va a haber
     * @param n 
     */
    public Ruta(int n){
        nciudades = 0;
        ciudades = new int[n];
    }
    
    /**
     * Obtiene el numero de ciudades de la ruta.
     * 
     * @return Devuelve un entero del numero de ciudades.
     */
    public int getNumeroCiudades(){
    return nciudades;
    }
    
    /**
     * Devuelve el contenido del vector ciudades[] en la posicion i.
     * @param i Variable entera. Posicion de la ciudad a la que se quiere acceder
     * @return Devuelve un entero. Éste es la ciudad que hay en la posicion i.
     */
    public int getCiudad(int i){
        return ciudades[i];    
    }
    
    
    /**
     * Comprueba si existe la ciudad
     * @param ciudad Variable entera. Ciudad que se quiera comprobar
     * @return devuelve un booleano. True significa que existe
     */
    boolean contains(int ciudad){
        boolean existe = false;
        for(int i = 0; i < nciudades; i++){
            if(ciudades[i] == ciudad)
                existe = true;
        }
        return existe;
    }
    
    /**
     * Añade como siguiente salto a la ruta la ciudad
     * @param ciudad Variable entera. Ciudad que se quiere añadir.
     */
    public void añadirCiudad(int ciudad){
        ciudades[nciudades] = ciudad;
        nciudades = nciudades + 1;
    }
    
    
    public void añadirCiudad(int ciudad, int pos){
        int aux[] = new int[ciudades.length];
        int i;
       
        
        nciudades = nciudades + 1;
        for(i = 0; i < pos; i++){
            aux[i] = ciudades[i];
        }
        aux[i] = ciudad;
        
        
        for(i = i + 1; i < nciudades; i++){
            aux[i] = ciudades[i - 1];
        }
        
        ciudades = aux;
        
    }
    
}
