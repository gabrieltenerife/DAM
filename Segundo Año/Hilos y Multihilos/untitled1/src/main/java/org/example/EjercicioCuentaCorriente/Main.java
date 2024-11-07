package org.example.EjercicioCuentaCorriente;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Cuenta cuenta = new Cuenta(0);

        Thread hilo = new Thread(()->{
            cuenta.deposito(1);
        });
        Thread hilo2 = new Thread(()->{
            cuenta.deposito(1);
        });

        ExecutorService ejecutor = Executors.newCachedThreadPool();
        for (int i = 0; i < 100 ; i++) {
            ejecutor.execute(hilo);
            ejecutor.execute(hilo2);
        ;}
        ejecutor.shutdown();
        while (!ejecutor.isTerminated()) {}

        System.out.println(cuenta.getBalance());
    }
}
