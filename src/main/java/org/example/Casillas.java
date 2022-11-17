package org.example;

public class Casillas {
    private Ficha ficha;
    private char caracter;
    private final int fila;
    private final int columna;
    private final String CASILLAVACIA = "   ";

    public Casillas(int fila, int columna) {
        this.ficha = null;
        this.fila = fila;
        this.columna = columna;
    }


    public Ficha getFicha() {
        if(ficha!=null)
        return ficha;
        else return new Ficha();
    }

    public char getCaracter() {
        return caracter;
    }

    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
        this.caracter=ficha.getContenido();
    }
    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    //Método que devuelve si la casilla está ocupada
    public boolean isVacia() {
        return ficha==null;
    }

    //Método que devuelve la representación de una casilla
    public String dibujarCasillas() {
        if (isVacia()) {
            return CASILLAVACIA;
        } else {
            return getFicha().dibujarFicha();
        }
    }
}

