package org.example;

/**
 * Clase de jugador persona que extiende la clase Persona.
 */
public class JugadorPersona extends Jugador {

    private PosicionPersona posicion;

    public JugadorPersona (String nombreJugador, char letraFicha){
        super(nombreJugador,letraFicha);
    }


    /**
     * Metodo para colocar una ficha si el jugador es una perosna.
     */
    public void ponerFicha() {
        int columnaElegida;
        int filaSeleccionada = -1;
        boolean llena = false;

        do {
            this.posicion = new PosicionPersona(nombreJugador,tablero);
            columnaElegida = posicion.seleccionaPosicion();
            llena = tablero.columnaLlena(columnaElegida-1);
            if (llena){
                System.out.printf("La columna seleccionada está llena.");
                llena = true;
            }
            else
                filaSeleccionada = tablero.filaFicha(columnaElegida-1);
        } while (llena);

        Ficha ficha = new Ficha(letraFicha);
        this.tablero.ponerFicha(filaSeleccionada,columnaElegida, ficha);


    }
}
