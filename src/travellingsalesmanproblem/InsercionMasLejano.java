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
public class InsercionMasLejano {
    
    private Problema problema;
    
    public InsercionMasLejano(Problema p){
        problema = p;
    }
    
    
    /**
     * Obtiene la mejor ruta segun la heuristica de insercion del mas lejano.
     * Se cogen tres ciudades lo mas lejanas posibles, y se van añadiendo 
     * las ciudades cuya distancia minima a cualquier ciudad  de la ruta es
     * maxima. La posicion de insertar la ciudad en la ruta es haciendo que el
     * impacto en el coste de la ruta sea el menor posible
     * @return Devuelve la ruta que ha obtenido como mejor ruta.
     */
    public Ruta obtenerMejorRuta(){
   
        double distanciaMinimaMaxima;
        double distanciaMinima;
        double delta, incrementoMinimo;
        int posIncrementoMinimo = -1;
        int ciudadDistanciaMinimaMaxima = -1;
        Ruta ruta = obtenerTrianguloMasGrande();
        Ruta mejorRuta = new Ruta(problema.getNumeroCiudades());
        //añadimos ciudad mas al norte, a la derecha y a la izquierda
        mejorRuta.añadirCiudad(ruta.getCiudad(0));
        mejorRuta.añadirCiudad(ruta.getCiudad(1));
        mejorRuta.añadirCiudad(ruta.getCiudad(2));
        
        //bucle hasta que la ruta no este completa
        while(mejorRuta.getNumeroCiudades()< problema.getNumeroCiudades()){
            
            distanciaMinimaMaxima = Double.NEGATIVE_INFINITY;
            
            for(int i = 0; i < problema.getNumeroCiudades() ; i++){ 
                if(mejorRuta.contains(i) == false){     //recorremos solo ciudades no visitadas
                    distanciaMinima = Double.POSITIVE_INFINITY; 
                    for(int j = 0; j < mejorRuta.getNumeroCiudades(); j++){
                        if(problema.getDistancia(i, mejorRuta.getCiudad(j))  < distanciaMinima){    //calculamos la distancia minima
                            distanciaMinima = problema.getDistancia(i, mejorRuta.getCiudad(j));     //a las otras ciudades de la ruta
                        }   
                    }
                    if(distanciaMinima > distanciaMinimaMaxima){    //aquella ciudad con distancia minima la mayor de todas
                        distanciaMinimaMaxima = distanciaMinima;//sera la que se introduzca a la ruta
                        ciudadDistanciaMinimaMaxima = i;
                    }
                    
                }
            }
            //una vez sabemos la ciudad que vamos a meter, la introducimos en la posicion
            //que menos coste suponga en la ruta
            
            incrementoMinimo = Double.POSITIVE_INFINITY;
            for(int j = 0; j < mejorRuta.getNumeroCiudades() - 1; j++){     //comprobamos el incremento de la ruta si se insertara en cada posicion posible
                delta = problema.getDistancia(ciudadDistanciaMinimaMaxima, mejorRuta.getCiudad(j)) + problema.getDistancia(ciudadDistanciaMinimaMaxima, mejorRuta.getCiudad(j + 1)) 
                - problema.getDistancia(mejorRuta.getCiudad(j), mejorRuta.getCiudad(j + 1));
                //el incremento sera lo que varia el coste de un enlace entre dos ciudades, al insertar una ciudad entre las dos ciudades
                if(delta < incrementoMinimo){
                    incrementoMinimo = delta;
                    posIncrementoMinimo = j + 1;
                }
            }
            
            mejorRuta.añadirCiudad(ciudadDistanciaMinimaMaxima, posIncrementoMinimo);   
        }
        return mejorRuta;
    }
    
    
    /**
     * Obtener cual es el triangulo formado por tres ciudades mas grande.
     * Usaremos la ciudad mas arriba, mas a la derecha y mas a la izquierda
     * @return Devuelve una ruta de tres ciudades 
     */
    private Ruta obtenerTrianguloMasGrande(){
        
        
        //obtenemos las tres ciudades mas alejadas
        double posicionNorte = Double.NEGATIVE_INFINITY;
        double posicionDerecha = Double.NEGATIVE_INFINITY;
        double posicionIzquierda = Double.POSITIVE_INFINITY;
        
        int ciudadNorte = 0;
        int ciudadDerecha = 0;
        int ciudadIzquierda = 0;
        Ruta rutaTriangulo = new Ruta(3);
        
        for(int i = 0; i < problema.getNumeroCiudades(); i++){
            if(problema.getCiudad(i).getY() > posicionNorte){   //comprobamos si una ciudad esta mas al norte
                posicionNorte = problema.getCiudad(i).getY(); //actualizamos la posicion que esta mas al norte
                ciudadNorte = i;
            }
            
            else if(problema.getCiudad(i).getX() > posicionDerecha){    //comprobamos si una ciudad esta mas al este
                posicionDerecha = problema.getCiudad(i).getX();         //actalizamos la poscion
                ciudadDerecha = i;
            }
            
            else if(problema.getCiudad(i).getX() < posicionIzquierda){  //comprobamos si una ciudad esta mas al oeste
                posicionIzquierda = problema.getCiudad(i).getX();
                ciudadIzquierda = i;
            }
        }
        
        rutaTriangulo.añadirCiudad(ciudadIzquierda);
        rutaTriangulo.añadirCiudad(ciudadNorte);
        rutaTriangulo.añadirCiudad(ciudadDerecha);
        return rutaTriangulo;
    }
    
}
