package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public int modo;
    Scanner teclado = new Scanner(System.in);

    public int getModo() {
        return modo;
    }

    public void setModo(int modo) {
        this.modo = modo;
    }

    public int elegirModo(){
        int opcion=0;
        try {
            do {
                System.out.println("1 => Básico\n" +
                        "2 => Entrenamiento\n" +
                        "3 => Demo\n" +
                        "4 => Salir\n" +
                        "Seleccione una opción: ");
                opcion = teclado.nextInt();
            } while (opcion < 0 || opcion >= 4);

        }
        catch (InputMismatchException exception) {
            System.out.println ("Valor no valido");

        }
        return opcion;
    }

    public boolean continuarPartida(){
        System.out.println("Pulse \"s\" para continuar.");
        char opcion = teclado.next().charAt(0);
        return opcion == 's';
    }
}
