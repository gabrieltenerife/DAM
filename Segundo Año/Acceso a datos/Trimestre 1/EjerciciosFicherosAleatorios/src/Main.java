import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        ArrayList<Canciones> musica = new ArrayList<Canciones>();

        /* Ejercicios 1&2
        datos(numeros, sc);
        escribir(numeros);
        leer(sc);
         */

        //Ejercicio 3

        escribirnumeros(musica, sc);
        leercancionero();
    }

    public static void datos(ArrayList<Integer> numeros, Scanner sc) {
        boolean salir = false;

        do {
            System.out.println("Introduzca un numero: ");
            String num = sc.nextLine();

            try {
                int numero = Integer.parseInt(num);
                numeros.add(numero);
            } catch (NumberFormatException e) {
                salir = true;
            }
        } while (!salir);
    }

    public static void escribir(ArrayList<Integer> numeros) {

        try {
            RandomAccessFile file = new RandomAccessFile("src/files/numeros.dat", "rw");

            for (int i = 0; i < numeros.size(); i++) {
                file.writeInt(numeros.get(i));
            }
            file.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void leer(Scanner sc) {

        try {
            RandomAccessFile file = new RandomAccessFile("src/files/numeros.dat", "rw");

            int caracteres = (int) ((file.length()) / 4);
            System.out.println("Existen " + caracteres);

            System.out.println("Indica una posicion que quieras conocer el numero que contiene");
            int posicion = sc.nextInt();

            int buscar = (posicion - 1) * 4;
            file.seek(buscar);
            int resultado = file.readInt();
            System.out.println("El numero en la posicion indicada es : " + resultado);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //EJERCICIO 3
    public static void escribirnumeros(ArrayList<Canciones> musica, Scanner sc) {

        int contador = 0;

        do{
            System.out.println("Escribe un nombre para la cancion");
            String nombre = sc.next();

            System.out.println("Escribe el nombre del disco de la cancion");
            String disco = sc.next();

            System.out.println("Escribe nombre del autor");
            String autor = sc.next();

            System.out.println("True si es española o false si no");
            boolean española = sc.nextBoolean();

            Canciones tema = new Canciones(nombre, disco, autor, española);
            musica.add(tema);

            contador++;

        }while (contador <= 2);

        try {
            RandomAccessFile file = new RandomAccessFile("src/files/cancionero.dat", "rw");
            for (Canciones c : musica) {

                StringBuffer nom = new StringBuffer(c.getNombre());
                nom.setLength(20);
                file.writeUTF(nom.toString());

                StringBuffer dis = new StringBuffer(c.getDisco());
                nom.setLength(20);
                file.writeUTF(nom.toString());

                StringBuffer au = new StringBuffer(c.getAutor());
                nom.setLength(15);
                file.writeUTF(nom.toString());

                file.writeBoolean(c.getEspañola());
            }

            file.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void leercancionero(){
        try {
            RandomAccessFile file = new RandomAccessFile("src/files/cancionero.dat", "rw");

            int tamaño = (int) (file.length() / 62);

            for(int i= 0 ; i < tamaño ; i++){
                String nombre = file.readUTF();
                String disco = file.readUTF();
                String artista = file.readUTF();
                boolean española = file.readBoolean();
                System.out.println(nombre + " " + disco + " " + artista + " " + española);
            }
            file.close();
        } catch (EOFException e) {}
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}