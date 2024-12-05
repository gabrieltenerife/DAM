package org.example.SubprocesosYcolasbloqueo.Semaforos;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Impresora {

    public Impresora() {
    }

    Semaphore semaphore = new Semaphore(1);

    public void imprimir () {

        System.out.println("La impresora " + Thread.currentThread().getName() + " va a imprimir");
        try {
            semaphore.acquire();

            int numero = (int) (Math.random() * 6000) + 1;
            System.out.println("----> Imprimiendo impresora " +Thread.currentThread().getName() + " durante:  " + numero);
            Thread.sleep(numero);
            System.out.println("impresora " + Thread.currentThread().getName() + " termino de imprimir");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }
}
