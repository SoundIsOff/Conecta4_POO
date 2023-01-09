package org.example;

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
    private void siguienteMovimiento(Jugador jugador) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        System.out.println("1. Deshacer movimiento\n2. Terminar turno");
        do{
            opcion=scanner.nextInt();
        }while (opcion<1 || opcion>2);

        if(opcion==1){
            gestor.undo();
            tablero.dibujar();
            System.out.println("1. Poner nueva ficha\n2. Rehacer movimiento");
            do{
                opcion=scanner.nextInt();
            }while (opcion<1 || opcion>2);
            if(opcion==1) {
                jugador.ponerFicha(jugador.hacerFicha());
            }
            else {
                gestor.redo();
            }
            tablero.dibujar();
        }

        gestor.vaciarUndo();
        gestor.vaciarRedo();

    }

}
