package org.example.e1_1E;

import java.util.concurrent.Semaphore;

public class Peluqueria {
    private final Semaphore asientos;

    public Peluqueria(int asientosDisponibles) {
        this.asientos = new Semaphore(asientosDisponibles, true); // FIFO garantizado
    }

    public boolean intentarObtenerAsiento(String cliente) {
        System.out.println(cliente + " está intentando obtener un asiento.");
        try {
            if (asientos.tryAcquire()) {
                System.out.println(cliente + " obtuvo un asiento.");
                return true;
            } else {
                System.out.println(cliente + " no encontró asientos disponibles.");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void liberarAsiento(String cliente) {
        asientos.release();
        System.out.println(cliente + " ha liberado el asiento.");
    }
}
