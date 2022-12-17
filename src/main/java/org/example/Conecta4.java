package org.example;

/**
 * Clase Conecta4 principal
 */
public class Conecta4 {
    private static final String BIENVENIDA = "--- CONECTA 4 ---";

    public static void main( String[] args ) {

        System.out.println (BIENVENIDA);
        Menu menu = new Menu();
        Partida partida;


        do {

            partida = new Partida(Jugador.jugadores(), menu.elegirModo());
            partida.iniciar();
        }while (menu.continuarPartida());
    }
}
