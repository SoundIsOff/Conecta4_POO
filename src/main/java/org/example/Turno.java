package org.example;

public class Turno {
    private final Jugador[] jugadores;
    private static final int JUGADORINICIAL = 0;
    private int juega;

    //Contructor que recibe la lista de jugadores entre los cuales repartir el turno
    public Turno (Jugador[] jugadores) {
        this.juega = JUGADORINICIAL;
        this.jugadores = jugadores;
    }

    //Método que indica el jugador que tiene el turno de la lista de jugadores
    public Jugador tieneTurno() {
        return jugadores[juega];
    }

    //Método que indica la posición del jugador al que le toca jugar
    private int calculaSiguienteJugador() {
        return (juega + 1) % jugadores.length;
    }

    //Método que se encarga de cambiar el turno
    public void cambiaTurno() {
        juega = calculaSiguienteJugador();
    }

    //Método que obtiene el nombre del jugador que tiene el turno
    public String nombreJugadorConTurno() {
        return jugadores[juega].getNombre();
    }
}
