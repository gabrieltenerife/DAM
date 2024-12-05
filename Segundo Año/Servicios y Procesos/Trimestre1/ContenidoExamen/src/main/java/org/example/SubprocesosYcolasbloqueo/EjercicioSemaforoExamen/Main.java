package org.example.SubprocesosYcolasbloqueo.EjercicioSemaforoExamen;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        ColaImpresion imp = new ColaImpresion();
        int impresoras = 3;

        Thread hilo = new Thread(()->{
            imp.impresion();
        });

        ExecutorService ejecutor = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++){
            ejecutor.execute(hilo);
        }

        ejecutor.shutdown();
        while(!ejecutor.isTerminated()){}
        System.out.println("Finalizado trabajo");

    }
}
