package org.example;

import java.util.Scanner;

/**
 * Clase que define el modo de juego: básico, entrenamiento o demo.
 */
public class ModoJuego {
    private int modo;
    private Scanner teclado = new Scanner(System.in);

    /**
     * Constructor de la clase ModoJuego.
     * @param menu menú del cual se va a elegir una opción para asignar el modo de juego.
     */
    public ModoJuego(Menu menu) {
        this.modo = menu.elegirModo();
    }

    /**
     * Asigna el modo de juego según la opción seleccionada.
     * @return devuelve el modo de juego.
     */
    public JugadorInterface[] getModo() {
        if(modo==1) return basico();
        else if (modo==2) return entrenamiento();
        else if(modo==3) return demo();
        else return fin();
    }

    /**
     * En el modo básico los dos jugadores son personas.
     * @return devuelve un array de jugadores en el cual los dos son personas.
     */
    public JugadorInterface[] basico(){
        return new JugadorInterface[] {new Persona( "RED", 'R'), new Persona( "YELLOW",'Y')};
    }

    /**
     * En el modo entrenamiento uno de los jugadores es una persona y el otro una CPU.
     * @return devuelve un array de jugadores en el cual el primero es una persona y el segundo una CPU.
     */
    public JugadorInterface[] entrenamiento(){
        return new JugadorInterface[] {new Persona( "RED", 'R'), new CPU( "YELLOW", 'Y')};
    }

    /**
     * En el modo demo los dos jugadores son CPU.
     * @return devuelve un array de jugadores en el cual los dos son CPU.
     */
    public JugadorInterface[] demo(){
        return new JugadorInterface[] {new CPU( "RED", 'R'), new CPU( "YELLOW",'Y')};
    }

    /**
     * Opción de fin de juego.
     * @return devuelve un array de jugadores vacio.
     */
    public JugadorInterface[] fin(){
        System.exit(0);
        return new JugadorInterface[] {};
    }












}
