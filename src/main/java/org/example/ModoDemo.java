package org.example;

/**
 * Clase que implementa la interfaz de ModoJuego,
 * implementa el modo demo de juego, en el cual los dos jugadores son máquina.
 */
public class ModoDemo  implements ModoJuego {
    private Tablero tablero;
    private Arbitro arbitro;
    private Jugador [] jugadores;
    private Turno turno;
    private GestorComandos gestor = GestorComandos.getInstance();

    /**
     * Constructor de la clase.
     * Define los jugadores de la partida, jugadoresCPU.
     * @param arbitro comprueba el ganador de la partida.
     * @param tablero tablero en el que se desarrolla la partida.
     */
    public ModoDemo(Arbitro arbitro, Tablero tablero) {
        this.arbitro = arbitro;
        this.tablero = tablero;
        this.jugadores = new Jugador[2];
        jugadores [0] = new JugadorCPU("RED", 'R');
        jugadores [0].setTablero(tablero);
        jugadores [1] = new JugadorCPU("YELLOW",'Y');
        jugadores [1].setTablero(tablero);
        this.turno = new Turno(jugadores);

    }

    /**
     * Método para el desarrollo de un juego demo.
     */
    public void jugar() {
        Jugador juega = jugadores[0];
        arbitro = new Arbitro(tablero);
        boolean fin;
        tablero.dibujar();
        do {
            juega.hacerFicha();
            ComandoPonerFicha cPF = new ComandoPonerFicha(juega);
            gestor.execute(cPF);
            System.out.printf("\nTurno del jugador "+ juega.nombreJugador+"\n");
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
