package org.example;

import java.util.ArrayList;
import java.util.List;

public class GestorComandos {
    private static GestorComandos gestor = null;
    private Pila<Comando> pilaundo;
    private Pila<Comando> pilaredo;
    private List<String> historiadecomandos;


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
        historiadecomandos = new ArrayList<>();
    }



    public void execute (Comando comando) {
        comando.execute();
        pilaundo.apilar(comando);

        historiadecomandos.add(comando.getName());
    }


    public void undo() {
        if (!pilaundo.isVacia()) {
            Comando comando = pilaundo.desapilar();
            comando.undo();
            pilaredo.apilar(comando);
            historiadecomandos.add(comando.getName());
        }
    }

    public void redo() {
        if (!pilaredo.isVacia()) {
            Comando comando = pilaredo.desapilar();
            comando.execute();
            pilaundo.apilar(comando);
            historiadecomandos.add(comando.getName());
        }
    }

    public void vaciarUndo() {
        pilaundo.vaciar();
    }

    public void vaciarRedo() {
        pilaredo.vaciar();
    }

    public List<String> getHistoriaComandos() {
        return historiadecomandos;
    }
}
