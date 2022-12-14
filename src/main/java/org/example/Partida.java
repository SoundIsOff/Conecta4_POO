package org.example;

public class Partida {
    private Turno turno;
    private Jugador[] jugadores;
    private Tablero tablero;
    private Arbitro arbitro;
    private int modo;

    private final int NUMJUGADORES = 2;
    private final int INICIOBUCLE = 0;


    /**
     * Constructor de la clase en el que se define el tamaño del tablero
     * Necesita el vector con los dos jugadores que van a jugar
     * @param jugadores array de jugadores
     */
    public Partida(Jugador[] jugadores, int modo) {
        this.jugadores = jugadores;
        this.tablero = new Tablero(6, 7);
        this.turno = new Turno(this.jugadores);
        this.modo=modo;
        actualizaTableroEnJugadores(this.tablero);
    }


    /**
     * Actualiza el tablero para que ambos jugadores puedan colocar fichas
     * @param tablero objeto tablero que contiene casillas
     */
    private void actualizaTableroEnJugadores (Tablero tablero) {
        for (int indice = INICIOBUCLE; indice < NUMJUGADORES; indice++) {
            jugadores[indice].setTablero(tablero);
        }
    }

    /**
     * Gestiona el desarrollo de una partida.
     * Mientras no se dé condición de fin de partida, se pide ficha
     * al jugador, se dibuja el tablero, se valora el estado de la partida y se cambia de jugador
     * El juego termina cuando el tablero está lleno o un jugador hace 4 en raya
     */
    public void iniciar() {
        Jugador juega = turno.tieneTurno();
        arbitro = new Arbitro(tablero);
        boolean fin;
        tablero.dibujar();
        do {
            modoJuego(juega, turno);
            tablero.dibujar();
            fin=finPartida(juega);
            juega = cambiarTurno();
        } while (!fin);
    }

    public void modoJuego(Jugador juega, Turno turno){
        if(modo==1){
            juega.jugadorPoneFicha(turno.nombreJugadorConTurno());

        }
        else if(modo==2){
            if(juega==jugadores[1])
                juega.cpuPoneFicha(turno.nombreJugadorConTurno());
            else  juega.jugadorPoneFicha(turno.nombreJugadorConTurno());
        }
        else  juega.cpuPoneFicha(turno.nombreJugadorConTurno());
    }




    /**
     * Devuelve el nuevo jugador después de alternar entre ellos
     * @return jugador siguiente en el array de jugadores
     */
    private Jugador cambiarTurno () {
        turno.cambiaTurno();
        return turno.tieneTurno();
    }


    /**
     * Se evalúa un boolean que será true si el jugador ha ganado o si el tablero está lleno.
     * Si no, devolverla false por defecto. En el caso de terminarse la partida, escribe
     * el mensaje de Final correspondiente
     * @param jugador se comprueba si este jugador ha ganado
     * @return boolean con dos casos: true si ha ganado o tablero lleno y false si no
     */
    private boolean finPartida(Jugador jugador) {
        boolean fin=false;

        if(arbitro.compruebaGanador(jugador.getLetraficha())){
            fin=true;
            System.out.println(jugador.getNombre()+" ha ganado! ");
        }else if(tablero.tableroLleno()){
            fin=true;
            System.out.println("Fin de partida. No hay ganador.");
        }

        return fin;
    }

}
