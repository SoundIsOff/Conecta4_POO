package org.example;

/**
 * Clase que implementa la interfaz de ModoJuego,
 * implementa el modo básico de juego, en el cual los dos jugadores son persona.
 */
public class ModoBasico implements ModoJuego{
    private Tablero tablero;
    private Arbitro arbitro;
    private Jugador [] jugadores;
    private Turno turno;

    /**
     * Constructor de la clase.
     * @param arbitro comprueba el ganador de la partida.
     * @param jugadores array de jugadores.
     * @param tablero tablero en el que se desarrolla la partida.
     */
    public ModoBasico(Arbitro arbitro, Jugador[] jugadores, Tablero tablero) {
        this.arbitro = arbitro;
        this.jugadores = jugadores;
        this.tablero = tablero;
        this.turno = new Turno(jugadores);
    }

    /**
     * Método para el desarrollo de un juego básico.
     */
    public void jugar() {
        Jugador juega = turno.tieneTurno();
        boolean finPartida;
        tablero.dibujar();
        do {
            juega.ponerFicha();
            tablero.dibujar();
            finPartida=finPartida(juega);
            juega = turno.cambiarTurno();
        } while (!finPartida);
        tablero.inicializarTablero();
    }

    private boolean finPartida(Jugador jugador) {
        boolean fin=false;

        if(arbitro.compruebaGanador(jugador.getLetraficha())){
            fin=true;
            System.out.println(jugador.getNombreJugador()+" ha ganado! ");
        }else if(tablero.tableroLleno()){
            fin=true;
            System.out.println("Fin de partida. No hay ganador.");
        }

        return fin;
    }
}
