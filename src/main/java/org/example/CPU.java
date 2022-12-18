package org.example;

/**
 * Clase jugador CPU (máquina).
 * Implementa la interfaz de jugadro.
 */
public class CPU implements JugadorInterface {
    private char letraficha;
    private Tablero tablero;
    private String nombre;

    /**
     * Constructor de la clase CPU.
     * @param nombre nombre del jugador máquina.
     * @param letra carácter con el que juega el jugador CPU.
     */
    public CPU(String nombre, char letra) {
        this.nombre = nombre;
        this.letraficha = letra;
        this.tablero = null;
    }

    /**
     * Crea una ficha nueva y llama al método ponerFichaCPU
     * @param nombreJugador nombre del jugador que va a colocar la ficha.
     */
    public void ponerFicha(String nombreJugador) {
        Ficha fichaRandom = new Ficha(this.letraficha);
        this.ponerFichaCPU(fichaRandom);
    }

    /**
     * Se encarga de colocar la ficha en el tablero.
     * @param ficha ficha que se va a colocar en el tablero.
     */
    public void ponerFichaCPU(Ficha ficha){
        boolean llena;
        do {
            int columnaElegida = getRandomNumber(1, 7);
            int filaFicha;

            llena = tablero.columnaLlena(columnaElegida - 1);

            if (!llena) {
                filaFicha = tablero.filaFicha(columnaElegida - 1);
                tablero.ponerFicha(filaFicha, columnaElegida, ficha);
            }
        }while (llena);


    }

    /**
     * Genera un número aleatorio entre un rango máximo y mínimo.
     * @return devuelve el valor generado.
     */
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }


    public char getLetraficha() {
        return letraficha;
    }


    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public String getNombre() {
        return nombre;
    }




}
