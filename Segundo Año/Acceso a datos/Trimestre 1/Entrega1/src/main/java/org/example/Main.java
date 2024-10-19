package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ArrayList<Juego> Juegos = new ArrayList<Juego>();

        //EJERCICIO 1
        crearArrayJuegos(Juegos);
        crearBinario(Juegos);

        //EJERCICIO 2
        notasdispares();
    }

    //EJERCICIO 1
    public static void crearArrayJuegos(ArrayList<Juego> Juegos) {

        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(new File("src/Files/metacritic_games.csv")));
            String linea = br.readLine();

            while (linea != null) {

                ArrayList<String> listaDatos = new ArrayList<String>();
                String[] listaValores = linea.split(";");
                listaDatos.addAll(Arrays.asList(listaValores));

                int i = 0;
                String game = listaDatos.get(i);
                String platform = listaDatos.get(i + 1);
                String developer = listaDatos.get(i + 2);
                String genere = listaDatos.get(i + 3);
                String number_players = listaDatos.get(i + 4);
                String rating = listaDatos.get(i + 5);
                String release_date = listaDatos.get(i + 6);
                String positive_critics = listaDatos.get(i + 7);
                String neutral_critics = listaDatos.get(i + 8);
                String negative_critics = listaDatos.get(i + 9);
                String positive_users = listaDatos.get(i + 10);
                String neutral_users = listaDatos.get(i + 11);
                String negative_users = listaDatos.get(i + 12);
                String metascore = listaDatos.get(i + 13);
                String users_score = listaDatos.get(i + 14);

                Juego videojuego = new Juego(game, platform, developer, genere, number_players, rating, release_date,
                        positive_critics, neutral_critics, negative_critics,
                        positive_users, neutral_users, negative_users, metascore, users_score);
                Juegos.add(videojuego);

                linea = br.readLine();

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void crearBinario(ArrayList<Juego> juegos) {

        try {
            ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream("src/Files/juegos.dat"));

            for (Juego j : juegos) {
                escritor.writeObject(j);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    //EJERCICIO 2
    public static void crearaleatorioordenado() {


        try {
            ObjectInputStream lector = new ObjectInputStream(new FileInputStream("src/Files/juegos.dat"));
            Juego juego = (Juego) lector.readObject();
            while (true) {

                String game = juego.getGame();
                String platform = juego.getPlatform();
                String developer = juego.getDeveloper();
                String genre = juego.getGenere();
                String numberPlayers = juego.getNumber_players();
                String rating = juego.getRating();
                String releaseDate = juego.getRelease_date();
                String positiveCritics = juego.getPositive_critics();
                String neutralCritics = juego.getNeutral_critics();
                String negativeCritics = juego.getNegative_critics();
                String positiveUsers = juego.getPositive_users();
                String neutralUsers = juego.getNeutral_users();
                String negativeUsers = juego.getNegative_users();
                String metascore = juego.getMetascore();
                String userScore = juego.getUsers_score();


                juego = (Juego) lector.readObject();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //EJERCICIO 6
    public static void notasdispares() {

        String nombre = "";
        String NotaUsuarios = "";
        String NotaCriticos = "";
        String nombre1 = "";
        String NotaUsuarios1 = "";
        String NotaCriticos1 = "";

        int disparCritico = 0;
        int disparUsuarios = 0;

        ObjectInputStream lector = null;
        try {
            lector = new ObjectInputStream(new FileInputStream("src/Files/juegos.dat"));
            Juego juego = (Juego) lector.readObject();

            while (true) {

                if (juego.getGame().equals("game")) {
                    disparUsuarios = 0;
                } else {
                    int Upositivas = Integer.parseInt(juego.getPositive_critics());
                    int Uneutrales = Integer.parseInt(juego.getNeutral_critics());
                    int Unegativas = Integer.parseInt(juego.getNegative_critics());

                    int Utotales = Upositivas + Uneutrales + Unegativas + 1;
                    int Uresultadopositivo = (Upositivas * 100) / Utotales;
                    int Uresultadonegativo = (Unegativas * 100) / Utotales;


                    int Cpositivas = Integer.parseInt(juego.getPositive_users());
                    int Cneutrales = Integer.parseInt(juego.getNeutral_users());
                    int Cnegativas = Integer.parseInt(juego.getNegative_users());

                    int Ctotales = Cnegativas + Cpositivas + Cneutrales + 1;
                    int Cresultadopositivo = (Cpositivas * 100) / Ctotales;
                    int Cresultadonegativo = (Cnegativas * 100) / Ctotales;


                    //Para mucha más nota de los usuarios que de los críticos.
                    int variable = Uresultadopositivo - Uresultadonegativo;
                    int variable1 = Cresultadopositivo - Cresultadonegativo;
                    int total = variable - variable1;
                    int total2 = variable1 - variable;

                    if (total > disparUsuarios) {
                        disparUsuarios = total;
                        nombre = juego.getGame();
                        NotaUsuarios = juego.getPositive_users();
                        NotaCriticos = juego.getPositive_critics();
                    }

                    if (total2 > disparCritico) {
                        disparCritico = total;
                        nombre1 = juego.getGame();
                        NotaUsuarios1 = juego.getPositive_users();
                        NotaCriticos1 = juego.getPositive_critics();
                    }


                    juego = (Juego) lector.readObject();
                }
                juego = (Juego) lector.readObject();

            }


        } catch (EOFException e) {
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("El juego " + nombre + " tiene tan solo " + NotaUsuarios + " notas positivas de criticos y tiene " + NotaCriticos + " notas positivas de usuarios");
        System.out.println("El juego " + nombre1 + " tiene " + NotaUsuarios1 + " notas positivas de criticos y tiene tan solo " + NotaCriticos1 + " notas positivas de usuarios");

    }
}