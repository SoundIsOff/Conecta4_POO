package org.example;


import java.util.Scanner;

public class JugadorPersona extends Jugador{


    public JugadorPersona (String nombreJugador, char letraFicha){
        super(nombreJugador,letraFicha);

    }
    @Override
    public void ponerFicha(Ficha ficha) {
        tablero.ponerFicha(ficha);
    }
    @Override
    public void quitarFicha(Ficha ficha){
        this.tablero.quitarFicha(ficha);

    }
    @Override
    public Ficha hacerFicha(){
        boolean llena;

        int columna;
        int fila= -1;
        do {
            PosicionPersona posicion = new PosicionPersona(nombreJugador, tablero);
            columna = posicion.seleccionaPosicion();
            llena = tablero.columnaLlena(columna -1);
            if (llena){
                System.out.printf("La columna seleccionada está llena.");
                llena = true;
            }
            else
                fila = tablero.filaFicha(columna -1);
        } while (llena);

        Ficha ficha = new Ficha(letraFicha, fila, columna);
        setFicha(ficha);
        return ficha;
    }

    @Override
    public void siguienteMovimiento(GestorComandos gestor) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        System.out.println("1. Deshacer movimiento\n2. Terminar turno");
        do {
             opcion = scanner.nextInt();
        }while (opcion<1 || opcion>2);

        if(opcion==1){
            gestor.undo();
            tablero.dibujar();
            System.out.println("1. Colocar nueva ficha\n2. Rehacer movimiento");
            do {
                opcion = scanner.nextInt();
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
