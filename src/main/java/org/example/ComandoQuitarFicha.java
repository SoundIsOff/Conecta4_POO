package org.example;

public class ComandoQuitarFicha implements Comando{
    private ComandoPonerFicha comandoPonerFicha;


    public ComandoQuitarFicha(ComandoPonerFicha comandoPonerFicha){
        this.comandoPonerFicha =  comandoPonerFicha;
    }

    @Override
    public void execute(){
        comandoPonerFicha.undo();
    }

    @Override
    public void undo() {
        comandoPonerFicha.execute();
    }

    @Override
    public void redo() {
        comandoPonerFicha.undo();
    }

    @Override
    public String getName() {
        return  " ficha eliminada";
    }


}
