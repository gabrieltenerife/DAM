import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        Cliente c = new Cliente();


        //Ejercicio 1
        for (int i = 0; i < 1000; i++) {
            if (Armstrong(i)) {
                System.out.println(i);
                creadorfichero(i);
            }
        }

        //Ejercicio 2
        LeerArmstrom();

        //Ejercicio 3

        cliente(sc, clientes);
        añadircliente(clientes);
        buscarcliente();

    }

    //Ejercicio 1
    public static boolean Armstrong(int numeral) {

        int total = 0;
        String numero = String.valueOf(numeral);

        for (int i = 0; i < numero.length(); i++) {
            total = (int) (total + Math.pow(Integer.parseInt(numero.charAt(i) + ""), numero.length()));
        }

        return (total == numeral);
    }

    public static void creadorfichero(int i) {
        try {
            ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream("src/Files/Datos.dat"));

            escritor.writeInt(i);
            escritor.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Ejercicio 2
    public static void LeerArmstrom() {

        try {
            DataInputStream in = new DataInputStream(new FileInputStream("src/Files/Datos.dat"));
            int numero = in.readInt();

            while (true) {
                numero = in.readInt();
                if (numero % 2 == 0) {
                    System.out.println(numero + " es par!");
                    numero = in.readInt();
                }
            }
        } catch (EOFException e) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Ejercicio 3
    public static void cliente(Scanner sc, ArrayList<Cliente> clientes) {

        int opcion;

        do {
            System.out.println("1. Introducir Cliente");
            System.out.println("2. Ver morosos");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Introduce un nombre");
                    String nombre = sc.next();
                    System.out.println("Introduce una direccion");
                    String direccion = sc.next();
                    System.out.println("Introduce un numero de cliente");
                    int numcliente = sc.nextInt();
                    System.out.println("Introduce un saldo");
                    double saldo = sc.nextDouble();

                    int cuenta;
                    do {
                        System.out.println("Introduce 1,2 o 3 si la cuenta esta al dia, tiene pagos pendientes o es deudor respectivamente");
                        cuenta = sc.nextInt();

                        try {
                            if (cuenta != 1 && cuenta != 2 && cuenta != 3) throw new Exepciones("Numero invalido");
                        } catch (Exepciones e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    } while (cuenta != 1 && cuenta != 2 && cuenta != 3);

                    Cliente c = new Cliente(cuenta, saldo, numcliente, direccion, nombre);
                    clientes.add(c);

                    break;
            }

        } while (opcion != 2);

    }

    public static void añadircliente(ArrayList<Cliente> clientes) {

        try {
            ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream("src/Files/Clientes.dat"));

            for (Cliente e : clientes) {
                escritor.writeObject(e);
            }

            escritor.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void buscarcliente() {

        ObjectInputStream lector = null;
        try {
            lector = new ObjectInputStream(new FileInputStream("src/Files/Clientes.dat"));
            Cliente c = (Cliente) lector.readObject();

            while (true) {
                if (c.getCuenta() == 3) {
                    System.out.println("El cliente " + c.getNombre() + " es un moroso!!");
                    c = (Cliente) lector.readObject();
                }
            }
        } catch (EOFException e) {
            System.out.println("Final de fichero");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                lector.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}