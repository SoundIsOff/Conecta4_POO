package org.example;

import java.util.Scanner;

/**
 * Clase que representa a los jugadores de una partida
 * cada jugador tiene un nombre, una letra que representa su ficha, un tablero asignado
 */
public class Jugador {
    private final char letraficha;
    private Tablero tablero;
    private String nombre;

    /**
     * Constructor que crea un jugador
     * @param nombre cadena de caracteres para el nombre del jugador
     * @param letra char con la letra que le corresponde al jugador dentro del tablero
     */
    public Jugador(String nombre, char letra) {
        this.nombre = nombre;
        this.letraficha = letra;
        this.tablero = null;
    }
    /**
     * metodo para saber el nombre del jugador
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * metodo para cambiar el nomre del jugador
     * @param nombre cadena de caracteres para el nombre del jugador
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * metodo para conocer la letra que le corresponde al jugador
     * @return letraficha devuelve la letra
     */
    public char getLetraficha() {
        return letraficha;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    /**
     * Crea la ficha y la asigna al tablero
     * Método para poner una ficha en una casilla del tablero
     * @param nombreJugador nombre del jugador con el cual se va a colocar la ficha
     */
    public void poner(String nombreJugador) {
        Scanner scanner = new Scanner(System.in);
        Ficha mificha = new Ficha(this.letraficha);
        this.tablero.ponerFicha(mificha, nombreJugador, scanner);
    }
}
