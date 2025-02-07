package logic;

public class Carta {

    int numero;
    String palo;
    int posicion;

    public Carta(int numero, String palo, int posicion) {
        this.numero = numero;
        this.palo = palo;
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return numero + " " + palo;  // Esto devuelve el nombre de la carta como su representación en cadena
    }

    public int getNumero() {
        return numero;
    }

    public int getPosicion() {
        return posicion;
    }

    public String getPalo() {
        return palo;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    

}
