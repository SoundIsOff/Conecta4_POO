package org.example;

public interface JugadorInterface {
    void ponerFicha(String nombreJugador);

    String getNombre();

    void setTablero(Tablero tablero);

    char getLetraficha();
}
