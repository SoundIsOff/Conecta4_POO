package org.example;

public class Ficha {
    private final char contenido;

    public Ficha () {
        contenido = ' ';
    }

    public Ficha (char caracter) {
        this.contenido = caracter;
    }

    public char getContenido() {
        return contenido;
    }

    public String dibujarFicha () {
        return " " + contenido + " ";
    }


}
