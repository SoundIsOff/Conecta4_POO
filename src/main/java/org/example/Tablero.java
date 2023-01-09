package org.example;

/**
 * clase que representa el tablero de conecta4
 * la dimensión máxima del tablero es de filaXcolumna
 * número maximo de filas y columnas vienen indicadas por numfilas y numcomunas
 */
public class Tablero {
    public Casillas[][] casillas;
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

    /**
     * Constructor del tablero basado en el número de filas y columnas.
     * @param numfilas indica el numero maximo de filas.
     * @param numcolumnas indica el numero maximo de filas.
     */
    public Tablero(int numfilas, int numcolumnas) {
        this.numfilas = numfilas;
        this.numcolumnas = numcolumnas;
        this.casillas = new Casillas[this.numfilas][this.numcolumnas];
        inicializarTablero();
    }

    /**
     * Método que crea un tablero vacío con tantas casillas como necesite el tablero.
     */
    public void inicializarTablero() {
        int fila;
        int columna;

        for (fila = INICIO; fila < this.numfilas; fila++) {
            for (columna = INICIO; columna < this.numcolumnas; columna++) {
                casillas[fila][columna] = new Casillas(fila, columna);
            }
        }
    }

    /**
     *  Método que se encarga de dibujar un tablero.
     *  Cada columna está separada por el caracter "|".
     */
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

    /**
     * Método que dibuja una línea horizontal.
     */
    private void dibujarBorde() {
        System.out.println(this.CADENASEPARADORA);
    }

    private void dibujaContenidoCasilla(String contenido) {
        System.out.print(this.SEPARADORCOLUMNA + contenido);
    }

    /**
     * Método que escribe el caracter "|" al final de cada fila.
     */
    private void dibujaFindeFila() {
        System.out.println(this.SEPARADORCOLUMNA);
    }

    /**
     * Método que comprueba si una casilla está libre.
     */
    public boolean estaLibre(int fila, int columna) {
        return casillas[fila][columna].isVacia();
    }

    /**
     *  Método que recibe una columna y devuelve la posición de la primera fila vacía de dicha columna.
     * @param columna columna en la que se quiere colocar la ficha.
     * @return fila en la que se va a colocar la ficha dentro de la columna dada.
     */
    public int filaFicha(int columna) {
        int posicion = 0;
        int fila = numfilas - 1;
        for (int i = 0; i <= fila; i++) {
            if (casillas[i][columna].isVacia()) posicion = i;
        }
        return posicion;
    }

    /**
     * Método que recibiendo una columna comprueba si la fila de arriba está ocupada.
     * @param columna columna que se quiere comprobar.
     * @return devuelve si la columna llena o no.
     */
    public boolean columnaLlena(int columna) {
        return !estaLibre(0, columna);
    }


   public void ponerFicha(Ficha ficha){
       casillas[ficha.getFila()][ficha.getColumna()-1 ].setFicha(ficha);
   }

    public void quitarFicha(Ficha ficha){
        casillas[ficha.getFila()][ficha.getColumna()-1 ].setFicha(null);
    }

    /**
     * Método que comprueba que todas las columna están llenas.
     * @return devuelve si el tablero esta lleno o no.
     */
    public boolean tableroLleno() {
        boolean lleno;
        int fila = INICIO;
        int columna;
        do {
            columna = INICIO;
            do {
                lleno = !casillas[fila][columna].isVacia();
                columna++;
            } while ((lleno) && columna < this.numcolumnas);
            fila++;
        } while (lleno && (fila < this.numfilas));
        return lleno;
    }

}
