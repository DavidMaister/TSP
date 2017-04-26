/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travellingsalesmanproblem;

/**
 * Obtiene una ruta mediante el intercambio de aristas.
 * 
 * @author david
 */
public class IntercambioAristas {
    
    private Problema problema;
    
    IntercambioAristas(Problema p){
       problema = p;
   }
    
    
    /**
     * Metodo principal para calcular la mejor ruta segun el intercambio de aristas.
     * Esta clase inicia una ruta segun la heuristica del vecino mas cercano e 
     * implementa la busqueda de posibles cambios que mejoren la ruta 
     * @return devuelve la mejor ruta obtenida
     */
    public Ruta obtenerMejorRuta(){
        
        //iniciamos ruta por vecino mas cercano
        HeuristicaVecinoMasCercano heuristica = new HeuristicaVecinoMasCercano(problema);
        Ruta ruta = null;
        ruta = heuristica.obtenerMejorRuta();
        
        //iniciamos la busqueda para mejorar la ruta
        int i, j;
        double minimoCambio, cambio;
        int mini = 0, minj = 0;
        int nCiudades = problema.getNumeroCiudades();
        do{
            
            minimoCambio = 0;
            for( i = mini +1; i< nCiudades-3; i++) {
                for(j = i+2; j< nCiudades - 1; j++) {
                    cambio = problema.getDistancia(ruta.getCiudad(i),ruta.getCiudad(j)) + problema.getDistancia(ruta.getCiudad(i+1), ruta.getCiudad(j+1))
                    - problema.getDistancia(ruta.getCiudad(i),ruta.getCiudad(i+1)) - problema.getDistancia(ruta.getCiudad(j),ruta.getCiudad(j+1));
                    if (minimoCambio > cambio) {
                        minimoCambio = cambio;
                        mini = i;
                        minj = j;   
                    }
                }
            }
            if(minimoCambio < 0)
                ruta=operacionIntercambio(ruta, mini, minj);
            
            
         
        }   while (minimoCambio < 0);
        
        return ruta;
    }
    
    
    
    
    /**
     * Se hace el intercambio de las aristas.
     * @param ruta Ruta sobre la que se aplica
     * @param i posicion de la primera arista a intercambiar
     * @param j posicion de la segunda lista a intercambiar
     * @return ruta devuelta con el cambio hecho
     */
    public Ruta operacionIntercambio(Ruta ruta,int i,int j){
        Ruta nuevaRuta = new Ruta(ruta.getNumeroCiudades()); 
        
        //la ruta se mantiene igual hasta el punto i
        int t;
        for(t = 0; t < i; t++){
        nuevaRuta.añadirCiudad(ruta.getCiudad(t));
        }
        
        //invertimos el orden de la ruta en el intervalo i, j
        int aux = j;
        for(t = t ; t <= j; t++){
            
            nuevaRuta.añadirCiudad(ruta.getCiudad( aux )); 
            aux--;
        }
        
        //la ruta se mantiene igual hasta el final
        for(t = t; t < ruta.getNumeroCiudades(); t++){
            nuevaRuta.añadirCiudad(ruta.getCiudad(t));
        }
        return nuevaRuta;
    
    }
    
}
