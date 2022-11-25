package org.example;

/**
 * Clase que crea ficha para conecta4
 */
public class Ficha {
    private final char contenido;

    /**
     * Constructor que crea una ficha con un caracter dado.
     * @param caracter carácter a mostrar en la ficha.
     */
    public Ficha (char caracter) {
        this.contenido = caracter;
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


}
