package org.example;
import java.awt.*;
public class Casillas {
    private Ficha ficha;
    private final int fila;
    private final int columna;
    private final String CASILLAVACIA="   ";

    public Casillas(Ficha ficha, int fila, int columna) {
        this.ficha = ficha;
        this.fila = fila;
        this.columna = columna;
    }

    public Casillas(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public boolean isVacia(){
        return ficha==null;
    }

    public String dibujar{
        if(isVacia()){
            return CASILLAVACIA;
        }else{
            return getFicha().dibujar();
        }
    }
}
