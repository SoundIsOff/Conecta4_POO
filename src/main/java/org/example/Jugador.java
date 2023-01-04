package org.example;


/**
 * Clase abstracta jugador, en la cual se definen sus atributos, nombre del jugador, letra con la que juega
 * y tablero.
 * Contiene el método abstracto ponerFicha().
 */
public abstract class Jugador {
    protected String nombreJugador;
    protected final char letraFicha;
    protected Tablero tablero;

    public Jugador(String nombreJugador, char letraFicha) {
        this.nombreJugador = nombreJugador;
        this.letraFicha = letraFicha;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public char getLetraficha() {
        return letraFicha;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }


    public abstract void ponerFicha();
}
