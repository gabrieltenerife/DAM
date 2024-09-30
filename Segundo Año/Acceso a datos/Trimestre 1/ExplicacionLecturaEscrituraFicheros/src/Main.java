import java.io.*;
import java.nio.Buffer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        leerfichero();

    }

    public static void leerfichero(){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File("src/files/southpark.txt")));
            //Hasta aqui hemos abierto la puerta del archivo
            //Leemos en bucle
            String linea = br.readLine();
            while(linea != null){
                if(linea.contains("[") && linea.contains("]")){
                    System.out.println(linea);
                }
                //SIGUE LEYENDO
                linea = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    System.err.println("Error al cerrar el fichero: " + e.getMessage());
                }
            }
        }
    }
    public static void escribirfichero(){
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("src/files/pedro.txt"));
            bw.write("Hola, Pedro.");
            bw.newLine(); // Salto de línea
            bw.write("Adiós.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el fichero: " + e.getMessage());
        } finally {
            // Cierre del BufferedWriter
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    System.err.println("Error al cerrar el fichero: " + e.getMessage());
                }
            }
        }
    }
}