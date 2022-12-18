package org.example;

/**
 * Interfaz de Jugador.
 * Define el comportamiento de las clases de los Judadores persona y CPU.
 */
public interface JugadorInterface {

    void ponerFicha(String nombreJugador);

    String getNombre();

    void setTablero(Tablero tablero);

    char getLetraficha();
}
