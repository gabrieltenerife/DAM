package org.example.SubprocesosYcolasbloqueo.EntrenoExamen;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cola {

    Semaphore semaphore = new Semaphore(3);
    Lock lock = new ReentrantLock();
    Boolean [] impresoras = {true,true,true};




    public void TareaImpresion () {

        System.out.println("La tarea " + Thread.currentThread().getName() + "solicita impresion");
        int impresora = -1;

        try {
            semaphore.acquire();

            impresora = ocupar();
            Long tiempo = (long) (Math.random()*10000);
            System.out.println("La tarea " + Thread.currentThread().getName() + " se esta imprimiendo en la impresora " + (impresora+1) + " con un tiempo estimado de: " + tiempo);
            Thread.sleep(tiempo);


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            liberar(impresora);
            System.out.println("La tarea " + Thread.currentThread().getName() + " finaliza impresion");
            semaphore.release();
        }
    }


    public int ocupar () {

        try {
            lock.lock();

            for (int i = 0; i < impresoras.length; i++) {
                if (impresoras[i] == true) {
                    impresoras[i] = false;
                    return i;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return -1;
    }

    public void liberar (int  impresora) {

        try {

            lock.lock();
            if (impresora>=0 && impresora < impresoras.length) {
                impresoras[impresora] = true;
            }

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
