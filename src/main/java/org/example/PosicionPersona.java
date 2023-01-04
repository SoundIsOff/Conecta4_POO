package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PosicionPersona  implements PosicionFicha{

    private final String jugador;
    private  final Tablero tableroJuego;

    public PosicionPersona(String jugador, Tablero tableroJuego) {
        this.jugador = jugador;
        this.tableroJuego = tableroJuego;
    }

    public int seleccionaPosicion() {
        Scanner scanner = new Scanner(System.in);
        return ColumnaPersona(jugador, scanner);
    }

    private int ColumnaPersona( String nombreJugador, Scanner scanner) {
        int columnaElegida = -1;
        boolean correcto = true;
        do {
            System.out.println(nombreJugador+"\nIntroduzca la columna (1-7): ");

            try {
                columnaElegida = scanner.nextInt();
                if (columnaElegida > 7 || columnaElegida < 1){
                    System.out.println("Valor invalido.");
                    correcto = false;
                }

            }
            catch (InputMismatchException exception) {
                System.out.println ("Jugador " + nombreJugador + ", valor no válido, se pide un valor entero");
                scanner.next();
            }
        } while ( !correcto );
        return columnaElegida;
    }
}
