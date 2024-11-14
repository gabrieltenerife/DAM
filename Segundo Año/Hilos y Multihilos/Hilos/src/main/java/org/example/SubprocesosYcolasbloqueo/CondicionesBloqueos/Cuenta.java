package org.example.SubprocesosYcolasbloqueo.CondicionesBloqueos;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cuenta {

    Lock lock = new ReentrantLock();
    Condition NuevoDeposito = lock.newCondition();
    int balance = 0;

    public Cuenta() {
    }

    public int getBalance() {
        return balance;
    }

    public void ingreso(int cantidad) {

            lock.lock();
            try {

                balance += cantidad;
                System.out.println("Ingreso correcto el saldo es de " + balance);
                NuevoDeposito.signalAll();

            }catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

    }

    public void retirada(int cantidad) {
        lock.lock();
        try {

            while (balance < cantidad) {
                System.out.println("Esperando a que el saldo sea suficiente para poder retirar");
                NuevoDeposito.await();
            }

            balance -= cantidad;
            System.out.println("Saldo retirado con exito, saldo actual: " + balance);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}