import javax.sql.rowset.serial.SQLOutputImpl;
import java.io.*;
import java.sql.SQLOutput;
import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Variables
        Scanner sc = new Scanner(System.in);
        //Main
        System.out.println("Introduzca la direccion de fichero: ");
        String direccion = sc.nextLine();
        EscaneoCarpeta(direccion);

    }
    //Metodos
   public static void EscaneoCarpeta (String direccion) {

       boolean algunarchivo = false;
       boolean algo = false;

       File directorio = new File(direccion);

       File[] listaCosas = directorio.listFiles();
       for (int i = 0; i < Objects.requireNonNull(listaCosas).length; i++) {
           if (listaCosas[i].getName().endsWith(".txt") || listaCosas[i].getName().endsWith(".java")) {

               BufferedReader br = null;
               try {
                   br = new BufferedReader(new FileReader(listaCosas[i]));
                   String linea = br.readLine();
                   int contador = 0;

                   while (linea != null) {
                       if (linea.toLowerCase().contains("profesor") && linea.toLowerCase().contains("gordo")) {
                           System.out.println(listaCosas[i].getName());
                           System.out.println("Encontrado en la linea: " +contador);
                           System.out.println(linea);
                           algo = true;
                       } else if (algo = false) {
                           System.out.println("Ningun archivo contiene las palabras buscadas");
                       }
                       contador++;
                       linea = br.readLine();
                   }

               } catch (IOException e) {
                   throw new RuntimeException(e);
               }

               try {
                   br.close();
               } catch (IOException e) {
                   throw new RuntimeException(e);
               }
               algunarchivo = true;
           } else if (algunarchivo = false) {
               System.out.println("Ningun archivo cumple los criterios de busqueda");
           }
       }
   }
}