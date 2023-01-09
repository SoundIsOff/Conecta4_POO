package org.example;

import java.util.LinkedList;
import java.util.List;

public class Pila <T> {
    private List<T> colecciondatos;

    public Pila() {
        colecciondatos = new LinkedList<>();
    }
    public void apilar (T elemento) {
        colecciondatos.add(0, elemento);
    }

    public T desapilar() {
        if (colecciondatos.size() > 0) {

            return colecciondatos.remove(colecciondatos.size() - 1);

        }
        else
            return null;
    }

    public boolean isVacia() {
        return colecciondatos.size() == 0;
    }

    public void vaciar() {
        colecciondatos.clear();
    }
}
