package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Persona implements JugadorInterface {
    private char letraficha;
    private Tablero tablero;
    private String nombre;


    public Persona(String nombre, char letra) {
        this.nombre = nombre;
        this.letraficha = letra;
        this.tablero = null;
    }

    public void ponerFicha(String nombreJugador) {
        Scanner scanner = new Scanner(System.in);
        Ficha mificha = new Ficha(this.letraficha);
        this.ponerFichaPersona(mificha, nombreJugador, scanner );
    }

    public char getLetraficha() {
        return letraficha;
    }


    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public String getNombre() {
        return nombre;
    }



    /**
     * Método que solicita al jugador una columna,
     * Comprueba que el valor no sea inválido y que la columna no esté llena,
     * Coloca la ficha.
     * @param ficha ficha del jugador en turno.
     * @param nombreJugador nombre del jugador en turno.
     */
    public void ponerFichaPersona(Ficha ficha, String nombreJugador, Scanner scanner) {
        int columnaElegida;
        int filaFicha;
        boolean llena = false;
        boolean correcto = false;
        do {
            System.out.println(nombreJugador+"\nIntroduzca la columna (1-7): ");

            try {
                columnaElegida = scanner.nextInt();
                if (columnaElegida > 7 || columnaElegida < 1)
                    System.out.println("Valor invalido.");
                else{
                    llena = tablero.columnaLlena(columnaElegida-1);
                    if (llena){
                        System.out.println("La columna esta llena.");

                    }
                    else {
                        correcto = true;
                        filaFicha = tablero.filaFicha(columnaElegida-1);
                        tablero.ponerFicha(filaFicha, columnaElegida, ficha);
                    }
                }
            }
            catch (InputMismatchException exception) {
                System.out.println ("Jugador " + nombreJugador + ", valor no válido, se pide un valor entero");
                scanner.next();
            }
        } while ( !correcto || llena);
    }






}
