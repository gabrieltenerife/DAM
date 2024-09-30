import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.RandomAccess;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


    }

    public static void escribir(){

        try {
            RandomAccessFile raf = new RandomAccessFile("fruta", "rw");

            StringBuilder sb = new StringBuilder("Perita conferencia");
            sb.setLength(15);

            raf.writeUTF(sb.toString());
            raf.writeInt(2);
            raf.writeDouble(2.4);
            raf.writeLong(54565L);

            raf.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void leer(int posicion){

        try {
            RandomAccessFile fichero = new RandomAccessFile("fruta", "rw");

            //Cada variable ocupa un numero de bites, en este caso ocupa 37 bites cada fruta.

            int numerofrutas = (int) ((fichero.length()) / 37);
            



        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}