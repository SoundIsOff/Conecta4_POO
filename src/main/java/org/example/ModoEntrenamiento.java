package org.example;

public class ModoEntrenamiento implements ModoJuego{

    private Jugador[] jugadores;
    private  Turno turno;
    private Tablero tablero;
    private Arbitro arbitro;

    public ModoEntrenamiento(Tablero tablero, Arbitro arbitro) {
        this.tablero = tablero;
        this.arbitro = arbitro;
        this.jugadores = new Jugador[2];
        jugadores [0] = new JugadorPersona("RED", 'R');
        jugadores [0].setTablero(tablero);
        jugadores [1] = new JugadorCPU("YELLOW",'Y');
        jugadores [1].setTablero(tablero);
        this.turno = new Turno(jugadores);
    }

    public void jugar() {
        Jugador juega = turno.tieneTurno();
        arbitro = new Arbitro(tablero);
        boolean fin;
        tablero.dibujar();
        do {
            juega.ponerFicha();
            tablero.dibujar();
            fin=finPartida(juega);
            juega = cambiarTurno();
        } while (!fin);
        tablero.inicializarTablero();
    }
    private Jugador cambiarTurno(){
        turno.cambiaTurno();
        return turno.tieneTurno();
    }
    private boolean finPartida(Jugador jugador) {
        boolean fin=false;

        if(arbitro.compruebaGanador(jugador.getLetraficha())){
            fin=true;
            System.out.println(jugador.getNombreJugador()+" ha ganado! ");
        }else if(tablero.tableroLleno()){
            fin=true;
            System.out.println("Fin de partida. No hay ganador.");
        }

        return fin;
    }
}
