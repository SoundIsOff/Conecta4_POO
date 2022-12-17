package org.example;

import java.util.Scanner;

public class CPU implements JugadorInterface {
    private char letraficha;
    private Tablero tablero;
    private String nombre;


    public CPU(String nombre, char letra) {
        this.nombre = nombre;
        this.letraficha = letra;
        this.tablero = null;
    }

    public void ponerFicha(String nombreJugador) {
        Ficha fichaRandom = new Ficha(this.letraficha);
        this.tablero.ponerFichaCPU(fichaRandom);
    }
}
