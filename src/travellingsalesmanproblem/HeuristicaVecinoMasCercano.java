/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travellingsalesmanproblem;

/**
 * Clase que implementa la heurstica del vecino mas cercano.
 * Su unico dato miembro es un objeto Problema.
 * @author david
 */
public class HeuristicaVecinoMasCercano {
    
    private Problema problema;
    
    
    public HeuristicaVecinoMasCercano(Problema p){
        problema = p;
    }
    
    
    /**
     * Obtiene la mejor ruta segun la heuristica del vecino mas cercano.
     * Prueba todas las posibles combinaciones y se queda con la mejor ruta.
     * @return Devuelve la ruta que ha obtenido como mejor ruta.
     */
    public Ruta obtenerMejorRuta(){
        Ruta mejorRuta = null;
        
        //con este bucle se prueba cada ruta empezando por una ciudad distinta y se escoge la mejor
        for(int i = 0; i < problema.getNumeroCiudades(); i++){
            Ruta rutaActual;
            rutaActual = new Ruta(problema.getNumeroCiudades());
            //empezamos por i, asi que añadimos esta ciudad la primera a la ruta
            rutaActual.añadirCiudad(i);
            int masCercano = i;
            
            
            //con estos dos bucles formamos la ruta
            for(int z = 0; z < problema.getNumeroCiudades() - 1; z++){
                //inicializamos distancia al maximo posible
                double distancia = Double.POSITIVE_INFINITY;
                for(int j = 0; j < problema.getNumeroCiudades(); j++){
                    if(j != i && rutaActual.contains(j) == false){
                        if(problema.getDistancia(rutaActual.getCiudad(z), j) < distancia){
                            masCercano = j;
                            distancia = problema.getDistancia(rutaActual.getCiudad(z), j);
                        }
                    }
                }
            rutaActual.añadirCiudad(masCercano); 
            }
            
            if(mejorRuta == null || ( problema.coste(rutaActual) < problema.coste(mejorRuta) ) ){
                mejorRuta = rutaActual;
            }
        }
        
        return mejorRuta;
    }
    
}
