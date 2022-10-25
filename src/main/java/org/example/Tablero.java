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
        inicializarTablero();
    }

    public int getNumfilas() {
        return numfilas;
    }

    public int getNumcolumnas() {
        return numcolumnas;
    }

    private void inicializarTablero(){
        int fila;
        int columna;

        for(fila=INICIO;fila<this.numfilas;fila++){
            for(columna=INICIO;columna<this.numcolumnas;columna++){
                casillas[fila][columna]=new Casillas(fila,columna);
            }
        }
    }

    private void dibujarCabecera(){
        System.out.println(this.TEXTOCABECERA);
    }

    private void dibujaSeparadorColumna(){
        int indice;
        for(indice=INICIO;indice<this.numcolumnas;indice++){
            System.out.println(this.SEPARADORCOLUMNA);
        }
    }

    private void dibujarBorde(){
        System.out.println(this.CADENASEPARADORA);
    }

    private void dibujaContenidoCasilla(String contenido){
        System.out.println(this.SEPARADORCOLUMNA+contenido);
    }

    public void dibujarFinDeFila(){
        System.out.println(this.SEPARADORCOLUMNA);
    }

    public void dibujar(){
        int fila;
        int columna;
        this.dibujarCabecera();
        this.dibujarBorde();
        for(fila=INICIO;fila<this.numfilas;fila++){
            for(columna=INICIO;columna<this.numcolumnas;columna++){
                dibujaContenidoCasilla(casillas[fila][columna].dibujar());
            }
            dibujarFinDeFila();
        }
        this.dibujarBorde();
    }


}
