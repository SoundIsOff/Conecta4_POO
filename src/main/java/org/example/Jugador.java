package org.example;
import java.util.Scanner;

public class Jugador {
    private final char letraficha;
    private Tablero tablero;
    private String nombre;

    public Jugador(char letraficha, Tablero tablero, String nombre) {
        this.letraficha = letraficha;
        this.tablero = tablero;
        this.nombre = nombre;
    }

    public Jugador(String letraficha, String nombre) {
        this.letraficha = letraficha;
        this.nombre = nombre;
    }

    public char getLetraficha() {
        return letraficha;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void poner(String jugador){
        Scanner scanner = new Scanner(System.in);
        int fila;
        int columna;
        Ficha mificha = new Ficha(this.letraficha);
        this.tablero.ponerFicha(mificha,jugador,scanner);
    }
}
