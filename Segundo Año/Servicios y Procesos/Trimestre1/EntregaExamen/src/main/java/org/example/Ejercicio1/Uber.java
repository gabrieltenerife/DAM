package org.example.Ejercicio1;

public class Uber implements Runnable {
    private final int capacidad;
    private final int id;
    private static int clientesEsperando;
    private static final Object lock = new Object();

    public Uber(int id, int capacidadInicial, int clientesTotales) {
        this.id = id;
        this.capacidad = capacidadInicial;
        clientesEsperando = clientesTotales;
    }

    @Override
    public void run() {
        while (true) {

            synchronized (lock) {
                if (clientesEsperando <= 0) {
                    System.out.println("La unidad Uber #" + id + " avisa que ya no quedan clientes. Finaliza su servicio.");
                    break;
                }

                int clientesPorRecoger = Math.min(capacidad, clientesEsperando);
                System.out.println(clientesEsperando + " clientes esperando ser recogidos.");
                System.out.println("La unidad actual es  Uber #" + id + " y tiene capacidad para " + capacidad + " pasajeros.");
                clientesEsperando -= clientesPorRecoger;

                System.out.println("----> Uber #" + id + " recogió " + clientesPorRecoger + " clientes. Clientes restantes: " + clientesEsperando+ "\n");
            }

            try {
                Thread.sleep((long) (Math.random() * (1900 - 1600) + 1600));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}