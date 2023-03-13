 
package juego;

import java.util.Scanner;

public class Juego {
     Scanner sc =new Scanner(System.in);
    //Atributos
    private Dado [] dados = new Dado[5]; 
    private Jugador [] jugadores; //= new Jugador [?];
    
    //Metodos Normales.
    public void Menu(){
        inicializaciones();
        registrarJugadores();
        mostrar();
    }
    public void inicializaciones(){
        //Inicializacion de los Datos.
        for (int i=0;i<dados.length;i++) {
            dados[i] = new Dado(1, true);
        }
        //Incilizacon de los Juadores.
        System.out.println("Cuantos jugadores quieres");
        int num=sc.nextInt();
        ///Inicilizar el arreglo Jugadores.
        jugadores = new Jugador [num];  
    }
    public void registrarJugadores(){
         for (int i = 0; i < jugadores.length; i++) {
            System.out.println("El nombre del jugador");
            String nom = sc.next();
            jugadores[i] = new Jugador(nom,0);
            // System.out.println(Jugadores[i]);
         }
    }
    public void jugar(){
        
        
    }
    public void primerLanzamiento (){
        
    }
    public void segundoLanzamiento (){
        
    }
    public void mostrarPuntos(){
        
    }
    
    public void mostrar(){
        System.out.println("Jugar");
        
    }
   
    
}
