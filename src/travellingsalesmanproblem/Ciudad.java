/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travellingsalesmanproblem;

/**
 * Representa a una ciudad con sus datos miembro.
 * @param coordx representa la coordenada x.
 * @param coordy representa la coordenada y.
 * etiqueta referencia a un identidicador de la ciudad, por tanto, dos ciudades no pueden tener misma etiqueta
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
    
    
    
    public double getY(){
        return coordy;
    }
    
    public String getEtiqueta(){
        return etiqueta;
    }
    
    
    public void setPosicion(double x, double y){
        coordx = x;
        coordy = y;
    }
    public void setEtiqueta(String etiq){
        etiqueta = etiq;
    }
    
    public double distanciaEuclidea(Ciudad ciudad){
        double distancia;
        distancia = Math.sqrt((coordx-ciudad.coordx)*(coordx-ciudad.coordx) + (coordy-ciudad.coordy)*(coordy-ciudad.coordy));
        return distancia;
    }
    
}
