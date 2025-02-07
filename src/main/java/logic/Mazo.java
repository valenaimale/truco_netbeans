package logic;

import java.util.ArrayList;
import java.util.Collections;

public class Mazo {

    ArrayList<Carta> cartas;

    public Mazo(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    public void mostrarMazo() {
        if (cartas.isEmpty()) {
            System.out.println("El mazo está vacío.");
        } else {
            System.out.println("Cartas en el mazo:");
            for (Carta carta : cartas) {
                System.out.println(carta);
            }
        }
    }

    public ArrayList<Carta> mezclar() {
        Collections.shuffle(cartas);
        return cartas;
    }

    public Carta remover() {
        Carta cartaRemovida = cartas.remove(0);
        return cartaRemovida;
    }

    public void devolverCartaAlMazo(Carta cartaTirada) {
        cartas.add(cartaTirada);
    }

}
