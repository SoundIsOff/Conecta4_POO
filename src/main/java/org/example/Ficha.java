package org.example;

public class Ficha {
    private final char contenido;

    public Ficha (char caracter) {
        this.contenido = caracter;
    }

    public char getContenido() {
        return contenido;
    }

    //Método que devuelve la representación de una ficha
    public String dibujarFicha () {
        return " " + contenido + " ";
    }


}
