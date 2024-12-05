package org.example.SubprocesosYcolasbloqueo.CondicionesBloqueos;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Cuenta cuenta = new Cuenta();

        Thread ingresar = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                cuenta.ingreso(1);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        });

        Thread retirar = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                cuenta.retirada(5);
            }
        });


        ExecutorService ejecutor = Executors.newCachedThreadPool();

        ejecutor.execute(ingresar);
        ejecutor.execute(retirar);

        ejecutor.shutdown();
        while (!ejecutor.isTerminated()) {
        }

        System.out.println("Fin");
        System.out.println(cuenta.getBalance());

    }
}
