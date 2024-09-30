import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        creadorfichero();
        leerFichero();

    }
    public static void creadorfichero(){
        try {
            ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream("src/Files/Datos.dat"));

            coche ferrari = new coche("Rojo", "Ferrari", "0");
            coche fiat = new coche("azul", "Fiat", "1");

            escritor.writeObject(ferrari);
            escritor.writeObject(fiat);
            escritor.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void leerFichero(){

        try {

            ObjectInputStream lector = new ObjectInputStream(new FileInputStream("src/Files/Datos.dat"));
            coche cocheleido = (coche) lector.readObject();

            while (true) {
                System.out.println(cocheleido.getMarca());
                cocheleido = (coche) lector.readObject();;
            }

        }

        //Eccepcion a mano para cuando llega a final del archivo de lectura ya que es vacio no null
        catch (EOFException e){
            System.out.println("Final fichero");
        }
        //------------------------------------------------------------------------------------------
        catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
