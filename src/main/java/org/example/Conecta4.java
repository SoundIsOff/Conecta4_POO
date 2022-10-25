package org.example;

public class Conecta4 {
    private Turno turno;
    private Jugador[] jugadores;
    private Tablero tablero;
    private final int NUMJUGADORES=2;
    private final int INICIOBUCLE=0;
    private static final String BIENVENIDA="--- CONECTA 4 ---";

    public Conecta4(Jugador[] jugadores) {
        this.jugadores = jugadores;
        this.tablero = tablero;
        this.turno = new Turno(this.jugadores);
        actualizaTableroEnJugadores(this.tablero);
    }

    private void actualizaTableroEnJugadores(Tablero tablero){
        for(int indice=INICIOBUCLE;indice<NUMJUGADORES;indice++){
            jugadores[indice].setTablero(tablero);
        }
    }

    private Jugador cambiarTurno(){
        turno.cambiaTurno();
        return turno.tieneturno();
    }

    private boolean finPartida(){
        return tablero.tableroLleno();
    }

    public void jugar(){
        Jugador juega=turno.tieneturno();
        tablero.dibujar();

        do{
            juega.poner(turno.nombreJugadorConTurno());
            tablero.dibujar();
            juega=cambiarTurno();
        }while(!finPartida());
        System.out.println("Fin de partida");
    }

    public static void main(String[] args){
        Jugador jugador1=new Jugador("Jugador1", "R");
        Jugador jugador2=new Jugador("Jugador2", "B");
        System.out.println(BIENVENIDA);
        Jugador[] jugadores=new Jugador[]{jugador1,jugador2};
        Conecta4 conecta4=new Conecta4(jugadores);
        conecta4.jugar();

    }
}
