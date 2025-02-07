package logic;

import java.util.ArrayList;
import java.util.Scanner;

public class Mesa {

    Jugador jugador1;
    Jugador jugador2;
    Mazo mazo;

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

    public void otorgarPuntos(Juego juego) {
        repartir();
        while (jugador1.getPuntaje() != 15 || jugador2.getPuntaje() != 15) {

            if (juego.evaluarGanadorDeLaMano() == jugador1) {
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

    public Jugador turno() {
        //logica del turno?
    }
    /*se podrian plantear estados y turnos, donde los turnos son a quien le corresponde tirar la carta en ese momento
    y los estados son en que esta la partida, por ejemplo en retruco, en envido-envido etc.*/
}
