package org.example;

public class Conecta4 {
    private Turno turno;
    private Jugador[] jugadores;
    private Tablero tablero;
    private final int NUMJUGADORES=2;
    private final int INICIOBUCLE=0;
    private static final String BIENVENIDA="--- CONECTA 4 ---";

    public Conecta4(Jugador[] jugadores) {
        this.jugadores = jugadores;
        this.tablero = tablero;
        this.turno = new Turno(this.jugadores);
        actualizaTableroEnJugadores(this.tablero);
    }


}
