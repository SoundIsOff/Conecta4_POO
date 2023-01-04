package org.example;

/**
 * clase para controlar el turno dentro de la partida.
 * necesita conocer los jugadores dentro de la partida.
 * jugador 0 comienza la partida.
 */
public class Turno {
    private final Jugador[] jugadores;
    private static final int JUGADORINICIAL = 0;
    private int juega;

    /**
     * Contructor que recibe la lista de jugadores entre los cuales repartir el turno.
     * @param jugadores  vector de jugadores disponibles.
     */
    public Turno (Jugador[] jugadores) {
        this.juega = JUGADORINICIAL;
        this.jugadores = jugadores;
    }

    /**
     * Método que indica el jugador que tiene el turno de la lista de jugadores.
     * @return devuelve el jugador al que le corresponde el turno.
     */
    public Jugador tieneTurno() {
        return jugadores[juega];
    }

    /**
     * Método que indica la posición del jugador al que le toca jugar.
     * @return devuelve la posición (de dentro del array de jugadores) del siguiente jugador.
     */
    private int calculaSiguienteJugador() {
        return (juega + 1) % jugadores.length;
    }

    /**
     *Método que se encarga de cambiar el turno.
     */
    public void cambiaTurno() {
        juega = calculaSiguienteJugador();
    }
    public Jugador cambiarTurno (){
        cambiaTurno();
        return tieneTurno();
    }

    /**
     * Método que obtiene el nombre del jugador que tiene el turno.
     * @return devuelve el nombre del jugador en turno.
     */
    public String nombreJugadorConTurno() {
        return jugadores[juega].getNombreJugador();
    }
}
