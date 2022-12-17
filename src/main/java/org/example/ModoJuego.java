package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ModoJuego {
    private int modo;
    private Scanner teclado = new Scanner(System.in);

    public ModoJuego(Menu menu) {
        this.modo = menu.elegirModo();
    }

    public JugadorInterface[] getModo() {
        if(modo==1) return basico();
        else if (modo==2) return entrenamiento();
        else return demo();
    }

    public static JugadorInterface[] basico(){
        Persona persona = new Persona( "RED", 'R');
        Persona persona2 = new Persona( "YELLOW",'Y');

        return new JugadorInterface[] {persona, persona2};
    }

    public static JugadorInterface[] entrenamiento(){
        Persona persona = new Persona( "RED", 'R');
        CPU cpu = new CPU( "YELLOW",'Y');

        return new JugadorInterface[] {persona, cpu};
    }

    public static JugadorInterface[] demo(){
        CPU cpu = new CPU( "RED", 'R');
        CPU cpu2 = new CPU( "YELLOW",'Y');

        return new JugadorInterface[] {cpu, cpu2};
    }












}
