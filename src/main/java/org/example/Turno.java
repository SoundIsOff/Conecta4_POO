package org.example;

public class Turno {
    private final Jugador[] jugadores;
    private static final int JUGADORINICIAL=0;
    private int juega;

    public Turno(Jugador[] jugadores) {
        this.juega=JUGADORINICIAL;
        this.jugadores = jugadores;
    }


}
