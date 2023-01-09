package org.example;


import java.util.LinkedList;
import java.util.List;

public class ComandoPonerFicha implements Comando{
    private Jugador jugador;
    List <Ficha> fichas = new LinkedList<>();
    Ficha ficha;
    Ficha borrar;



    public ComandoPonerFicha(Jugador jugador){
       this.jugador =  jugador;
       fichas.add(jugador.getFicha());
       this.ficha = fichas.remove(fichas.size() - 1);


    }

    @Override
    public void execute(){
        jugador.ponerFicha(this.ficha);
    }

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
