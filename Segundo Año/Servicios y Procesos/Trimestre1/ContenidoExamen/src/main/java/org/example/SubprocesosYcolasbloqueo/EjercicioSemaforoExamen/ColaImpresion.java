package org.example.SubprocesosYcolasbloqueo.EjercicioSemaforoExamen;


import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ColaImpresion {

    static Semaphore semaforo = new Semaphore(3);
    static Lock lock = new ReentrantLock();
    Boolean [] impresorasDisponibles = {true,true,true};

    public Boolean[] getImpresorasDisponibles() {
        return impresorasDisponibles;
    }

    public void setImpresorasDisponibles(Boolean[] impresorasDisponibles) {
        this.impresorasDisponibles = impresorasDisponibles;
    }

    public void impresion() {

        int Numeroimpresora = -1;
        System.out.println("La tarea" + Thread.currentThread().getName() + " va a solicitar impresion");

        try {
            semaforo.acquire();

            Numeroimpresora = ocuparimpresora(impresorasDisponibles);
            Long tiempo = (long) (Math.random() * 10000);
            System.out.println("La tarea" + Thread.currentThread().getName() + " se esta imprimiendo en la impresora: " + (Numeroimpresora + 1) + " Tiempo: " + tiempo);
            Thread.sleep(tiempo);
            liberarImpresora(Numeroimpresora);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("La tarea" + Thread.currentThread().getName() + " finalizo la impresion");
            semaforo.release();
        }
    }

    public static int ocuparimpresora (Boolean [] impresorasDisponibles){
        try {
            lock.lock();

            for(int i=0;i<impresorasDisponibles.length;i++){
                if(impresorasDisponibles[i]){
                    impresorasDisponibles[i]=false;
                    return i;
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return -1;
    }

    private void liberarImpresora(int numeroImpresora) {
        lock.lock(); // Bloquea la sección crítica.
        try {
            if(numeroImpresora >= 0 && numeroImpresora < impresorasDisponibles.length){
                impresorasDisponibles[numeroImpresora] = true;
            }
        } finally {
            lock.unlock(); // Libera el bloqueo.
        }
    }
}
