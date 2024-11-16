package org.example.e1_1E;

import java.util.Random;

public class Cliente implements Runnable {
    private final String nombre;
    private final Peluqueria peluqueria;

    public Cliente(String nombre, Peluqueria peluqueria) {
        this.nombre = nombre;
        this.peluqueria = peluqueria;
    }

    @Override
    public void run() {
        if (peluqueria.intentarObtenerAsiento(nombre)) {
            try {
                int tiempoAtencion = new Random().nextInt(10) + 1; // Entre 1 y 10 segundos
                System.out.println(nombre + " está siendo atendido por el barbero durante " + tiempoAtencion + " segundos.");
                Thread.sleep(tiempoAtencion * 1000L);
                System.out.println(nombre + " ha dejado la barbería.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                peluqueria.liberarAsiento(nombre);
            }
        } else {
            System.out.println(nombre + " ha dejado la barbería porque no había asientos.");
        }
    }
}
