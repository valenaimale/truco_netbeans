package com.mycompany.truco;

import logic.Carta;
import logic.Mazo;
import logic.Mesa;
import logic.Jugador;
import java.util.ArrayList;
import logic.Juego;
//las cartas se mezclan bien!!!

public class Truco {

    public static void main(String[] args) {
        ArrayList<Carta> cartas = new ArrayList<>();

        cartas.add(new Carta(1, "espada", 1));
        cartas.add(new Carta(1, "basto", 2));
        cartas.add(new Carta(7, "espada", 3));
        cartas.add(new Carta(7, "oro", 4));
        cartas.add(new Carta(3, "espada", 5));
        cartas.add(new Carta(3, "oro", 5));
        cartas.add(new Carta(3, "copa", 5));
        cartas.add(new Carta(3, "basto", 5));
        cartas.add(new Carta(2, "espada", 6));
        cartas.add(new Carta(2, "oro", 6));
        cartas.add(new Carta(2, "copa", 6));
        cartas.add(new Carta(2, "basto", 6));
        cartas.add(new Carta(1, "copa", 7));
        cartas.add(new Carta(1, "oro", 7));
        cartas.add(new Carta(12, "espada", 8));
        cartas.add(new Carta(12, "oro", 8));
        cartas.add(new Carta(12, "copa", 8));
        cartas.add(new Carta(12, "basto", 8));
        cartas.add(new Carta(11, "espada", 9));
        cartas.add(new Carta(11, "oro", 9));
        cartas.add(new Carta(11, "copa", 9));
        cartas.add(new Carta(11, "basto", 9));
        cartas.add(new Carta(10, "espada", 10));
        cartas.add(new Carta(10, "oro", 10));
        cartas.add(new Carta(10, "copa", 10));
        cartas.add(new Carta(10, "basto", 10));
        cartas.add(new Carta(7, "basto", 11));
        cartas.add(new Carta(7, "copa", 11));
        cartas.add(new Carta(6, "espada", 12));
        cartas.add(new Carta(6, "oro", 12));
        cartas.add(new Carta(6, "copa", 12));
        cartas.add(new Carta(6, "basto", 12));
        cartas.add(new Carta(5, "espada", 13));
        cartas.add(new Carta(5, "oro", 13));
        cartas.add(new Carta(5, "copa", 13));
        cartas.add(new Carta(5, "basto", 13));
        cartas.add(new Carta(4, "espada", 14));
        cartas.add(new Carta(4, "oro", 14));
        cartas.add(new Carta(4, "copa", 14));
        cartas.add(new Carta(4, "basto", 14));
        Mazo mazo1 = new Mazo(cartas);

        Jugador jugador1 = new Jugador("valentino", 0);
        Jugador jugador2 = new Jugador("ariel", 0);
        Mesa mesa = new Mesa(jugador1, jugador2, mazo1);
        Juego juego = new Juego(mesa);
        System.out.println("mazo antes de mezclarse");
        mazo1.mostrarMazo();
        mazo1.mezclar();
        System.out.println("mazo despues de mezclarse");
        mazo1.mostrarMazo();
        System.out.println("--------------");
        mesa.otorgarPuntos(juego);
    }
}
