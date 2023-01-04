package org.example;

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
