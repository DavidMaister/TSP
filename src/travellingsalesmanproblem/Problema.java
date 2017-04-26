/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travellingsalesmanproblem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Donde se describe el problema a resolver.
 * Contiene varios metodos para declarar y obtener datos del problema
 * @author david
 */
public class Problema {
    
    private static ArrayList<Ciudad> listaCiudades;
    private static double[][] matrizDistancias;
    
    /**
     * Contructor.
     * Se inicia un araylist donde se van a contener las ciudades
     * y se inicia la matriz de distancias
     * @param n numero de ciudades del problema.
     */
    Problema(int n){
        listaCiudades = new ArrayList<>();
        matrizDistancias = new double[n][n];
    }

    /**
     * Lee las ciudades del problema y genera la matriz de distancias.
     * 
     * @param scanner Variable que lee los datos
     * @return Devuelve la referencia del objeto Problema que se crea
     */
    public static Problema leerCiudades(Scanner scanner){
        Problema problema;
        int n;
        //leer numero de ciudades
        //System.out.println("Introdude numero de ciudades de tu problema: ");
        n = scanner.nextInt();
        
        
        problema = new Problema(n);
        for(int i=0; i<n; i++){
            //leer datos de ciudad y añadirla a lista
            Ciudad ciudad = new Ciudad();
            ciudad.setEtiqueta(scanner.next());
            ciudad.setPosicion(scanner.nextInt(), scanner.nextInt());
            listaCiudades.add(ciudad);
        }
            //rellenar contenido de matrizDistancias
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    matrizDistancias[i][j] = listaCiudades.get(i).distanciaEuclidea(listaCiudades.get(j));
                } 
            }
            
        return problema;
    }
    
    /**
     * Devuelve numero de ciudades
     * @return Devuelve un entero, representa la dimension de la matriz de distancias
     */
    public int getNumeroCiudades(){
        return matrizDistancias.length;
    }
    
    /**
     * Muestra por pantalla la matriz de distancias.
     * 
     */
    public void getMatrizDistancias(){
        for(int i = 0; i < getNumeroCiudades(); i++){
            for(int j = 0; j < getNumeroCiudades(); j++){
                System.out.print(" "+matrizDistancias[i][j]);
            }
            System.out.println();
        }
    }
    
    /**
     * Devuelve la ciudad que se encuentra en la posicion dada
     * @param pos entero que hace referencia a la posicion en el arraylist
     * @return devuelve un objeto Ciudad 
     */
    public Ciudad getCiudad(int pos){
        Ciudad ciudad;
        return listaCiudades.get(pos);
    }
    
    /**
     * Obtener la distancia entre dos posiciones.
     * pos1 y pos2 son las coordenadas de la matriz distancia
     * @param pos1 entero que indica el numero de fila dentro de la matriz distancias
     * @param pos2 entero que indica la columna de matriz distancias
     * @return devuelve una variable double que es la distancia euclidea entre dos ciudades
     */
    public double getDistancia(int pos1, int pos2){
    
        return matrizDistancias[pos1][pos2];
    }
    
    /**
     * Calcula el coste de una ruta
     * @param ruta  Ruta a la que se le quiere calcular el coste
     * @return devuelve el coste, variable double
     */
    public double coste(Ruta ruta){
        double distancia = 0;
        
        for(int i = 0; i < ruta.getNumeroCiudades() - 1; i++){
            distancia = distancia + getDistancia(ruta.getCiudad(i), ruta.getCiudad(i + 1));
        }
        distancia = distancia + getDistancia(ruta.getCiudad(ruta.getNumeroCiudades() -1), ruta.getCiudad(0));
        return distancia;
    }
}
