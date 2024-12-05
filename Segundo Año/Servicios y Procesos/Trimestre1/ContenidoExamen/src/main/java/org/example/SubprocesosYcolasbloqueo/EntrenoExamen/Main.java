package org.example.SubprocesosYcolasbloqueo.EntrenoExamen;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        Cola cola = new Cola();

        Thread hilo = new Thread(()->{
            cola.TareaImpresion();
        });

        ExecutorService ejecutor = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++){
            ejecutor.execute(hilo);
        }
        ejecutor.shutdown();
        while(!ejecutor.isTerminated()){}

        System.out.println("Impresion Finalizada");

    }
}
