package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ModoJuego {
    private int modo;
    private Scanner teclado;

    public ModoJuego() {
        this.modo = elegirModo();
    }

    public int getModo() {
        return modo;
    }

    public int elegirModo(){
        int opcion=-1;
        try {
            do {
                System.out.println("1 => Básico\n" +
                        "2 => Entrenamiento\n" +
                        "3 => Demo\n" +
                        "4 => Salir\n" +
                        "Seleccione una opción: ");
                opcion = teclado.nextInt();
            } while (opcion < 0 || opcion > 4);

        }
        catch (InputMismatchException exception) {
            System.out.println ("Valor no valido");

        }
        return opcion;
    }
}
