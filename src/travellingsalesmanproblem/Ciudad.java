/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travellingsalesmanproblem;

/**
 * Representa a una ciudad. Sus datos miembro son la coordenada x y la coordenada y, y una etiqueta que identifica a cada ciudad
 * @author david
 */
public class Ciudad {
    /**
     * @param coordx es una variable double que expresa la coordenada de la ciudad en el plano x.
     * @param coordy es una variable double que expresa la coordenada de la ciudad en el plano y.
     * @param etiqueta String que identifica a una ciudad
     * 
     */
    private double coordx;
    private double coordy;
    private String etiqueta;
    
    /**
     * Constructor.
     * Constructor que no necesita parametros. Inicia una ciudad en la posicion (0,0) y una etiqueta generica como es 'Ciudad'.
     */
    Ciudad(){
        coordx = 0;
        coordy = 0;
        etiqueta = "Ciudad";
    }
    
    /**
     * Devuelve la coordenada x de la ciudad que ejecuta el metodo
     * @return Devuelve una variable double con la coordenada x
     */
    public double getX(){
        return coordx;
    }
    
    
    /**
     * Devuelve la coordenada y de la ciudad que ejecuta el metodo
     * @return Devuelve una variable double con la coordenada y
     */
    public double getY(){
        return coordy;
    }
    
    
    /**
     * Devuelve la etiqueta de la ciudad.
     * @return Devuelve un String con la etiqueta de la ciudad
     */
    public String getEtiqueta(){
        return etiqueta;
    }
    
    /**
     * Establece la posicion.
     * 
     * @param x variable double para indicar la coordenada x
     * @param y variable y para indidcar la coordenada y
     */
    public void setPosicion(double x, double y){
        coordx = x;
        coordy = y;
    }
    
    /**
     * Establece la etiqueta
     * @param etiq String que va a ser la etiqueta de la ciudad
     */
    public void setEtiqueta(String etiq){
        etiqueta = etiq;
    }
    
    
    /**
     * Distancia euclidea entre dos ciudades
     * @param ciudad Ciudad con la que se quiere medir la distancia
     * @return devuelve variable double con la distancia entre las dos ciudades
     * La distancia euclidea calcula la linea recta que une dos ciudades
     */
    public double distanciaEuclidea(Ciudad ciudad){
        double distancia;
        distancia = Math.sqrt((coordx-ciudad.coordx)*(coordx-ciudad.coordx) + (coordy-ciudad.coordy)*(coordy-ciudad.coordy));
        return distancia;
    }
    
}
