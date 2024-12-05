package org.example.SubprocesosYcolasbloqueo.EjercicioPeluqueria;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Peluqueria {
    Semaphore semaphore = new Semaphore(3);
    Lock lock = new ReentrantLock();


    public void asiento() {

        System.out.println("El cliente " + Thread.currentThread().getName() + " esta esperando asiento");

        if (semaphore.availablePermits() == 0) {
            try {
                Thread.sleep(5000);
                if (semaphore.availablePermits() == 0) {
                    System.out.println("El cliente " + Thread.currentThread().getName() + " se marcha sin ser atendido");
                } else {
                    try {
                        semaphore.acquire();
                        recortar();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        semaphore.release();
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        } else {
            try {
                semaphore.acquire();
                recortar();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }
    }

    public void recortar() {
        try {
            lock.lock();

            Long tiempo = Math.round(Math.random() * 10000);
            System.out.println("El cliente " + Thread.currentThread().getName() + " se esta recortando durante: " + tiempo);
            Thread.sleep(tiempo);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("El cliente " + Thread.currentThread().getName() + " se termino de recortar");
            lock.unlock();
        }
    }
}
