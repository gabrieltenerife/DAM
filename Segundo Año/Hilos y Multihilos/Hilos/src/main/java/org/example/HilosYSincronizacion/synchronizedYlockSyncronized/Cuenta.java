package org.example.HilosYSincronizacion.synchronizedYlockSyncronized;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cuenta {
    private int balance = 0;

    public Cuenta(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    //A la hora de sincronizar un metodo podemos hacerlo de la siguiente manera sincronizando todo el metodo:
    public synchronized void deposito(int valor) {
        balance += valor;
    }

    //Tambien podemos sincronizar solo una parte del metodo
    Lock lock = new ReentrantLock();

    public void depositarconLock(int valor) {
        lock.lock();
        try {
            if (balance + valor >= 0) {
                balance += valor;
                System.out.println("Saldo modificado (con sincronización): " + balance);
            } else {
                System.out.println("Saldo insuficiente para realizar la operación.");
            }
        } finally {
            lock.unlock();

        }
    }
}