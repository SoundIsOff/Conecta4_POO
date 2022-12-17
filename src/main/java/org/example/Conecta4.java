package org.example;

/**
 * Clase Conecta4 principal
 */
public class Conecta4 {

    public static void main( String[] args ) {

        Menu menu = new Menu();
        Partida partida;


        menu.printBienvenida();

        do {
            partida = new Partida(Jugador.jugadores());
            partida.iniciar();
        }while (menu.continuarPartida());

        menu.printFinPartida();
    }
}
