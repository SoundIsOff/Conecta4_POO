package org.example;



import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * clase que representa el tablero de conecta4
 * la dimensión máxima del tablero es de filaXcolumna
 * número maximo de filas y columnas vienen indicadas por numfilas y numcomunas
 */
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
    private void inicializarTablero() {
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
    private int filaFicha(int columna) {
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
    private boolean columnaLlena(int columna) {
        return !estaLibre(0, columna);
    }

    /**
     * Método que solicita al jugador una columna,
     * Comprueba que el valor no sea inválido y que la columna no esté llena,
     * Coloca la ficha.
     * @param ficha ficha del jugador en turno.
     * @param nombreJugador nombre del jugador en turno.
     */
    public void ponerFicha(Ficha ficha, String nombreJugador,Scanner scanner) {
        int columnaElegida;
        int filaFicha;
        boolean llena = false;
        boolean correcto = false;
        do {
            System.out.println(nombreJugador+"\nIntroduzca la columna (1-7): ");
            try {
                columnaElegida = scanner.nextInt();
                if (columnaElegida > 7 || columnaElegida < 1)
                    System.out.println("Valor invalido.");
                else{
                    llena = columnaLlena(columnaElegida-1);
                    if (llena){
                        System.out.println("La columna esta llena.");

                    }
                    else {
                        correcto = true;
                        filaFicha = filaFicha(columnaElegida-1);
                        casillas[filaFicha][columnaElegida-1 ].setFicha(ficha);
                    }
                }
            }
            catch (InputMismatchException exception) {
                System.out.println ("Jugador " + nombreJugador + ", valor no válido, se pide un valor entero");
                scanner.next();
            }
        } while ( !correcto || llena);
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

    /**
     * Método que comprueba si hay ganador en horizontal.
     * @param caracter caracter de la casilla en la que se ha colocado la ficha.
     * @return devuelve true si ha encontrado combinación ganadora en horizontal.
     */
    public boolean compruebaHorizontal(char caracter){
        boolean encontrado=false;
        for(int i=0;i<numfilas;i++){
            for(int j=0;j<numcolumnas-3;j++){
                if(casillas[i][j].getFicha().getContenido()==caracter&&casillas[i][j+1].getFicha().getContenido()==caracter&&
                        casillas[i][j+2].getFicha().getContenido()==caracter&&casillas[i][j+3].getFicha().getContenido()==caracter){
                    encontrado=true;
                }
            }
        }
        return encontrado;
    }

    /**
     * Método que comprueba si hay ganador en vertical.
     * @param caracter caracter de la casilla en la que se ha colocado la ficha.
     * @return devuelve true si ha encontrado combinación ganadora en vertical.
     */
    public boolean compruebaVertical(char caracter){
        boolean encontrado=false;
        for(int i=0;i<numcolumnas;i++){
            for(int j=0;j<numfilas-3;j++){
                if(casillas[j][i].getFicha().getContenido()==caracter&&casillas[j+1][i].getFicha().getContenido()==caracter&&
                        casillas[j+2][i].getFicha().getContenido()==caracter&&casillas[j+3][i].getFicha().getContenido()==caracter){
                    encontrado=true;
                }
            }
        }
        return encontrado;
    }

    /**
     * Método que comprueba si hay ganador en diagonal.
     * @param caracter caracter de la casilla en la que se ha colocado la ficha.
     * @return devuelve true si ha encontrado combinación ganadora en diagonal.
     */
    public boolean compruebaDiagonal(char caracter){
        boolean encontrado=false;
        for(int i=0;i<numcolumnas-4+1;i++){
            for(int j=0;j<numfilas-4+1;j++){
                if(casillas[j][i].getFicha().getContenido()==caracter&&casillas[j+1][i+1].getFicha().getContenido()==caracter&&
                        casillas[j+2][i+2].getFicha().getContenido()==caracter&&casillas[j+3][i+3].getFicha().getContenido()==caracter){
                    encontrado=true;
                }
            }
        }
        for(int i=numcolumnas;i>3;i--){
            for(int j=0;j<numfilas-3;j++){
                if(casillas[j][i-1].getFicha().getContenido()==caracter&&casillas[j+1][i-2].getFicha().getContenido()==caracter&&
                        casillas[j+2][i-3].getFicha().getContenido()==caracter&&casillas[j+3][i-4].getFicha().getContenido()==caracter){
                    encontrado=true;
                }
            }
        }
        return encontrado;
    }

    /**
     * Método que comprueba si hay ganador.
     * @param caracter caracter de la casilla en la que se ha colocado la ficha.
     * @return devuelve true si ha encontrado combinación ganadora en horizontal, vertical o diagonal.
     */
    public boolean compruebaGanador(char caracter){
        return compruebaHorizontal(caracter) || compruebaDiagonal(caracter) || compruebaVertical(caracter);
    }
}
