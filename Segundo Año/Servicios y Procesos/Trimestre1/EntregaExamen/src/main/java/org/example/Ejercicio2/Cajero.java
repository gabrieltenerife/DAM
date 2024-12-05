package org.example.Ejercicio2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cajero {
    Semaphore semaphore = new Semaphore(2);
    Lock lock = new ReentrantLock();
    Boolean[] cajero = {true, true};

    public void retirada() {
        System.out.println("Cliente " + Thread.currentThread().getName() + " esperando para operar");
        int i = 0;
        int cliente = 0;

        try {
            semaphore.acquire();
            i = ocupar();
            System.out.println("Cliente " + Thread.currentThread().getName() + " va a retirar dinero del cajero " + (i + 1));
            System.out.println("---------- EN PROCESO --------------\n");
            Long tiempo = (long) (Math.random() * 5000);
            Thread.sleep(tiempo);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {

            System.out.println("Cliente " + Thread.currentThread().getName() + " ha retirado el dinero");
            System.out.println("---------- " + "Cajero " + (i + 1) + " disponible" + " -------------- \n");
            liberar(i);
            semaphore.release();
        }
    }

    public int ocupar() {
        try {
            lock.lock();
            for (int i = 0; i < cajero.length; i++) {
                if (cajero[i] == true) {
                    cajero[i] = false;
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

    public void liberar(int i) {
        try {
            lock.lock();
            if (i >= 0 && i < cajero.length) {
                cajero[i] = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}