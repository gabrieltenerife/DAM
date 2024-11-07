package org.example.EjercicioCuentaCorriente;

public class Cuenta {
    private int balance = 0;

    public Cuenta(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public synchronized void deposito(int valor) {
        balance += valor;
    }
}