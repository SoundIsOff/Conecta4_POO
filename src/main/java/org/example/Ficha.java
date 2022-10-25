package org.example;

public class Ficha {
    private final char contenido;

    public Ficha(char caracter) {
        this.contenido = caracter;
    }

    public char getContenido() {
        return contenido;
    }

    public Ficha(){
        contenido=' ';
    }

    public String dibujar(){
        return " "+contenido+" ";
    }
}
