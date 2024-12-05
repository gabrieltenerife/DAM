package org.example.HilosYSincronizacion.Interrupt;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Runnable r = new HiloStop();
        Thread hilo = new Thread(r);

        hilo.start();

        /*
        Vemos que el sleep hace esperar el thread, es decir el main, y luego ejecuta el
        interrumpt, sigue explicacion en el hilo.

        Ej: Sabemos que una tarea deberia de tardar 5 segundo, por ej si tarda 20 la interrumpimos
        y seguimos a otra cosa
         */
        Thread.sleep(5000);
        hilo.interrupt();

    }
}
