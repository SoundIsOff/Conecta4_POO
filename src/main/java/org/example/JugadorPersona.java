package org.example;

import java.util.Scanner;

/**
 * Clase de jugador persona que extiende la clase Persona.
 */
public class JugadorPersona extends Jugador {

    /**
     * Métetodo para poder usar los parámetros de la clase Jugador.
     * @param nombreJugador
     * @param letraFicha
     */
    public JugadorPersona (String nombreJugador, char letraFicha){
        super(nombreJugador,letraFicha);
    }

    @Override
    public void ponerFicha(Ficha ficha) {
        tablero.ponerFicha(ficha);
    }

    @Override
    public void quitarFicha(Ficha ficha) {
        this.tablero.quitarFicha(ficha);
    }

    /**
     * Método que crea una ficha dándole la fila que le corresponde según la columna elegida y la asigna a cada jugador.
     * @return nueva ficha con la letra correspondiente según el jugador y la fila y columna que le toca
     */
    @Override
    public Ficha hacerFicha() {
        int columnaElegida;
        int filaSeleccionada = -1;
        boolean llena;

        do {
            PosicionPersona posicion = new PosicionPersona(nombreJugador, tablero);
            columnaElegida = posicion.seleccionaPosicion();
            llena = tablero.columnaLlena(columnaElegida-1);
            if (llena){
                System.out.printf("La columna seleccionada está llena.");
                llena = true;
            }
            else
                filaSeleccionada = tablero.filaFicha(columnaElegida-1);
        } while (llena);

        Ficha ficha = new Ficha(letraFicha, filaSeleccionada,columnaElegida);
        setFicha(ficha);
        return ficha;

    }

}
