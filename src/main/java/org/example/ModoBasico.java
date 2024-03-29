package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase que implementa la interfaz de ModoJuego,
 * implementa el modo básico de juego, en el cual los dos jugadores son persona.
 */
public class ModoBasico implements ModoJuego{
    private Tablero tablero;
    private Arbitro arbitro;
    private Jugador [] jugadores;
    private Turno turno;
    private GestorComandos gestor = GestorComandos.getInstance();

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
            juega.hacerFicha();

            ComandoPonerFicha cPF = new ComandoPonerFicha(juega);
            gestor.execute(cPF);
            tablero.dibujar();

            siguienteMovimiento(juega);

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

    /**
     * Método que controla el siguiente movimiento del jugador, ya sea que al poner una ficha quiera pasar el turno al siguiente
     * o deshacer su movimiento y elegir si poner la ficha en una casilla nueva o volverla a dejar donde antes.
     * @param jugador dos jugadores Persona
     */
    private void siguienteMovimiento(Jugador jugador) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        try {
            System.out.println("1. Deshacer movimiento\n2. Terminar turno");
            do {
                opcion = scanner.nextInt();
            } while (opcion < 1 || opcion > 2);

            if (opcion == 1) {
                gestor.undo();
                tablero.dibujar();
                System.out.println("1. Poner nueva ficha\n2. Rehacer movimiento");
                do {
                    opcion = scanner.nextInt();
                } while (opcion < 1 || opcion > 2);
                if (opcion == 1) {
                    jugador.ponerFicha(jugador.hacerFicha());
                } else {
                    gestor.redo();
                }
                tablero.dibujar();
            }
        }
        catch (InputMismatchException exception) {
                System.out.println("Valor no valido");
                 scanner.next();
        }
        finally {
            gestor.vaciarUndo();
            gestor.vaciarRedo();
        }


    }

}
