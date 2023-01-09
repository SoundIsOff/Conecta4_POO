package org.example;

/**
 * Clase comandoQuitarFicha que es contraria a comandoPonerFicha donde execute es deshacer el movimiento
 * y undo es colocar una ficha.
 */
public class ComandoQuitarFicha implements Comando{
    private ComandoPonerFicha comandoPonerFicha;


    public ComandoQuitarFicha(ComandoPonerFicha comandoPonerFicha){
        this.comandoPonerFicha =  comandoPonerFicha;
    }

    /**
     * Método que deshace el último movimiento de un jugador.
     */
    @Override
    public void execute(){
        comandoPonerFicha.undo();
    }

    /**
     * Método que pone la ficha de un jugador en el tablero.
     */
    @Override
    public void undo() {
        comandoPonerFicha.execute();
    }

    /**
     * Método que rehace el método execute, es decir, deshacer el último movimiento.
     */
    @Override
    public void redo() {
        comandoPonerFicha.undo();
    }

    @Override
    public String getName() {
        return  " ficha eliminada";
    }


}
