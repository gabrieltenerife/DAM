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
        ArrayList <Integer> numeros = new ArrayList<Integer>();

        datos(numeros, sc);
        escribir(numeros);
        leer(sc);

    }

    public static void datos (ArrayList <Integer> numeros, Scanner sc){
        boolean salir = false;

        do{
            System.out.println("Introduzca un numero: ");
            String num = sc.nextLine();

            try {
                int numero = Integer.parseInt(num);
                numeros.add(numero);
            }
            catch (NumberFormatException e) {
                salir = true;
            }
        } while(!salir);
    }

    public static void escribir (ArrayList <Integer> numeros) {

        try {
            RandomAccessFile file = new RandomAccessFile("src/files/numeros.dat","rw");

            for (int i = 0; i < numeros.size(); i++) {
                file.writeInt(numeros.get(i));
            }
            file.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void leer (Scanner sc){

        try {
            RandomAccessFile file = new RandomAccessFile("src/files/numeros.dat","rw");

            int caracteres = (int) ((file.length())/4);
            System.out.println("Existen " + caracteres);

            System.out.println("Indica una posicion que quieras conocer el numero que contiene");
            int posicion = sc.nextInt();

            int buscar = (posicion -1) * 4;
            file.seek(buscar);
            int resultado = file.readInt();
            System.out.println("El numero en la posicion indicada es : " + resultado);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}