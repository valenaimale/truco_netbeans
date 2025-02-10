package logic;

import java.util.ArrayList;
import java.util.Scanner;

public class Mesa {

    Jugador jugador1;
    Jugador jugador2;
    Mazo mazo;
    Juego juego;

    public Mesa(Jugador jugador1, Jugador jugador2, Mazo mazo) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.mazo = mazo;

    }

    public void repartir() {
        mazo.mezclar();
        for (int i = 0; i < 3; i++) {
            if (!mazo.cartas.isEmpty()) {
                Carta cartaRemovida = mazo.remover();
                jugador1.setAgregarCarta(cartaRemovida);
                Carta cartaRemovida2 = mazo.remover();
                jugador2.setAgregarCarta(cartaRemovida2);
            }
        }
    }
    
    public int cartaElegidaParaTirarJ1() {
        jugador1.mostrarCartasRepartidas();
        System.out.println("cantidad de cartas en mano: " + jugador1.getCartasRepartidas().size());
        System.out.println("Que carta desea tirar?");
        System.out.println("----------------");
        System.out.println("Ingrese la opcion deseada(en numero)");
        Scanner scanner = new Scanner(System.in);
        int cartaElegida = scanner.nextInt();

        Carta minima = jugador1.getCartasRepartidas().get(0);

        while (cartaElegida > jugador1.getCartasRepartidas().size() - 1 || cartaElegida < jugador1.getCartasRepartidas().indexOf(minima)) {
            int indMax = jugador1.getCartasRepartidas().size() - 1;
            int indMin = jugador1.getCartasRepartidas().indexOf(minima);
            System.out.println("Ingrese un numero entre " + indMax + " y " + indMin);
            System.out.println("vuelva a ingresar la carta");
            cartaElegida = scanner.nextInt();
        }
        return cartaElegida;
    }

    public int cartaElegidaParaTirarJ2() {
        jugador2.mostrarCartasRepartidas();
        System.out.println("cantidad de cartas en mano: " + jugador2.getCartasRepartidas().size());
        System.out.println("Que carta desea tirar?");
        System.out.println("----------------");
        System.out.println("Ingrese la opcion deseada(en numero)");
        Scanner scanner = new Scanner(System.in);
        int cartaElegida = scanner.nextInt();

        Carta minima = jugador2.getCartasRepartidas().get(0);

        while (cartaElegida > jugador2.getCartasRepartidas().size() - 1 || cartaElegida < jugador2.getCartasRepartidas().indexOf(minima)) {
            int indMax = jugador2.getCartasRepartidas().size() - 1;
            int indMin = jugador2.getCartasRepartidas().indexOf(minima);
            System.out.println("Ingrese un numero entre " + indMax + " y " + indMin);
            System.out.println("vuelva a ingresar la carta");
            cartaElegida = scanner.nextInt();
        }
        return cartaElegida;
    }

    public Carta recibirCartaj1() {
        int indiceElegido = cartaElegidaParaTirarJ1();
        Carta tirada = jugador1.tirarCarta(indiceElegido);
        mazo.devolverCartaAlMazo(tirada);
        return tirada;
    }

    public Carta recibirCartaj2() {
        int indiceElegido = cartaElegidaParaTirarJ2();
        Carta tirada = jugador2.tirarCarta(indiceElegido);
        mazo.devolverCartaAlMazo(tirada);
        return tirada;
    }

    public void otorgarPuntos() {
        repartir();
        ofrecerOpAlJugador(jugador1);
        while (jugador1.getPuntaje() != 15 || jugador2.getPuntaje() != 15) {

            if (evaluarGanadorDeLaMano() == jugador1) {
                jugador1.setPuntaje(1);

            } else {
                jugador2.setPuntaje(1);
            }
            jugador1.removerCartasSinTirar(mazo);
            jugador2.removerCartasSinTirar(mazo);
            System.out.println(jugador1.getNombre() + "tiene " + jugador1.getPuntaje() + "puntos");
            System.out.println(jugador2.getNombre() + "tiene " + jugador2.getPuntaje() + "puntos");
            repartir();

        }
        if (jugador1.getPuntaje() == 15) {
            System.out.println("el ganador es: " + jugador1.getNombre());
        } else {
            System.out.println("el ganador es: " + jugador2.getNombre());
        }
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public Mazo getMazo() {
        return mazo;
    }
    /*
    public Jugador turno() {
        //logica del turno?
    }
    /*se podrian plantear estados y turnos, donde los turnos son a quien le corresponde tirar la carta en ese momento
    y los estados son en que esta la partida, por ejemplo en retruco, en envido-envido etc.*/
    public Jugador evaluarGanadorDeLaMano() {
        int cartasGanadasj1 = 0;
        int cartasGanadasj2 = 0;
        Jugador jugadorGanador;
        
        Carta cartaTiradaJ1 = recibirCartaj1();
        Carta cartaTiradaJ2 = recibirCartaj2();

        if (juego.evaluarCartaGanadora(cartaTiradaJ1, cartaTiradaJ2) == null) {//empardaron la primer carta
            System.out.println("empardaron las cartas, es parda la mejor!!");
            cartaTiradaJ1 = recibirCartaj1();
            cartaTiradaJ2 = recibirCartaj2();
            if (juego.evaluarCartaGanadora(cartaTiradaJ1, cartaTiradaJ2) == cartaTiradaJ1) {
                cartasGanadasj1++;
                System.out.println("carta ganada por el jugador " + jugador1.getNombre());
            } else if (juego.evaluarCartaGanadora(cartaTiradaJ1, cartaTiradaJ2) == cartaTiradaJ2) {
                cartasGanadasj2++;
                System.out.println("carta ganada por el jugador " + jugador2.getNombre());
            } else {
                System.out.println("empardaron las cartas otra vez, es parda la mejor!!");
                cartaTiradaJ1 = recibirCartaj1();
                cartaTiradaJ2 = recibirCartaj2();
                if (juego.evaluarCartaGanadora(cartaTiradaJ1, cartaTiradaJ2) == cartaTiradaJ1) {
                    cartasGanadasj1++;
                    System.out.println("carta ganada por el jugador " + jugador1.getNombre());
                } else if (juego.evaluarCartaGanadora(cartaTiradaJ1, cartaTiradaJ2) == cartaTiradaJ2) {
                    cartasGanadasj2++;
                    System.out.println("carta ganada por el jugador " + jugador2.getNombre());
                }
            }
        } else if (juego.evaluarCartaGanadora(cartaTiradaJ1, cartaTiradaJ2) == cartaTiradaJ1) {//gana primer carta jugador 1
            System.out.println("carta ganada por el jugador " + jugador1.getNombre());
            cartasGanadasj1++;
            for (int i = 0; i < 2; i++) {
                cartaTiradaJ1 = recibirCartaj1();
                cartaTiradaJ2 = recibirCartaj2();
                if (juego.evaluarCartaGanadora(cartaTiradaJ1, cartaTiradaJ2) == cartaTiradaJ1) {
                    System.out.println("carta ganada por el jugador " + jugador1.getNombre());
                    cartasGanadasj1++;
                    break;
                } else if (juego.evaluarCartaGanadora(cartaTiradaJ1, cartaTiradaJ2) == cartaTiradaJ2) {
                    System.out.println("carta ganada por el jugador " + jugador2.getNombre());
                    cartasGanadasj2++;
                } else {
                    System.out.println("empardaron las cartas, el ganador es: " + jugador1.getNombre());
                    cartasGanadasj1++;
                    break;
                }

            }
        } else {//gana primer carta jugador 2
            System.out.println("carta ganada por el jugador " + jugador2.getNombre());
            cartasGanadasj2++;
            for (int i = 0; i < 2; i++) {
                cartaTiradaJ1 = recibirCartaj1();
                cartaTiradaJ2 = recibirCartaj2();
                if (juego.evaluarCartaGanadora(cartaTiradaJ1, cartaTiradaJ2) == cartaTiradaJ2) {
                    System.out.println("carta ganada por el jugador " + jugador2.getNombre());
                    cartasGanadasj2++;
                    break;
                } else if (juego.evaluarCartaGanadora(cartaTiradaJ1, cartaTiradaJ2) == cartaTiradaJ1) {
                    System.out.println("carta ganada por el jugador " + jugador1.getNombre());
                    cartasGanadasj1++;
                } else {
                    System.out.println("empardaron las cartas, el ganador es: " + jugador1.getNombre());
                    cartasGanadasj2++;
                    break;
                }
            }
        }
        if (cartasGanadasj1 > cartasGanadasj2) {
            jugadorGanador = jugador1;
        } else {
            jugadorGanador = jugador2;
        }
        return jugadorGanador;
    }
    public void ofrecerOpAlJugador(Jugador jugadorx){
        System.out.println("ingrese la opcion que desee: \n");
        System.out.println("1.envido \n");
        System.out.println("2.real envido \n");
        System.out.println("3.falta envido \n");
        System.out.println("4.truco \n");
        System.out.println("5.me voy al mazo \n");
        if(jugadorx==jugador1){
            if(jugador1.ingresarDatos()==1){
                ofrecerRespAlJugadorParaEnvido(jugador2);
            
            }
        }
        else{
            jugador2.ingresarDatos();
        }
  
    } 
    
    public void ofrecerRespAlJugadorParaEnvido(Jugador jugadorx){
        System.out.println("ingrese la opcion que desee: \n");
        System.out.println("1.quiero \n");
        System.out.println("2.no quiero \n");
        System.out.println("3.envido \n");
        System.out.println("4.real envido \n");
        System.out.println("5.falta envido \n");
        int opcion;
        if(jugadorx==jugador1){
            opcion=jugador1.ingresarDatos();
            switch (opcion){
                case 1:
                    if(juego.determinarTanto(jugador1)>juego.determinarTanto(jugador2)){
                        jugador1.setPuntaje(2);
                    }
                    else{
                        jugador2.setPuntaje(2);
                    }
                case 2:
                    jugador2.setPuntaje(1);
                case 3:
                    ofrecerRespAlJugadorParaEnvidoEnvido(jugador2);
                case 4:
                    ofrecerRespAlJugadorParaEnvidoRealEnvido(jugador2);
                case 5:
                    ofrecerRespAlJugadorParaEnvidoFaltaEnvido(jugador2);
            }
        }
        else{
            opcion=jugador2.ingresarDatos();
            switch (opcion){
                case 1:
                    if(juego.determinarTanto(jugador1)>juego.determinarTanto(jugador2)){
                        jugador1.setPuntaje(2);
                    }
                    else{
                        jugador2.setPuntaje(2);
                    }
                case 2:
                    jugador1.setPuntaje(1);
                case 3:
                    ofrecerRespAlJugadorParaEnvidoEnvido(jugador1);
                case 4:
                    ofrecerRespAlJugadorParaEnvidoRealEnvido(jugador1);
                case 5:
                    ofrecerRespAlJugadorParaEnvidoFaltaEnvido(jugador1);
            }
        }
    }
    public void ofrecerRespAlJugadorParaEnvidoEnvido(Jugador jugadorx){
        System.out.println("ingrese la opcion que desee: \n");
        System.out.println("1.quiero \n");
        System.out.println("2.no quiero \n");
        System.out.println("3.real envido \n");
        System.out.println("4.falta envido \n");
        int opcion;
        if(jugadorx==jugador1){
            opcion=jugador1.ingresarDatosParaEnvidoEnvido();
            switch (opcion){
                case 1:
                    if(juego.determinarTanto(jugador1)>juego.determinarTanto(jugador2)){
                        jugador1.setPuntaje(4);
                    }
                    else{
                        jugador2.setPuntaje(4);
                    }
                case 2:
                    jugador2.setPuntaje(2);
                case 3:
                    ofrecerRespAlJugadorParaEnvidoEnvidoRealEnvido(jugador2);
                case 4:
                    ofrecerRespAlJugadorParaEnvidoEnvidoFaltaEnvido(jugador2);
                
                
            }
        }
        else{
            opcion=jugador2.ingresarDatosParaEnvidoEnvido();
            switch (opcion){
                case 1:
                    if(juego.determinarTanto(jugador1)>juego.determinarTanto(jugador2)){
                        jugador1.setPuntaje(4);
                    }
                    else{
                        jugador2.setPuntaje(4);
                    }
                case 2:
                    jugador1.setPuntaje(2);
                case 3:
                    ofrecerRespAlJugadorParaEnvidoEnvidoRealEnvido(jugador1);
                case 4:
                    ofrecerRespAlJugadorParaEnvidoEnvidoFaltaEnvido(jugador1);
            }
        }
    }
    public void ofrecerRespAlJugadorParaEnvidoRealEnvido(Jugador jugadorx){
        System.out.println("ingrese la opcion que desee: \n");
        System.out.println("1.quiero \n");
        System.out.println("2.no quiero \n");
        System.out.println("3.falta envido \n");
        int opcion;
        if(jugadorx==jugador1){
            opcion=jugador1.ingresarDatosParaEnvidoEnvido();
            switch (opcion){
    
    
    }
}
