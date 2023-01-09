package org.example;

/**
 * Clase que implementa la interfaz PosicionFicha
 * para seleccionar la posicion de un jugador CPU.
 */
public class PosicionCPU implements PosicionFicha{

    private final Tablero tablero;

    public PosicionCPU(Tablero tablero) {
        this.tablero = tablero;
    }

    /**
     * @return Metodo que devuelve la columna seleccionada por el jugador CPU.
     * La colunma se selecciona de forma aleatoria con el método getRandomNumber.
     */
    public int seleccionaPosicion() {
        boolean llena;
        int columnaElegida = -1;
        do {
            columnaElegida = getRandomNumber(1, 7);
            int filaFicha;

            llena = tablero.columnaLlena(columnaElegida - 1);

            if (!llena) {
                filaFicha = tablero.filaFicha(columnaElegida - 1);
            }
        }while (llena);

        return columnaElegida;
    }

    /**
     * Método que devuelve un numero aleatorio entre un máximo y un mínimo.
     */
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
