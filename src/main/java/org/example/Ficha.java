package org.example;

/**
 * Clase que crea ficha para conecta4
 */
public class Ficha {
    private final char contenido;
    private int fila;
    private int columna;

    /**
     * Constructor que crea una ficha con un caracter dado.
     * @param caracter carácter a mostrar en la ficha.
     */
    public Ficha (char caracter, int fila, int columna) {
        this.contenido = caracter;
        this.fila=fila;
        this.columna=columna;
    }

    /**
     * constructor para crear una ficha vacia.
     */
    public Ficha () {
        this.contenido = ' ';
    }

    public char getContenido() {
        return contenido;
    }

    /**
     * Método que devuelve la representación de una ficha.
     * @return devuelve el contenido de la ficha.
     */
    public String dibujarFicha () {
        return " " + contenido + " ";
    }


    public int getColumna() {
        return columna;
    }
    public int getFila() {
        return fila;
    }
}
