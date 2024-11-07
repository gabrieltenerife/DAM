package org.example.Pause;

public class Hilo implements Runnable {
    @Override
    public void run() {

        /*
        En este for lo que hacemos en entre cada iteracion pausar durante 1 segundo la ejecuccion del hilo
        Ej: tenemos un maximo de peticiones en una api por minuto
         */
        for (int i = 0; i < 10; i++) {
            System.out.println("Contador" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }



        System.out.println("Este hilo se llama " + Thread.currentThread().getName());
    }
}
