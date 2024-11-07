package org.example.Wait;

public class Main {
    public static void main(String[] args) {

        Runnable r = new Hilo();
        Thread hilo = new Thread(r);

        /*
        .join asegura que el hilo o hilos se terminaran de ejecutar antes de continuar la
        ejecuccion del main. Si lo quitamos vemos como imprime el nombre del hilo main en algun
        momento de la ejecuccion del hilo.
         */
        try {
            hilo.start();
            hilo.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName());


    }
}
