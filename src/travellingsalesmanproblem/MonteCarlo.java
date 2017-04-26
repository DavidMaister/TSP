/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travellingsalesmanproblem;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Obtiene una ruta segun el metodo de MonteCarlo.
 * Estas rutas se realizan de forma aleatoria y se realizan muchas
 * iteraciones y se queda con la que menos coste suponga.
 * @author david
 */
public class MonteCarlo {
    
    
   private Problema problema;
   
   MonteCarlo(Problema p){
       problema = p;
   }
   
   
   /**
    * Obtiene ruta mediante el modelo MonteCarlo.
    * Se prueban 10000 rutas aleatorias y nos quedamos
    * con la mejor ruta que obtengamos
    * @return devolvemos la ruta de menor coste
    */
   public Ruta obtenerMejorRuta(){
       Ruta mejorRuta = null;
       int k = 10000; //numero de iteraciones
       ArrayList<Integer> ciudades = new ArrayList<>();
       double costeMinimo = Double.POSITIVE_INFINITY;
       
       for(int i = 0; i < problema.getNumeroCiudades(); i++){
           ciudades.add(i); //generamos un arraylist que contenga todas las ciudades
       }
       for(int j = 0; j < k; j++){  //todas las veces que probamos
           
           Collections.shuffle(ciudades);   //generamos un array aleatorio
       
           
           Ruta rutaActual = new Ruta(ciudades.size());
           for(int z = 0; z < problema.getNumeroCiudades(); z++){
               rutaActual.añadirCiudad(ciudades.get(z));       //añadimos las ciudades a la ruta
           }
           if(problema.coste(rutaActual) < costeMinimo){
               costeMinimo = problema.coste(rutaActual);
               mejorRuta = rutaActual;
           }   
       }
       return mejorRuta;
    
   }
 






   
}
