package org.example;


import java.util.LinkedList;
import java.util.List;

/**
 * Clase comandoPonerFicha que coloca una ficha en el tablero y deshace y rehace el último movimiento.
 */
public class ComandoPonerFicha implements Comando{
    private Jugador jugador;
    Ficha ficha;
    Ficha borrar;


    /**
     * Constructor de comandoPonerFicha.
     * @param jugador turno del jugador pasado por parámetro.
     */
    public ComandoPonerFicha(Jugador jugador){
       this.jugador =  jugador;
       this.ficha = jugador.getFicha();


    }

    /**
     * Método que pone la ficha de un jugador en el tablero.
     */
    @Override
    public void execute(){
        jugador.ponerFicha(this.ficha);
    }

    /**
     * Método que deshace el último movimiento de un jugador.
     */
    @Override
    public void undo() {
        borrar = this.ficha;
        jugador.quitarFicha(borrar);
    }

    @Override
    public void redo() {
        jugador.ponerFicha(this.ficha);
    }

    @Override
    public String getName() {
        return  jugador.getNombreJugador()+ " pone ficha";
    }



}
