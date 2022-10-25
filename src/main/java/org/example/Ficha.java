package org.example;

public class Ficha {
    private final char contenido;

    public Ficha(char contenido) {
        this.contenido = contenido;
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
