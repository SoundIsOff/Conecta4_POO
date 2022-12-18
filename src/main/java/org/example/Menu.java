package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Clase que contiene el menú del juego.
 */
public class Menu {
    private static final String BIENVENIDA = "--- CONECTA 4 ---";
    private static final String FIN = "--- FIN DE PARTIDA ---\nGracias por jugar!";
    Scanner teclado = new Scanner(System.in);

    /**
     * Pregunta si se desea continuar jugando tras cada partida.
     * @return si la respuesta es 's' devuelve true.
     */
    public boolean continuarPartida(){
        System.out.println("\nPulse \"s\" para continuar.");
        char opcion = teclado.next().charAt(0);
        return opcion == 's';
    }

    /**
     * Imprime el menú del juego y permite elegir una opción.
     * @return devuelve la opción elegida, que es el modo de juego.
     */
    public int elegirModo(){
        int opcion=-1;
        do {
            try {
                System.out.println("1 => Básico\n" +
                        "2 => Entrenamiento\n" +
                        "3 => Demo\n" +
                        "4 => Salir\n" +
                        "Seleccione una opción: ");
                opcion = teclado.nextInt();
            }
            catch (InputMismatchException exception) {
                System.out.println("Valor no valido");
                teclado.next();

            }
        } while (opcion < 0 || opcion > 4 );

        return opcion;
    }

    public void printFinPartida(){
        System.out.println (FIN);
    }

    public void printBienvenida(){
        System.out.println (BIENVENIDA);
    }
}
