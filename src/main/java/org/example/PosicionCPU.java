package org.example;

public class PosicionCPU implements PosicionFicha{

    private final Tablero tablero;

    public PosicionCPU(Tablero tablero) {
        this.tablero = tablero;
    }

    public int seleccionaPosicion() {
        return columnaCPU();
    }

    public int columnaCPU(){
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

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
