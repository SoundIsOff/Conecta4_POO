package org.example;

import java.util.Scanner;

/**
 * Clase de jugador persona que extiende la clase Persona.
 */
public class JugadorPersona extends Jugador {

    public JugadorPersona (String nombreJugador, char letraFicha){
        super(nombreJugador,letraFicha);
    }

    @Override
    public void ponerFicha(Ficha ficha) {
        tablero.ponerFicha(ficha);
    }

    @Override
    public void quitarFicha(Ficha ficha) {
        this.tablero.quitarFicha(ficha);
    }

    @Override
    public Ficha hacerFicha() {
        int columnaElegida;
        int filaSeleccionada = -1;
        boolean llena;

        do {
            PosicionPersona posicion = new PosicionPersona(nombreJugador, tablero);
            columnaElegida = posicion.seleccionaPosicion();
            llena = tablero.columnaLlena(columnaElegida-1);
            if (llena){
                System.out.printf("La columna seleccionada está llena.");
                llena = true;
            }
            else
                filaSeleccionada = tablero.filaFicha(columnaElegida-1);
        } while (llena);

        Ficha ficha = new Ficha(letraFicha, filaSeleccionada,columnaElegida);
        this.tablero.ponerFicha(ficha);
        setFicha(ficha);
        return ficha;

    }

    @Override
    public void siguienteMovimiento(GestorComandos gestor) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        System.out.println("1. Deshacer movimiento\n2. Terminar turno");
        do{
            opcion=scanner.nextInt();
        }while (opcion<1 || opcion>2);

        if(opcion==1){
            gestor.undo();
            tablero.dibujar();
            System.out.println("1. Poner nueva ficha\n2. Rehacer movimiento");
            do{
                opcion=scanner.nextInt();
            }while (opcion<1 || opcion>2);
            if(opcion==1) {
                ponerFicha(hacerFicha());
                tablero.dibujar();
            }
            else {
                gestor.redo();
                tablero.dibujar();
            }
        }

        gestor.vaciarUndo();
        gestor.vaciarRedo();

    }


}
