package org.example;

public interface Comando {
    void execute();
    void undo();
    void redo();
    String getName();
}
