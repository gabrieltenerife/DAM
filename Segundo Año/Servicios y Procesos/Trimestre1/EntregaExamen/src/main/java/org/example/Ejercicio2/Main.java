package org.example.Ejercicio2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        Cajero cajero = new Cajero();

        Thread hiloretirada = new Thread(() -> {
                cajero.retirada();
        });

        ExecutorService ejecutor = Executors.newCachedThreadPool();
        for (int i = 0; i < 6; i++) {
            ejecutor.execute(hiloretirada);
        }

        ejecutor.shutdown();
        while (!ejecutor.isTerminated()) {
        }
        System.out.println("Banco cerrado");
    }
}