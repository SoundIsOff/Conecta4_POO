package org.example;

public class JugadorCPU extends Jugador {

    private PosicionCPU posicion;

    public JugadorCPU ( String nombreJugador, char letraFicha){
        super(nombreJugador,letraFicha);
    }

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
