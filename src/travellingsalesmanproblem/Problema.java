/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travellingsalesmanproblem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author david
 */

public class Problema {
    
    private static ArrayList<Ciudad> listaCiudades;
    private static double[][] matrizDistancias;
    
    Problema(int n){
        listaCiudades = new ArrayList<>();
        matrizDistancias = new double[n][n];
    }

    
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
    
    
    public int getNumeroCiudades(){
        return matrizDistancias.length;
    }
    
    public void getMatrizDistancias(){
        for(int i = 0; i < getNumeroCiudades(); i++){
            for(int j = 0; j < getNumeroCiudades(); j++){
                System.out.print(" "+matrizDistancias[i][j]);
            }
            System.out.println();
        }
    }
    
    public Ciudad getCiudad(int pos){
        Ciudad ciudad;
        return listaCiudades.get(pos);
    }
    
    public double getDistancia(int pos1, int pos2){
    
        return matrizDistancias[pos1][pos2];
    }
    
    public double coste(Ruta ruta){
        double distancia = 0;
        
        for(int i = 0; i < ruta.getNumeroCiudades() - 1; i++){
            distancia = distancia + getDistancia(ruta.getCiudad(i), ruta.getCiudad(i + 1));
        }
        distancia = distancia + getDistancia(ruta.getCiudad(ruta.getNumeroCiudades() -1), ruta.getCiudad(0));
        return distancia;
    }
}
