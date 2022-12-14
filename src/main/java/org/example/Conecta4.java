package org.example;

/**
 * Clase Conecta4 principal
 */
public class Conecta4 {
    private static final String BIENVENIDA = "--- CONECTA 4 ---";

    public static void main( String[] args ) {

        System.out.println (BIENVENIDA);
        Menu menu = new Menu();
        Partida partida = null;
        boolean partidaIniciada=true;


        do {
            switch (menu.elegirModo()) {
                case 1:
                    partida = new Partida(Jugador.jugadores(), 1);
                    break;
                case 2:
                    partida = new Partida(Jugador.jugadores(), 2);
                    break;
                case 3:
                    partida = new Partida(Jugador.jugadores(), 3);
                    break;
                default:
                    partidaIniciada = false;


            }
            if (partidaIniciada)
                partida.iniciar();
        }while (menu.continuarPartida());
    }
}
