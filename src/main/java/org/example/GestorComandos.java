package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que contiene los métodos de ejecutar, undo y redo
 * y utiliza las pilas para almacenar estos comandos y así usarlos posteriormente.
 */
public class GestorComandos {
    private static GestorComandos gestor = null;
    private Pila<Comando> pilaundo;
    private Pila<Comando> pilaredo;


    //singleton
    static GestorComandos getInstance() {
        if (gestor != null) {
            return gestor;
        } else {
            return new GestorComandos();
        }
    }


    public GestorComandos () {
        pilaredo = new Pila<>();
        pilaundo = new Pila<>();
    }


    /**
     * Método que apila el comando pasado como parámetro.
     * @param comando
     */
    public void execute (Comando comando) {
        comando.execute();
        pilaundo.apilar(comando);
    }


    /**
     * Método que deshace un movimiento.
     */
    public void undo() {
        if (!pilaundo.isVacia()) {
            Comando comando = pilaundo.desapilar();
            comando.undo();
            pilaredo.apilar(comando);
        }
    }

    /**
     * Método que rehace un movimiento.
     */
    public void redo() {
        if (!pilaredo.isVacia()) {
            Comando comando = pilaredo.desapilar();
            comando.execute();
            pilaundo.apilar(comando);
        }
    }

    public void vaciarUndo() {
        pilaundo.vaciar();
    }

    public void vaciarRedo() {
        pilaredo.vaciar();
    }
}
