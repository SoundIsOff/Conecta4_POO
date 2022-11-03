package org.example;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Tablero {
    private Casillas[][] casillas;
    private final int numfilas;
    private final int numcolumnas;

    private final int INICIO = 0;
    private final String CADENASEPARADORA = "_____________________________";
    private final String SEPARADORCOLUMNA = "|";

    public int getNumfilas() {
        return numfilas;
    }

    public int getNumcolumnas() {
        return numcolumnas;
    }

    //Constructor del tablero basado en el número de filas y columnas
    public Tablero(int numfilas, int numcolumnas) {
        this.numfilas = numfilas;
        this.numcolumnas = numcolumnas;
        this.casillas = new Casillas[this.numfilas][this.numcolumnas];
        inicializarTablero();
    }

    //Método que crea un tablero vacío con tantas casillas como necesite el tablero
    private void inicializarTablero() {
        int fila;
        int columna;

        for (fila = INICIO; fila < this.numfilas; fila++) {
            for (columna = INICIO; columna < this.numcolumnas; columna++) {
                casillas[fila][columna] = new Casillas(fila, columna);
            }
        }
    }

    //Método que se encarga de dibujar un tablero
    // Cada columna está separada por el caracter "|"
    public void dibujar() {
        int fila;
        int columna;
        this.dibujarBorde();
        for (fila = INICIO; fila < this.numfilas; fila++) {
            for (columna = INICIO; columna < this.numcolumnas; columna++) {
                dibujaContenidoCasilla(casillas[fila][columna].dibujarCasillas());
            }
            dibujaFindeFila();
        }
        this.dibujarBorde();
    }

    //Método que dibuja una línea horizontal
    private void dibujarBorde() {
        System.out.println(this.CADENASEPARADORA);
    }

    private void dibujaContenidoCasilla(String contenido) {
        System.out.print(this.SEPARADORCOLUMNA + contenido);
    }

    //Método que escribe el caracter "|" al final de cada fila
    private void dibujaFindeFila() {
        System.out.println(this.SEPARADORCOLUMNA);
    }

    //Método que comprueba si una casilla está libre
    public boolean estaLibre(int fila, int columna) {
        return casillas[fila][columna].isVacia();
    }

    //Método que recibe una columna y devuelve la posición de la primera fila vacía de dicha columna
    private int filaFicha(int columna) {
        int posicion = 0;
        int fila = numfilas - 1;
        for (int i = 0; i <= fila; i++) {
            if (casillas[i][columna].isVacia()) posicion = i;
        }
        return posicion;
    }

    //Método que recibiendo una columna comprueba si la fila de arriba está ocupada
    private boolean columnaLlena(int columna) {
        return !estaLibre(0, columna);
    }

    //Método que solicita al jugador una columna
    //Comprueba que el valor no sea inválido y que la columna no esté llena
    //Coloca la ficha
    public void ponerFicha(Ficha ficha, String jugador,Scanner scanner) {
        int columnaElegida= -1;
        int filaFicha;
        boolean llena = false;
        do {
            System.out.println(jugador+"\nIntroduzca la columna (1-7): ");
            columnaElegida = scanner.nextInt();
            if (columnaElegida > 7 || columnaElegida < 1)
                System.out.println("Valor invalido.");
            else{
                llena = columnaLlena(columnaElegida-1);
                if (llena){
                    System.out.println("La columna esta llena.");

                }
                else {
                    filaFicha = filaFicha(columnaElegida-1);
                    casillas[filaFicha][columnaElegida-1 ].setFicha(ficha);
                }
            }
        } while (columnaElegida > (numcolumnas) || columnaElegida < 1 || llena);
    }

    //Método que comprueba que todas las columna están llenas
    public boolean tableroLleno() {
        boolean lleno = true;
        int fila = INICIO;
        int columna;
        do {
            columna = INICIO;
            do {
                lleno = !casillas[fila][columna].isVacia();
                columna++;
            } while ((lleno) && columna < this.numcolumnas);
            fila++;
        } while ((lleno) && (fila < this.numfilas));
        return lleno;
    }
}
