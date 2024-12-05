package org.example.Ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        final int TOTAL_CLIENTES = (int) (Math.random() * (90 - 60) + 60);
        final int CAPACIDAD_UBER = 9;
        final int NUMERO_UBER = 3;

        System.out.println("Total de clientes esperando al inicio: " + TOTAL_CLIENTES);

        List<Thread> buses = new ArrayList<>();
        for (int i = 1; i <= NUMERO_UBER; i++) {
            Uber bus = new Uber(i, CAPACIDAD_UBER, TOTAL_CLIENTES);
            Thread hilo = new Thread(bus);
            buses.add(hilo);
        }

        for (Thread bus : buses) {
            bus.start();
        }

        for (Thread bus : buses) {
            try {
                bus.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Fin de transporte");
    }
}
