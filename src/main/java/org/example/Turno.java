package org.example;

public class Turno {
    private final Jugador[] jugadores;
    private static final int JUGADORINICIAL=0;
    private int juega;

    public Turno(Jugador[] jugadores) {
        this.juega=JUGADORINICIAL;
        this.jugadores = jugadores;
    }

    public Jugador tieneturno(){
        return jugadores[juega];
    }

    private int calculaSiguienteJugador(){
        return (juega+1)%jugadores.length;
    }

    public void cambiaTurno(){
        juega=calculaSiguienteJugador();
    }

    public char letraJugarorConTurno(){
        return jugadores[juega].getLetraficha();
    }

    public String nombreJugadorConTurno(){
        return jugadores[juega].getNombre();
    }
}
