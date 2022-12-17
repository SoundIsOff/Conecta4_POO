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
            ModoJuego modoJuego = new ModoJuego();
            partida = new Partida(modoJuego.getModo());
            partida.iniciar();
        }while (menu.continuarPartida());

        menu.printFinPartida();
    }
}
