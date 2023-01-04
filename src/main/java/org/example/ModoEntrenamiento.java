package org.example;

/**
 * Clase que implementa la interfaz de ModoJuego,
 * implementa el modo entrenamiento de juego, en el cual juega un jugador persona contra máquina.
 */
public class ModoEntrenamiento implements ModoJuego{

    private Jugador[] jugadores;
    private  Turno turno;
    private Tablero tablero;
    private Arbitro arbitro;


    /**
     * Constructor de la clase.
     * Define los jugadores de la partida, un jugadorPersona y un jugadorCPU.
     * @param arbitro comprueba el ganador de la partida.
     * @param tablero tablero en el que se desarrolla la partida.
     */
    public ModoEntrenamiento(Tablero tablero, Arbitro arbitro) {
        this.tablero = tablero;
        this.arbitro = arbitro;
        this.jugadores = new Jugador[2];
        jugadores [0] = new JugadorPersona("RED", 'R');
        jugadores [0].setTablero(tablero);
        jugadores [1] = new JugadorCPU("YELLOW",'Y');
        jugadores [1].setTablero(tablero);
        this.turno = new Turno(jugadores);
    }

    /**
     * Método para el desarrollo de un juego de entrenamiento.
     */
    public void jugar() {
        Jugador juega = turno.tieneTurno();
        arbitro = new Arbitro(tablero);
        boolean fin;
        tablero.dibujar();
        do {
            juega.ponerFicha();
            tablero.dibujar();
            fin=finPartida(juega);
            juega = cambiarTurno();
        } while (!fin);
        tablero.inicializarTablero();
    }

    private Jugador cambiarTurno(){
        turno.cambiaTurno();
        return turno.tieneTurno();
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
