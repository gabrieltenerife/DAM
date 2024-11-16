package org.example.e1_1E;

public class Main {
    public static void main(String[] args) {
        final int NUMERO_ASIENTOS = 3;
        final int NUMERO_CLIENTES = 10;

        Peluqueria peluqueria = new Peluqueria(NUMERO_ASIENTOS);

        for (int i = 1; i <= NUMERO_CLIENTES; i++) {
            String nombreCliente = "Cliente #" + i;
            Cliente cliente = new Cliente(nombreCliente, peluqueria);
            new Thread(cliente).start();
        }
    }
}
