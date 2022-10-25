package org.example;

public class Tablero {
    private Casillas[][] casillas;
    private final int numfilas;
    private final int numcolumnas;

    private final int INICIO=0;
    private final String CADENASEPARADORA="_____________________________";
    private final String TEXTOCABECERA="--- CONECTA 4 ---";
    private final String SEPARADORCOLUMNA="|";

    public Tablero(int numfilas, int numcolumnas) {
        this.casillas = new Casillas[this.numfilas][this.numcolumnas];
        this.numfilas = numfilas;
        this.numcolumnas = numcolumnas;
    }

    public int getNumfilas() {
        return numfilas;
    }

    public int getNumcolumnas() {
        return numcolumnas;
    }
}
