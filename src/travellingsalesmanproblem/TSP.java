/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travellingsalesmanproblem;

import java.util.Scanner;

/**
 *  Clase principal del proyecto donde se encuentra el main
 * @author david
 */
public class TSP {

    /**
     * main donde se desarrolla la actividad principal del programa. 
     * Desde aquí se llaman a los diferentes métodos de otras clases.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //creamos el problema
        //introducimos las ciudades y sus coordenadas
        Problema problema;
        Scanner scanner = new Scanner(System.in);
        problema = Problema.leerCiudades(scanner);
      
        
        
        
        
       
        Ruta ruta = null;
        int algoritmo = 1;  //inicializamos en el caso por defecto. el de vecino mas cercano
        
        //elegimos el algoritmo si se especifica
        if(args.length > 1 && (args[0].compareTo("-algo") == 0)){
            algoritmo = Integer.parseInt(args[1]);
        }
        long time_start, time_end;
        time_start = System.currentTimeMillis();
        
        switch(algoritmo){
            case 1:
                //este es el caso por defecto
                HeuristicaVecinoMasCercano heuristica = new HeuristicaVecinoMasCercano(problema);
                ruta = heuristica.obtenerMejorRuta();
            break;
            
            case 2:
                //caso de insercion mas economica
                InsercionMasEconomica heuristica2 = new InsercionMasEconomica(problema);
                ruta =  heuristica2.obtenerMejorRuta();    
            break;
            
            case 3:
                //caso de insercion mas lejano
                InsercionMasLejano heuristica3 = new InsercionMasLejano(problema);
                ruta = heuristica3.obtenerMejorRuta();
            break;
            
            case 4:
                //caso de intercambio de aristas
                IntercambioAristas heuristica4 = new IntercambioAristas(problema);
                ruta = heuristica4.obtenerMejorRuta();
                break;
            
            case 5:
                //caso montecarlo
                MonteCarlo heuristica5 = new MonteCarlo(problema);
                ruta = heuristica5.obtenerMejorRuta();
            
            break;
        }
        
        
        
        for(int j = 0; j < args.length; j++){
            String opcion = args[j];
            Ciudad ciudad = new Ciudad();
             switch(opcion){
        
                case "-solucion":
                    //System.out.println("Esta es la solucion del problema: ");
                    for(int i = 0; i < problema.getNumeroCiudades(); i++){
                            ciudad = problema.getCiudad(ruta.getCiudad(i));
                            System.out.println(""+ciudad.getX()+"  "+ciudad.getY());
                        }
                break;
                
                case "-ruta":
                    //System.out.println("Esta es la ruta seguida: ");
                    for(int i = 0; i < problema.getNumeroCiudades(); i++){
                            ciudad = problema.getCiudad(ruta.getCiudad(i));
                            System.out.println(""+ciudad.getEtiqueta());
                    }
                break;
                
                case "-coste":
                    System.out.println("MEJOR SOLUCION: "+problema.coste(ruta));
                break;
                
            }
        }
        time_end = System.currentTimeMillis();
        System.out.println("El tiempo de ejecución es " +
            ( time_end - time_start ) +" milisegundos");
        
    }
    
}
