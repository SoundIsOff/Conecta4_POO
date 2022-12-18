package org.example;

/**
 * Clase Casilla que se utiliza para formar el tablero.
 * La fila ni la columna serán inalterables al crearlo.
 * Cada casilla contendrá una ficha que será null de forma base (devolverá un string vacío). Se le otorgará valor
 * al asignarle un objeto ficha creado en el método poner() de la clase Jugador.
 */
public class Casillas {
    private Ficha ficha;
    private final int fila;
    private final int columna;
    private final String CASILLAVACIA = "   ";

    /**
     * Constructor de Casillas que inicia el parámetro Ficha a null.
     * Fila y columna no cambiarán una vez asignados un valor.
     * @param fila  int fila del tablero en la que está c+la casilla.
     * @param columna int columna del tablero en la que está c+la casilla.
     */
    public Casillas(int fila, int columna) {
        this.ficha = null;
        this.fila = fila;
        this.columna = columna;
    }

    /**
     * Si en la casilla hay ficha sin instanciar, devuelve una ficha vacía.
     * @return ficha objeto ficha.
     */
    public Ficha getFicha() {
        if(ficha!=null)
            return ficha;
        else return new Ficha();
    }

    /**
     * Asigna la ficha dada y su contenido a la casilla.
     * @param ficha objeto ficha.
     */
    public void setFicha(Ficha ficha) {
        this.ficha = ficha;

    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    /**
     * Devuelve si la casilla está vacía u ocupada por una ficha.
     * @return boolean true si ficha en la casilla es null y false si ficha ha sido instanciada.
     */
    public boolean isVacia() {
        return ficha==null;
    }

    /**
     * Devuelve la representación de una casilla si esta no está vacía.
     * @return String "vacío" o el contenido de ficha en caso de que esta no sea null.
     */
    public String dibujarCasillas() {
        if (isVacia()) {
            return CASILLAVACIA;
        } else {
            return getFicha().dibujarFicha();
        }
    }
}

