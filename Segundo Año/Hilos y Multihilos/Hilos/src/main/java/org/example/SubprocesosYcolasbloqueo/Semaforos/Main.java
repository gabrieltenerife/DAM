package org.example.SubprocesosYcolasbloqueo.Semaforos;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args) {

        Impresora impresora = new Impresora();

        Thread impresora1 = new Thread(()->{
            impresora.imprimir();
        });

        ExecutorService ejecutor = Executors.newCachedThreadPool();

        for(int i = 0; i < 5; i++){
            ejecutor.execute(impresora1);
            impresora1.setName(String.valueOf(i));
        }

        ejecutor.shutdown();
        while(!ejecutor.isTerminated()){}
        System.out.println("Impresion finalizada");

    }
}
