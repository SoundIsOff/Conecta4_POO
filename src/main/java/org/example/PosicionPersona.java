package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase que implementa la interfaz PosicionFicha
 * para seleccionar la posicion de un jugador Persona.
 */
public class PosicionPersona  implements PosicionFicha{

    private final String jugador;
    private  final Tablero tableroJuego;

    public PosicionPersona(String jugador, Tablero tableroJuego) {
        this.jugador = jugador;
        this.tableroJuego = tableroJuego;
    }

    /**
     *Método que devuelve la columa seleccionada por el jugador persona.
     */
    public int seleccionaPosicion() {
        Scanner scanner = new Scanner(System.in);
        return ColumnaPersona(jugador, scanner);
    }

    /**
     * Método que olicitado por teclado una columna al jugador y comprueba si el valor es correcto.
     * @param nombreJugador nombre del jugador en turno.
     * @return devuelve la columna seleccionada.
     */
    private int ColumnaPersona( String nombreJugador, Scanner scanner) {
        int columnaElegida = -1;

        do {
            System.out.println(nombreJugador+"\nIntroduzca una columna (1-7): ");

            try {
                columnaElegida = scanner.nextInt();
            }
            catch (InputMismatchException exception) {
                System.out.println ("Jugador " + nombreJugador + ", valor no válido, se pide un valor entero");
                scanner.next();
            }
        }  while (columnaElegida > 7 || columnaElegida < 1);
        return columnaElegida;
    }
}
