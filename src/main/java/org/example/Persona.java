package org.example;

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
        this.tablero.ponerFichaPersona(mificha, nombreJugador, scanner );
    }
}
