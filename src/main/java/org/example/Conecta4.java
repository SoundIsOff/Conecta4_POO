package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Conecta4 principal.
 */
public class Conecta4 {
    private final Tablero tablero;
    private final int numcolumnas = 7;
    private final int numfilas = 6;
    private final int INICIOBUCLE = 0;
    private final int NUMJUGADORES = 2;
    private static final String BIENVENIDA = "--- CONECTA 4 ---";
    private  Jugador[] jugadores;
    private Arbitro arbitro;

    public Conecta4(Jugador[] jugadores) {
        this.jugadores = jugadores;
        this.tablero = new Tablero(numfilas,numcolumnas);
        this.arbitro = new Arbitro(tablero);
        actualizaTableroEnJugadores(this.tablero);

    }
    /**
     * Gestiona el desarrollo de una partida.
     * Mientras no se dé condición de fin de partida, se pide ficha
     * al jugador, se dibuja el tablero, se valora el estado de la partida y se cambia de jugador
     * El juego termina cuando el tablero está lleno o un jugador hace 4 en raya
     */
    public void iniciar() {
        List<ModoJuego> modoJuego = new ArrayList<>();
        modoJuego.add(new ModoBasico(arbitro,jugadores, tablero));
        modoJuego.add(new ModoDemo(arbitro, tablero));
        modoJuego.add(new ModoEntrenamiento(tablero,arbitro));
        Menu elegirModo = new Menu(modoJuego);
        elegirModo.elegirModo();

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

    public static void main( String[] args ) {

        Jugador jugador1 = new JugadorPersona( "RED", 'R');
        Jugador jugador2 = new JugadorPersona("YELLOW",'Y');

        Jugador [] jugadores = { jugador1, jugador2};
        Conecta4 jugar = new Conecta4(jugadores);
        System.out.printf(BIENVENIDA);
        jugar.iniciar();
    }
}
