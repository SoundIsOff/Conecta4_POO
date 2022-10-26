package org.example;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Turno {
    private final Jugador[] jugadores;
    private static final int JUGADORINICIAL = 0;
    private int juega;

    public Turno (Jugador[] jugadores) {
        this.juega = JUGADORINICIAL;
        this.jugadores = jugadores;
    }

    public Jugador tieneTurno() {
        return jugadores[juega];
    }

    private int calculaSiguienteJugador() {
        return (juega + 1) % jugadores.length;
    }

    public void cambiaTurno() {
        juega = calculaSiguienteJugador();
    }

    public String nombreJugadorConTurno() {
        return jugadores[juega].getNombre();
    }
}
