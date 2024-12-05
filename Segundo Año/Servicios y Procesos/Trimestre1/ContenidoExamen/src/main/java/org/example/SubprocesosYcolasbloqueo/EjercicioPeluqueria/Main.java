package org.example.SubprocesosYcolasbloqueo.EjercicioPeluqueria;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Peluqueria p = new Peluqueria();
        Thread hilo = new Thread (()->{
            p.asiento();
        });

        ExecutorService ejecutor = Executors.newCachedThreadPool();
        for(int i = 0; i < 10; i++){
            ejecutor.execute(hilo);
        }
        ejecutor.shutdown();
        try {
            ejecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS );
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Peluqueria cerrada");
    }
}
