package org.example;

public abstract class Jugador {
    protected String nombreJugador;
    protected final char letraFicha;
    protected Tablero tablero;
    protected Ficha ficha;


    public Jugador(String nombreJugador, char letraFicha) {
        this.nombreJugador = nombreJugador;
        this.letraFicha = letraFicha;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public char getLetraficha() {
        return letraFicha;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

   public void setFicha(Ficha ficha){
        this.ficha=ficha;
   }

   public Ficha getFicha(){
        return  this.ficha;
   }


    public abstract void ponerFicha(Ficha ficha);
    public abstract void quitarFicha(Ficha ficha);
    public abstract Ficha hacerFicha();
    public abstract void siguienteMovimiento(GestorComandos gestor);

}
