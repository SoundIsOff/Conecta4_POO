package org.example;

import java.util.Scanner;
import java.util.logging.Logger;

public class Jugador {
    private final char letraficha;
    private Tablero tablero;
    private String nombre;


    public Jugador( String nombre, char letraficha, Tablero tablero) {
        this.nombre = nombre;
        this.letraficha = letraficha;
        this.tablero = tablero;
    }
    public Jugador(String nombre, char letra) {
        this.nombre = nombre;
        this.letraficha = letra;
        this.tablero = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getLetraficha() {
        return letraficha;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }
    public void poner(String jugador) {
        Scanner scanner = new Scanner(System.in);
        int fila;
        int columna;
        //do {
        Ficha mificha = new Ficha(this.letraficha);
        this.tablero.ponerFicha(  mificha, jugador, scanner);
        // } while (this.tablero.tableroLleno());
    }
}
