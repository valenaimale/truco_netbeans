package logic;

import java.util.Objects;

public class Juego {

    Mesa mesa;//preguntarle a ruben, para mi podria ir jugador como atributo tambien ya que las manos las gana un jugador  no una carta

    public Juego(Mesa mesa) {
        this.mesa = mesa;
    }

    public Carta evaluarCartaGanadora(Carta cartaj1, Carta cartaj2) {
        Carta cartaGanadora;
        if (cartaj1.getPosicion() > cartaj2.getPosicion()) {
            cartaGanadora = cartaj2;
        } else if (cartaj2.getPosicion() > cartaj1.getPosicion()) {
            cartaGanadora = cartaj1;
        } else {
            cartaGanadora = null;
        }
        return cartaGanadora;
    }

    public Jugador evaluarGanadorDeLaMano() {
        int cartasGanadasj1 = 0;
        int cartasGanadasj2 = 0;
        Jugador jugador1 = mesa.getJugador1();
        Jugador jugador2 = mesa.getJugador2();
        Jugador jugadorGanador;
        Carta cartaTiradaJ1 = mesa.recibirCartaj1();
        Carta cartaTiradaJ2 = mesa.recibirCartaj2();

        if (evaluarCartaGanadora(cartaTiradaJ1, cartaTiradaJ2) == null) {//empardaron la primer carta
            System.out.println("empardaron las cartas, es parda la mejor!!");
            cartaTiradaJ1 = mesa.recibirCartaj1();
            cartaTiradaJ2 = mesa.recibirCartaj2();
            if (evaluarCartaGanadora(cartaTiradaJ1, cartaTiradaJ2) == cartaTiradaJ1) {
                cartasGanadasj1++;
                System.out.println("carta ganada por el jugador " + mesa.getJugador1().getNombre());
            } else if (evaluarCartaGanadora(cartaTiradaJ1, cartaTiradaJ2) == cartaTiradaJ2) {
                cartasGanadasj2++;
                System.out.println("carta ganada por el jugador " + mesa.getJugador2().getNombre());
            } else {
                System.out.println("empardaron las cartas otra vez, es parda la mejor!!");
                cartaTiradaJ1 = mesa.recibirCartaj1();
                cartaTiradaJ2 = mesa.recibirCartaj2();
                if (evaluarCartaGanadora(cartaTiradaJ1, cartaTiradaJ2) == cartaTiradaJ1) {
                    cartasGanadasj1++;
                    System.out.println("carta ganada por el jugador " + mesa.getJugador1().getNombre());
                } else if (evaluarCartaGanadora(cartaTiradaJ1, cartaTiradaJ2) == cartaTiradaJ2) {
                    cartasGanadasj2++;
                    System.out.println("carta ganada por el jugador " + mesa.getJugador2().getNombre());
                }
            }
        } else if (evaluarCartaGanadora(cartaTiradaJ1, cartaTiradaJ2) == cartaTiradaJ1) {//gana primer carta jugador 1
            System.out.println("carta ganada por el jugador " + mesa.getJugador1().getNombre());
            cartasGanadasj1++;
            for (int i = 0; i < 2; i++) {
                cartaTiradaJ1 = mesa.recibirCartaj1();
                cartaTiradaJ2 = mesa.recibirCartaj2();
                if (evaluarCartaGanadora(cartaTiradaJ1, cartaTiradaJ2) == cartaTiradaJ1) {
                    System.out.println("carta ganada por el jugador " + mesa.getJugador1().getNombre());
                    cartasGanadasj1++;
                    break;
                } else if (evaluarCartaGanadora(cartaTiradaJ1, cartaTiradaJ2) == cartaTiradaJ2) {
                    System.out.println("carta ganada por el jugador " + mesa.getJugador2().getNombre());
                    cartasGanadasj2++;
                } else {
                    System.out.println("empardaron las cartas, el ganador es: " + mesa.getJugador1().getNombre());
                    cartasGanadasj1++;
                    break;
                }

            }
        } else {//gana primer carta jugador 2
            System.out.println("carta ganada por el jugador " + mesa.getJugador2().getNombre());
            cartasGanadasj2++;
            for (int i = 0; i < 2; i++) {
                cartaTiradaJ1 = mesa.recibirCartaj1();
                cartaTiradaJ2 = mesa.recibirCartaj2();
                if (evaluarCartaGanadora(cartaTiradaJ1, cartaTiradaJ2) == cartaTiradaJ2) {
                    System.out.println("carta ganada por el jugador " + mesa.getJugador2().getNombre());
                    cartasGanadasj2++;
                    break;
                } else if (evaluarCartaGanadora(cartaTiradaJ1, cartaTiradaJ2) == cartaTiradaJ1) {
                    System.out.println("carta ganada por el jugador " + mesa.getJugador1().getNombre());
                    cartasGanadasj1++;
                } else {
                    System.out.println("empardaron las cartas, el ganador es: " + mesa.getJugador1().getNombre());
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.mesa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Juego other = (Juego) obj;
        return Objects.equals(this.mesa, other.mesa);
    }

    private int valoresParaTanto(Carta carta) {
        int valorParaTanto;
        if (carta.numero == 10 || carta.numero == 11 || carta.numero == 12) {
            valorParaTanto = 0;
        } else {
            valorParaTanto = carta.numero;
        }
        return valorParaTanto;
    }

    public int determinarTanto(Jugador jugador) {
        Carta carta0 = jugador.getCartasRepartidas().get(0);
        Carta carta1 = jugador.getCartasRepartidas().get(1);
        Carta carta2 = jugador.getCartasRepartidas().get(2);
        int valorParaTantoC0 = valoresParaTanto(carta0);
        int valorParaTantoC1 = valoresParaTanto(carta1);
        int valorParaTantoC2 = valoresParaTanto(carta2);
        int tanto;
        if (carta0.getPalo().equals(carta1.getPalo()) && carta1.getPalo().equals(carta2.getPalo())) {//las 3 cartas son del mismo palo
            int menor = Math.min(Math.min(valorParaTantoC0, valorParaTantoC1), valorParaTantoC2);
            if (menor == valorParaTantoC0) {
                tanto = valorParaTantoC1 + valorParaTantoC2 + 20;
            } else if (menor == valorParaTantoC1) {
                tanto = valorParaTantoC0 + valorParaTantoC2 + 20;
            } else {
                tanto = valorParaTantoC0 + valorParaTantoC1 + 20;
            }
        } else if (carta0.getPalo().equals(carta1.getPalo()) && !carta1.getPalo().equals(carta2.getPalo())) {//si hay dos cartas del mismo palo (carta0 y carta1)
            tanto = valorParaTantoC0 + valorParaTantoC1 + 20;
        } else if (carta0.getPalo().equals(carta2.getPalo()) && !carta2.getPalo().equals(carta1.getPalo())) {//si hay dos cartas del mismo palo (carta0 y carta2)
            tanto = valorParaTantoC0 + valorParaTantoC2 + 20;
        } else if (carta1.getPalo().equals(carta2.getPalo()) && !carta2.getPalo().equals(carta0.getPalo())) {//si hay dos cartas del mismo palo (carta1 y carta2)
            tanto = valorParaTantoC1 + valorParaTantoC2 + 20;
        } else {//son todas de distintos palo
            int mayor = Math.max(Math.max(valorParaTantoC0, valorParaTantoC1), valorParaTantoC2);
            tanto = mayor;
        }
        return tanto;
    }

    public Jugador evaluarGanadorDelTanto(Jugador jugador1, Jugador jugador2) {
        int tantoJ1 = determinarTanto(jugador1);
        int tantoJ2 = determinarTanto(jugador2);
        Jugador jugadorGanador;
        if (tantoJ1 > tantoJ2) {
            jugadorGanador = jugador1;
        } else {
            jugadorGanador = jugador2;
        }
        return jugadorGanador;
    }
}
