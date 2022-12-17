package org.example;

import java.util.Locale;
import java.util.Scanner;

/**
 * Clase que representa a los jugadores de una partida.
 * cada jugador tiene un nombre, una letra que representa su ficha, un tablero asignado.
 */
public class Jugador {
    private final char letraficha;
    private Tablero tablero;
    private String nombre;

    /**
     * Constructor que crea un jugador, pasándole su nombre y letra
     * e iniciando el tablero a null
     * @param nombre cadena de caracteres para el nombre del jugador.
     * @param letra char con la letra que le corresponde al jugador dentro del tablero.
     */
    public Jugador(String nombre, char letra) {
        this.nombre = nombre;
        this.letraficha = letra;
        this.tablero = null;
    }

    /**
     * Constructor del array de jugadores que se usará el resto de la partida
     * @return jugadores
     */
    public static Jugador[] jugadores(){
        Jugador jugador1 = new Jugador( "RED", 'R');
        Jugador jugador2 = new Jugador("YELLOW",'Y');

        return new Jugador[] {jugador1, jugador2};
    }


    /**
     * Método que pide al usuario el color que va a usar y lo convierte a String en mayúsculas.
     * De este String tambien se obtiene la letra char que se usará para las fichas de dicho jugador
     * @return jugador creado manualmente
     * */
    public static Jugador crearJugador(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca Color:");
        String color =  scanner.next().toUpperCase(Locale.ROOT);
        char letra = color.toUpperCase(Locale.ROOT).charAt(0);
        return new Jugador(color, letra);

    }


    /**
     * método para saber el nombre del jugador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * metodo para cambiar el nombre del jugador.
     * @param nombre cadena de caracteres para el nombre del jugador.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * metodo para conocer la letra que le corresponde al jugador.
     * @return char letraficha devuelve la letra.
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
     * Crea una ficha y la pasa al tablero donde se asigna en una casilla
     * @param nombreJugador nombre del jugador con el cual se va a colocar la ficha.
     */
    public void jugadorPoneFicha(String nombreJugador) {
        Scanner scanner = new Scanner(System.in);
        Ficha mificha = new Ficha(this.letraficha);
        this.tablero.ponerFichaPersona(mificha, nombreJugador, scanner );
    }

    public void cpuPoneFicha(String nombreJugador){
        Ficha mificha = new Ficha(this.letraficha);
        tablero.ponerFichaCPU(mificha);
    }


}
