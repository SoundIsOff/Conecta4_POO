package org.example;


public class CPU implements JugadorInterface {
    private char letraficha;
    private Tablero tablero;
    private String nombre;


    public CPU(String nombre, char letra) {
        this.nombre = nombre;
        this.letraficha = letra;
        this.tablero = null;
    }

    public void ponerFicha(String nombreJugador) {
        Ficha fichaRandom = new Ficha(this.letraficha);
        this.ponerFichaCPU(fichaRandom);
    }

    public void ponerFichaCPU(Ficha ficha){
        boolean llena;
        do {
            int columnaElegida = getRandomNumber(1, 7);
            int filaFicha;

            llena = tablero.columnaLlena(columnaElegida - 1);

            if (!llena) {
                filaFicha = tablero.filaFicha(columnaElegida - 1);
                tablero.ponerFicha(filaFicha, columnaElegida, ficha);
            }
        }while (llena);


    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }


    public char getLetraficha() {
        return letraficha;
    }


    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public String getNombre() {
        return nombre;
    }




}
