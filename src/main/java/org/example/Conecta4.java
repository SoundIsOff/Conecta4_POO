package org.example;

/**
 * Clase Conecta4 principal
 */
public class Conecta4 {

    public static void main( String[] args ) {

        Menu menu = new Menu();
        Partida partida;
        ModoJuego modoJuego;


        menu.printBienvenida();

        do {
            modoJuego = new ModoJuego();
            partida = new Partida(Jugador.jugadores(), modoJuego.getModo());
            partida.iniciar();
        }while (menu.continuarPartida());

        menu.printFinPartida();
    }
}
