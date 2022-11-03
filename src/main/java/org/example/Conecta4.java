package org.example;

public class Conecta4
{
    private Turno turno;
    private Jugador[] jugadores;
    private Tablero tablero;
    private final int NUMJUGADORES = 2;
    private final int INICIOBUCLE = 0;
    private static final String BIENVENIDA = "--- CONECTA 4 ---";

    //Constructor de la calse en el que se define el tamaño del tablero
    //Necesita el vector con los dos jugadores que van a jugar
    public Conecta4(Jugador[] jugadores) {
        this.jugadores = jugadores;
        this.tablero = new Tablero(6, 7);
        this.turno = new Turno(this.jugadores);
        actualizaTableroEnJugadores(this.tablero);
    }

    //Método que actualiza el tablero para que ambos jugadores puedan colocar fichas
    private void actualizaTableroEnJugadores (Tablero tablero) {
        for (int indice = INICIOBUCLE; indice < NUMJUGADORES; indice++) {
            jugadores[indice].setTablero(tablero);
        }
    }

    //Método que gestiona el desarrollo de una partida
    //El juego termina cuando el tablero está lleno
    public void jugar() {
        Jugador juega = turno.tieneTurno();
        tablero.dibujar();
        do {
            juega.poner(turno.nombreJugadorConTurno());
            tablero.dibujar();
            juega = cambiarTurno();
        } while (!finPartida());
        System.out.println("Fin de la partida.");
    }

    private Jugador cambiarTurno () {
        turno.cambiaTurno();
        return turno.tieneTurno();
    }

    private boolean finPartida() {
        return  tablero.tableroLleno();
    }

    public static void main( String[] args ) {
        Jugador jugador1 = new Jugador( "Turno: RED", 'R');
        Jugador jugador2 = new Jugador("Turno: YELLOW",'Y');
        System.out.println (BIENVENIDA);
        Jugador[] jugadores = new Jugador[] {jugador1, jugador2};
        Conecta4 conecta4 = new Conecta4(jugadores);
        conecta4.jugar();
    }
}
