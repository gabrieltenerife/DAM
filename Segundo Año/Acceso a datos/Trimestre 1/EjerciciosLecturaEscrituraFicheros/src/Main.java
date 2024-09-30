import java.io.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //EJERCICIO 1
        for(int i = 2; i <= 500 ; i++){
            if(primo(i)){
                escribir(i);
            }
        }

        //EJERCiCIO 2
       leer();

        //EJERCICIO 3
       escribir(SumarParRestarInpar());

        //EJERCICIO 4
       leerfichero2();

        //Ejercicio 7
        LecturaEscritura(sc);
    }

    /*
    * ---------------------------------------------------------------------------------
    * METODOS
    * ---------------------------------------------------------------------------------
    * */

    //EJERCICIO 1
    public static boolean primo(int numero){
        for(int i=2;i<numero;i++) {
            if(numero%i==0)
                return false;
        }
        return true;
    }

    public static void escribir(int numero){
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("src/files/lista.txt", true));
            bw.write(String.valueOf(numero));
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //Ejercicio 2
    public static void leer (){
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("src/files/lista.txt"));
            String linea = br.readLine();
            while(linea != null) {
                System.out.println(linea);
                linea = br.readLine();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        finally {
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    //EJERCICIO 3
    public static int SumarParRestarInpar(){
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("src/files/lista.txt"));
            String linea = br.readLine();
            int numero = Integer.parseInt(linea);
            int total = 0;

            while(linea != null) {
                if (numero % 2 == 0) {
                    total = total + numero;
                }
                else total = total - numero;
                linea = br.readLine();
            }
            return total;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        finally {
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    //EJERCICIO 4
    public static void leerfichero2 (){

        BufferedReader br = null;
        BufferedReader br2 = null;

        try {
            br = new BufferedReader(new FileReader("src/files/lista.txt"));
            br2 = new BufferedReader(new FileReader("src/files/southpark.txt"));
            String linea = br.readLine();
            String linea2 = br2.readLine();

            while(linea != null && linea2 != null) {

                    System.out.println(linea);
                    linea = br.readLine();

                    System.out.println(linea2);
                    linea2 = br2.readLine();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        finally {
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(br2 != null) {
                try {
                    br2.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    //Ejercicio 7
    public static void LecturaEscritura (Scanner sc) {

        System.out.println("Escribe el nombre de un personaje:");
        String nombre = sc.nextLine();

        BufferedReader br = null;
        BufferedWriter bw = null;

        try {

            br = new BufferedReader(new FileReader("src/files/southpark.txt"));
            bw = new BufferedWriter(new FileWriter("src/files/"+nombre+".txt", true));

            String linea = br.readLine();

            while(linea != null) {
                if(linea.length()==nombre.length()) {
                    if(linea.contains(nombre)) {
                        linea = br.readLine();
                        bw.write(linea);
                        bw.newLine();
                    }
                }
                linea = br.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            bw.close();
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}//Noto
