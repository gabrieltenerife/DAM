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

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public static void leerposicion(int posicion) throws IOException {
        // 0
        RandomAccessFile fichero = new RandomAccessFile("frutita","rw");
        int posBuscado = 37 * posicion;

        fichero.seek(posBuscado);
        String name = fichero.readUTF();
        int cantidad = fichero.readInt();
        double precio = fichero.readDouble();
        long fechaCad = fichero.readLong();

        fichero.close();
    }

    public static void leerFichero() throws IOException {
        // 0
        RandomAccessFile fichero = new RandomAccessFile("frutita","rw");

        int numeroFrutas = (int) (fichero.length() / 37);

        for(int i = 0; i < numeroFrutas; i++) {
            String name = fichero.readUTF();
            int cantidad = fichero.readInt();
            double precio = fichero.readDouble();
            long fechaCad = fichero.readLong();

        }

        fichero.close();
    }
}