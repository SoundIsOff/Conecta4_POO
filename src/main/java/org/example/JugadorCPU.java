package org.example;

public class JugadorCPU extends Jugador {

    /**
     * Métetodo para poder usar los parámetros de la clase Jugador.
     * @param nombreJugador
     * @param letraFicha
     */
    public JugadorCPU ( String nombreJugador, char letraFicha){
        super(nombreJugador,letraFicha);
    }



    @Override
    public void ponerFicha(Ficha ficha) {
        tablero.ponerFicha(ficha);
    }

    @Override
    public void quitarFicha(Ficha ficha){
        this.tablero.quitarFicha(ficha);
    }

    /**
     * Método que crea una ficha dándole la fila que le corresponde según la columna aleatoria que se le asigna
     * @return nueva ficha con la letra correspondiente según el jugador y la fila y columna que le toca
     */
    public Ficha hacerFicha ( ) {
        boolean llena;
        int columna;
        int fila = -1;

        do {
            PosicionCPU posicion = new PosicionCPU(tablero);
            columna = posicion.seleccionaPosicion();
            llena = tablero.columnaLlena(columna);
            if (llena){
                System.out.printf("La columna seleccionada está llena.");
                llena = true;
            }
            else
                fila = tablero.filaFicha(columna -1);
        } while (llena);

        Ficha ficha = new Ficha(letraFicha, fila, columna);
        setFicha(ficha);
        return ficha;
    }

}
