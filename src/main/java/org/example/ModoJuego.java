package org.example;

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
        else if(modo==3) return demo();
        else return fin();
    }

    public JugadorInterface[] basico(){
        return new JugadorInterface[] {new Persona( "RED", 'R'), new Persona( "YELLOW",'Y')};
    }

    public JugadorInterface[] entrenamiento(){
        return new JugadorInterface[] {new Persona( "RED", 'R'), new CPU( "YELLOW", 'Y')};
    }

    public JugadorInterface[] demo(){
        return new JugadorInterface[] {new CPU( "RED", 'R'), new CPU( "YELLOW",'Y')};
    }

    public JugadorInterface[] fin(){
        System.exit(0);
        return new JugadorInterface[] {};
    }












}
