package org.example;

/**
 * Interfaz de comando. Enuncia los métodos execute, undo y redo.
 */
public interface Comando {
    void execute();
    void undo();
    void redo();
    String getName();
}
