package org.example;
import java.util.Scanner;

public class Menu {
    private static final String BIENVENIDA = "--- CONECTA 4 ---";
    private static final String FIN = "--- FIN DE PARTIDA ---\nGracias por jugar!";
    Scanner teclado = new Scanner(System.in);

    public boolean continuarPartida(){
        System.out.println("\nPulse \"s\" para continuar.");
        char opcion = teclado.next().charAt(0);
        return opcion == 's';
    }

    public void printFinPartida(){
        System.out.println (FIN);
    }

    public void printBienvenida(){
        System.out.println (BIENVENIDA);
    }
}
