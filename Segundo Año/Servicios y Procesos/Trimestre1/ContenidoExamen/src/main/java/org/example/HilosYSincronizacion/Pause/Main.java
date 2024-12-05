package org.example.HilosYSincronizacion.Pause;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        /*
        //Obtener la informacion de todos los hilos que corren en la aplicacion
        Thread.getAllStackTraces().keySet().stream().forEach(thread -> {
            System.out.println(thread.getId());
            System.out.println(thread.getName());
            System.out.println(thread.getState());
            System.out.println(thread.isAlive());
            System.out.println(thread.isInterrupted());
            System.out.println("------------------------");
        });
         */


        // Esta es la manera vista en clase, creamos un hilo apartir del runnable
        Runnable tarea1 = new Hilo();
        Thread hilo = new Thread(tarea1);
        hilo.start();
        /*
        El hilo de por si tiene el sout, por lo que el siguiente sout lo que nos
        imprime es el hilo que se esta corriendo despues del ya ejecutado, el main.
         */
        System.out.println("Este hilo se llama : " + Thread.currentThread().getName());







    }
}