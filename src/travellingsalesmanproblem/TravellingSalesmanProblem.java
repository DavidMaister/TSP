/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travellingsalesmanproblem;

import java.util.Scanner;

/**
 *
 * @author david
 */
public class TravellingSalesmanProblem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //creamos el problema
        //introducimos las ciudades y sus coordenadas
        Problema problema;
        Scanner scanner = new Scanner(System.in);
        problema = Problema.leerCiudades(scanner);
      
        
        
        //calculamos la ruta
        HeuristicaVecinoMasCercano heuristica = new HeuristicaVecinoMasCercano(problema);
        Ruta rutaVecinoCercano = heuristica.obtenerMejorRuta();
        
        
        for(int j = 0; j < args.length; j++){
            String opcion = args[j];
            Ciudad ciudad = new Ciudad();
             switch(opcion){
        
                case "-solucion":
                    //System.out.println("Esta es la solucion del problema: ");
                    for(int i = 0; i < problema.getNumeroCiudades(); i++){
                            ciudad = problema.getCiudad(rutaVecinoCercano.getCiudad(i));
                            System.out.println(""+ciudad.getX()+"  "+ciudad.getY());
                        }
                break;
                
                case "-ruta":
                    //System.out.println("Esta es la ruta seguida: ");
                    for(int i = 0; i < problema.getNumeroCiudades(); i++){
                            ciudad = problema.getCiudad(rutaVecinoCercano.getCiudad(i));
                            System.out.println(""+ciudad.getEtiqueta());
                    }
                break;
                
                case "-coste":
                    System.out.println("MEJOR SOLUCION: "+problema.coste(rutaVecinoCercano));
                break;
                
            }
        }
        
        
        
        
    }
    
}
