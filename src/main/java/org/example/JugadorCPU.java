package org.example;

/**
 * Clase jugador CPU que extiende la clase de jugador.
 */
public class JugadorCPU extends Jugador {

    private PosicionCPU posicion;

    public JugadorCPU ( String nombreJugador, char letraFicha){
        super(nombreJugador,letraFicha);
    }

    /**
     * Método para poner ficha si el jugador es una CPU.
     */
    public void ponerFicha() {
        boolean llena = false;
        int columnaElegida;
        int filaSeleccionada = -1;

        do {
            this.posicion = new PosicionCPU(tablero);
            columnaElegida = posicion.seleccionaPosicion();
            llena = tablero.columnaLlena(columnaElegida);
            if (llena){
                System.out.printf("La columna seleccionada está llena.");
                llena = true;
            }
            else
                filaSeleccionada = tablero.filaFicha(columnaElegida -1);
        } while (llena);

        Ficha ficha = new Ficha(letraFicha);
        this.tablero.ponerFicha(filaSeleccionada,columnaElegida, ficha);

    }
}
