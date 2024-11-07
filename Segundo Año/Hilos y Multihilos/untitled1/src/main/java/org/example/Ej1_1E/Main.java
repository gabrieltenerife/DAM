package org.example.Ej1_1E;

public class Main {

    private static Barberia barberia;

    public static void main(String[] args) {

        Thread hilo = new Thread(()->{
            barberia.CogerAsiento();
        });

    }
}
