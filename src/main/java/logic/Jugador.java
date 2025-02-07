package logic;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.*;

public class Jugador {

    String nombre;
    ArrayList<Carta> cartasRepartidas;
    int puntaje;

    public Jugador(String nombre, int puntaje) {
        this.nombre = nombre;
        this.puntaje = puntaje;
        this.cartasRepartidas = new ArrayList<>();
    }

    public ArrayList<Carta> getCartasRepartidas() {
        return cartasRepartidas;
    }

    public void setCartasRepartidas(ArrayList<Carta> cartasRepartidas) {
        this.cartasRepartidas = cartasRepartidas;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje += puntaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void mostrarCartasRepartidas() {
        if (cartasRepartidas.isEmpty()) {
            System.out.println("el jugador tiro todas las cartas.");
        } else {
            System.out.println("Cartas en mano:");
            for (Carta carta : cartasRepartidas) {
                System.out.println(carta + " ." + "(" + cartasRepartidas.indexOf(carta) + ")");
            }
        }
    }

    public void setAgregarCarta(Carta cartaRemovida) {
        cartasRepartidas.add(cartaRemovida);
    }

    public void removerCartasSinTirar(Mazo mazo1) {
        while (!cartasRepartidas.isEmpty()) {
            Carta sinTirar = cartasRepartidas.remove(0);
            mazo1.devolverCartaAlMazo(sinTirar);
        }
    }

    public Carta tirarCarta(int posCarta) {
        Carta cartaTirada = cartasRepartidas.remove(posCarta);
        return cartaTirada;
    }
    /*
    public void cantarEnvido(){
        int opcion;
        while (true){
            System.out.println("ingrese la opcion que desee (en numero): \n");
            System.out.println("1. envido");
            System.out.println("2. real envido");
            System.out.println("3. falta envido");
            System.out.println("4. truco");
            System.out.println("5. tirar carta");
            System.out.println("6. me voy al mazo");
            Scanner scanner = new Scanner(System.in);
            opcion=scanner.nextInt();
        // Verificar si el número es válido 
            if (opcion >= 1 && opcion <= 6) {
                break;  // Salir del bucle si la opción es válida
            } else {
                System.out.println("Opción inválida. Debes ingresar el numero 1,2,3,4,5 o 6.");
            }
        }    
        switch(opcion){
            case 1:
                responderEnvidoSolo();
            case 2:
                responderRealEnvido();
            case 3:
                responderFaltaEnvido();
            case 4:
                responderTruco();
            case 5:
                
                
            
            default:
                
        }

    }
    public void responderEnvidoSolo(){
        int opcion;
        while (true) {
            System.out.println("ingrese la opcion que desee (en numero): \n");
            System.out.println("1. quiero");
            System.out.println("2. no quiero");
            System.out.println("3. envido");
            System.out.println("4. real envido");
            System.out.println("5. falta envido");
            Scanner scanner = new Scanner(System.in);
            opcion=scanner.nextInt();
            // Verificar si el número es válido 
            if (opcion >= 1 && opcion <= 5) {
                break;  // Salir del bucle si la opción es válida
            } else {
                System.out.println("Opción inválida. Debes ingresar el numero 1,2,3,4 o 5.");
            }
        }    
        switch(opcion){
            case 1:
                //determinarGanador
            case 2:
                //otorgarle un punto al jugador que canto envido
            case 3:    
                responderEnvidoEnvido();
            case 4:
                responderEnvidoRealEnvido();
            case 5:
                responderFaltaEnvido();
        }
    }
    
    
    public void responderRealEnvido(){
        int opcion;
        while (true) {
            System.out.println("ingrese la opcion que desee (en numero): \n");
            System.out.println("1. quiero");
            System.out.println("2. no quiero");
            System.out.println("3. falta envido");
            Scanner scanner = new Scanner(System.in);
            opcion=scanner.nextInt();
            // Verificar si el número es válido 
            if (opcion >= 1 && opcion <= 3) {
                break;  // Salir del bucle si la opción es válida
            } else {
                System.out.println("Opción inválida. Debes ingresar el numero 1,2 o 3.");
            }
        }
        switch(opcion){
            case 1:
                //determinar ganador (sumaria 3 puntos)
            case 2:
                //sumarle un punto al que canto
            case 3:
                responderRealEnvidoFaltaEnvido();
            default:
        }
    }
    public void responderFaltaEnvido(){
        int opcion;
        while (true) {
            System.out.println("ingrese la opcion que desee (en numero): \n");
            System.out.println("1. quiero");
            System.out.println("2. no quiero");
            Scanner scanner = new Scanner(System.in);
            opcion=scanner.nextInt();

            // Verificar si el número es válido
            if (opcion >= 1 && opcion <= 2) {
                break;  // Salir del bucle si la opción es válida
            } else {
                System.out.println("Opción inválida. Debes ingresar el numero 1 o 2.");
            }
        }
        switch(opcion){
            case 1:
                //determinar ganador
            case 2:
                //sumar un punto al que lo canto
            default:
        }
    }
    
    
    public void responderEnvidoEnvido(){
        int opcion;
        while (true) {
            System.out.println("ingrese la opcion que desee (en numero): \n");
            System.out.println("1. quiero");
            System.out.println("2. no quiero");
            System.out.println("3. real envido");
            System.out.println("4. falta envido");
            
            Scanner scanner = new Scanner(System.in);
            opcion=scanner.nextInt();
            // Verificar si el número es válido 
            if (opcion >= 1 && opcion <= 4) {
                break;  // Salir del bucle si la opción es válida
            } else {
                System.out.println("Opción inválida. Debes ingresar el numero 1,2,3 o 4.");
            }
        }
        switch(opcion){
            case 1:
                //determinar ganador
            case 2:
                //otorgarle dos puntos al que canto el segundo envido
            case 3:
                responderEnvidoEnvidoRealEnvido();
            case 4:
                responderEnvidoEnvidoFaltaEnvido();
            default:
        }
    
    }
    public void responderEnvidoRealEnvido(){
        int opcion;
        while (true) {
            System.out.println("ingrese la opcion que desee (en numero): \n");
            System.out.println("1. quiero");
            System.out.println("2. no quiero");
            System.out.println("3. falta envido");
            Scanner scanner = new Scanner(System.in);
            opcion=scanner.nextInt();
            // Verificar si el número es válido 
            if (opcion >= 1 && opcion <= 3) {
                break;  // Salir del bucle si la opción es válida
            } else {
                System.out.println("Opción inválida. Debes ingresar el numero 1,2 o 3.");
            }
        }
        switch(opcion){
            case 1:
                //determinar ganador
            case 2:
                //otorgarle 2 puntos al que canto real envido
            case 3:
                responderEnvidoRealEnvidoFaltaEnvido();
            default:  
    }    
   
  
}
    public void responderEnvidoFaltaEnvido(){
        int opcion;
        while (true) {
            System.out.println("ingrese la opcion que desee (en numero): \n");
            System.out.println("1. quiero");
            System.out.println("2. no quiero");
            Scanner scanner = new Scanner(System.in);
            opcion=scanner.nextInt();

            // Verificar si el número es válido
            if (opcion >= 1 && opcion <= 2) {
                break;  // Salir del bucle si la opción es válida
            } else {
                System.out.println("Opción inválida. Debes ingresar el numero 1 o 2.");
            }
        }
        switch(opcion){
            case 1:
                //determinar ganador
            case 2:
                //sumarle dos puntos al que canta falta envido
            default:
        }        
    } 
    public void responderRealEnvidoFaltaEnvido(){
        int opcion;
        while (true) {
            System.out.println("ingrese la opcion que desee (en numero): \n");
            System.out.println("1. quiero");
            System.out.println("2. no quiero");
            Scanner scanner = new Scanner(System.in);
            opcion=scanner.nextInt();

            // Verificar si el número es válido
            if (opcion >= 1 && opcion <= 2) {
                break;  // Salir del bucle si la opción es válida
            } else {
                System.out.println("Opción inválida. Debes ingresar el numero 1 o 2.");
            }
        }
        switch(opcion){
            case 1:
                //determinar ganador
            case 2:
                //sumarle tres puntos al que canta falta envido
            default:
        }        
    
    }
    public void responderEnvidoEnvidoRealEnvido(){
        int opcion;
        while (true) {
            System.out.println("ingrese la opcion que desee (en numero): \n");
            System.out.println("1. quiero");
            System.out.println("2. no quiero");
            System.out.println("3. falta envido");
            Scanner scanner = new Scanner(System.in);
            opcion=scanner.nextInt();
            // Verificar si el número es válido 
            if (opcion >= 1 && opcion <= 3) {
                break;  // Salir del bucle si la opción es válida
            } else {
                System.out.println("Opción inválida. Debes ingresar el numero 1,2 o 3.");
            }
        }
        switch(opcion){
            case 1:
                //determinar ganador
            case 2:
                //sumarle cuatro puntos al que canta falta envido
            case 3:
                responderEnvidoEnvidoRealEnvidoFaltaEnvido();
            default:
        }        
    }
    public void responderEnvidoEnvidoFaltaEnvido(){
        int opcion;
        while (true) {
            System.out.println("ingrese la opcion que desee (en numero): \n");
            System.out.println("1. quiero");
            System.out.println("2. no quiero");
            Scanner scanner = new Scanner(System.in);
            opcion=scanner.nextInt();

            // Verificar si el número es válido
            if (opcion >= 1 && opcion <= 2) {
                break;  // Salir del bucle si la opción es válida
            } else {
                System.out.println("Opción inválida. Debes ingresar el numero 1 o 2.");
            }
        }
        switch(opcion){
            case 1:
                //determinar ganador
            case 2:
                //sumarle cuatro puntos al que canta falta envido
            default:
        }        
    }
    public void responderEnvidoRealEnvidoFaltaEnvido(){
        int opcion;
        while (true) {
            System.out.println("ingrese la opcion que desee (en numero): \n");
            System.out.println("1. quiero");
            System.out.println("2. no quiero");
            Scanner scanner = new Scanner(System.in);
            opcion=scanner.nextInt();

            // Verificar si el número es válido 
            if (opcion >= 1 && opcion <= 2) {
                break;  // Salir del bucle si la opción es válida
            } else {
                System.out.println("Opción inválida. Debes ingresar el numero 1 o 2.");
            }
        }
        switch(opcion){
            case 1:
                //determinar ganador
            case 2:
                //sumarle cinco puntos al que canta falta envido
            default:
                
        }
    
    }
    public void responderEnvidoEnvidoRealEnvidoFaltaEnvido(){
        int opcion;
        while (true) {
            System.out.println("ingrese la opcion que desee (en numero): \n");
            System.out.println("1. quiero");
            System.out.println("2. no quiero");
            Scanner scanner = new Scanner(System.in);
            opcion=scanner.nextInt();

            // Verificar si el número es válido 
            if (opcion >= 1 && opcion <= 2) {
                break;  // Salir del bucle si la opción es válida
            } else {
                System.out.println("Opción inválida. Debes ingresar el numero 1 o 2.");
            }
        }
        switch(opcion){
            case 1:
                //determinar ganador
            case 2:
                //sumarle siete puntos al que canta falta envido
            default:
                
        }
    }
     */

}
