package org.example;

/**
 * Clase Conecta4 principal
 */
public class Conecta4 {
    private static final String BIENVENIDA = "--- CONECTA 4 ---";

    public static void main( String[] args ) {
        Jugador jugador1 = new Jugador( "RED", 'R');
        Jugador jugador2 = new Jugador("YELLOW",'Y');

        System.out.println (BIENVENIDA);

        Jugador[] jugadores = new Jugador[] {jugador1, jugador2};
        Partida partida = new Partida(jugadores);
        partida.jugar();
    }
}
