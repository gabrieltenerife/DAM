package org.example.Ejercicio1;

public class Cliente {
    private static int contador = 0;
    private final int id;

    public Cliente() {
        this.id = ++contador;
    }

    public int getId() {
        return id;
    }
}

