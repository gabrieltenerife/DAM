package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ArrayList<Juego> juegos = new ArrayList<Juego>();
        ArrayList<Juego> ordenadosPorFecha = new ArrayList<Juego>();

        //EJERCICIO 1
        crearArrayJuegos(juegos);
        crearbinario(juegos);

        //EJERCICIO 2
        leerbinario(ordenadosPorFecha);
        crearaleatorioordenado(ordenadosPorFecha);

        //EJERCICIO 3
        escribirXML(ordenadosPorFecha);

        //EJERCICIO 6
        notasdispares();

    }

    //EJERCICIO 1
    /*
    Hacer una copia de seguridad del csv en un fichero binario. Llama al fichero “juegos.dat”
     */
    public static void crearArrayJuegos(ArrayList<Juego> juegos) {

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
                juegos.add(videojuego);

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

    public static void crearbinario(ArrayList<Juego> juegos) {

        try {
            ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream("src/Files/juegos.dat"));
            for (Juego j : juegos) {
                escritor.writeObject(j);
            }
            escritor.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //EJERCICIO 2
    /*
    A partir del fichero juegos.dat generado anteriormente, se pide que generes un fichero de acceso aleatorio,
    llamado juegosOrdenado.dat, los cuales se ordenen por fecha. En este caso, por un límite de 15 caracteres a los
    strings. Para ordenar el fichero, es obligatorio usar la interfaz ⦁	Comparable.
     */
    public static void leerbinario(ArrayList<Juego> OrdenadosPorFecha) {

        try {
            ObjectInputStream lector = new ObjectInputStream(new FileInputStream("src/Files/juegos.dat"));
            Juego juego = (Juego) lector.readObject();

            String fechaanterior = null;

            while (true) {

                if (fechaanterior != null) {
                    if (fechaanterior.compareTo(juego.getRelease_date()) > 0) {
                        OrdenadosPorFecha.addFirst(juego);
                    } else if (fechaanterior.compareTo(juego.getRelease_date()) < 0) {
                        OrdenadosPorFecha.addLast(juego);

                    } else {
                        OrdenadosPorFecha.addFirst(juego);
                    }
                } else {
                    OrdenadosPorFecha.add(juego);
                }

                juego = (Juego) lector.readObject();
            }

        } catch (EOFException e) {
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void crearaleatorioordenado(ArrayList<Juego> OrdenadosPorFecha) {

        try {
            RandomAccessFile file = new RandomAccessFile("src/Files/juegosOrdenado.dat", "rw");

            for (Juego juego : OrdenadosPorFecha) {
                StringBuilder nombre = new StringBuilder(juego.getGame());
                nombre.setLength(15);

                StringBuilder platform = new StringBuilder(juego.getPlatform());
                platform.setLength(15);

                StringBuilder developer = new StringBuilder(juego.getDeveloper());
                developer.setLength(15);

                StringBuilder genre = new StringBuilder(juego.getGenere());
                genre.setLength(15);

                StringBuilder numberPlayers = new StringBuilder(juego.getNumber_players());
                numberPlayers.setLength(15);

                StringBuilder rating = new StringBuilder(juego.getRating());
                rating.setLength(15);

                StringBuilder releaseDate = new StringBuilder(juego.getRelease_date());
                releaseDate.setLength(15);

                StringBuilder positiveCritics = new StringBuilder(juego.getPositive_critics());
                positiveCritics.setLength(15);

                StringBuilder neutralCritics = new StringBuilder(juego.getNeutral_critics());
                neutralCritics.setLength(15);

                StringBuilder negativeCritics = new StringBuilder(juego.getNegative_critics());
                negativeCritics.setLength(15);

                StringBuilder positiveUsers = new StringBuilder(juego.getPositive_users());
                positiveUsers.setLength(15);

                StringBuilder neutralUsers = new StringBuilder(juego.getNeutral_users());
                neutralUsers.setLength(15);

                StringBuilder negativeUsers = new StringBuilder(juego.getNegative_users());
                negativeUsers.setLength(15);

                StringBuilder metascore = new StringBuilder(juego.getMetascore());
                metascore.setLength(15);

                StringBuilder userScore = new StringBuilder(juego.getUsers_score());
                userScore.setLength(15);

                file.writeUTF(nombre.toString());
                file.writeUTF(platform.toString());
                file.writeUTF(developer.toString());
                file.writeUTF(genre.toString());
                file.writeUTF(numberPlayers.toString());
                file.writeUTF(rating.toString());
                file.writeUTF(releaseDate.toString());
                file.writeUTF(positiveCritics.toString());
                file.writeUTF(neutralCritics.toString());
                file.writeUTF(negativeCritics.toString());
                file.writeUTF(positiveUsers.toString());
                file.writeUTF(neutralUsers.toString());
                file.writeUTF(negativeUsers.toString());
                file.writeUTF(metascore.toString());
                file.writeUTF(userScore.toString());
            }

        } catch (EOFException e) {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //EJERCICIO 3
    /*
    A partir del fichero juegos.dat, generado automáticamente, se pide que generes un fichero xml en el que
    se almacenen los juegos por las plataformas.
     */

    //Para este ejercicio, reutilizare el metodo leer binario, que ya lee el archivo juegos.dat

    public static void escribirXML(ArrayList<Juego> OrdenadosPorFecha) {
        // Creamos el DocumentBuilderFactory, que es el objeto que crea objetos de clase DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document documento = null;

        try {
            // Creamos un documentBuilder utilizando la factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Creamos nuestro �rbol DOM, en este caso vac�o
            DOMImplementation dom = builder.getDOMImplementation();

            // Ahora hacemos que nuestro �rbol apunte a un documento.
            // El primer par�metro representa el namespace del fichero, dejarlo a null
            // El segundo es nuestro elemento ra�z
            // El tercero es el tipo de elemento, dejarlo a null

            documento = dom.createDocument(null, "Plataformas", null);

            // Con getDocumentElement() accedemos al elemento ra�z

            Element raiz = documento.getDocumentElement();

            /*
             * En DOM vamos a trabajar con diversos elementos:
             * Element: Corresponde a cada elemento (marcas) del documento
             * Node: Corresponde a cualquier componente del documento, puede ser textual, un elemento, un atributo...
             * Text: Se recfiere al texto que hay dentro de cada elemento
             */
            Element nodoPlataformas = null, nodoPlataforma = null, nodoJuegos = null, nodoJuego = null, nodoNombre = null, nodoDesarrollador = null;
            Text texto = null;


            /*
            ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            Automatizar meidante un array la creacion de nodos por cada consola y cambiando por "P_" en caso de que empieze por un numero ya que XML no permite que una etiqueta empieze por numero
             */

            ArrayList<String> plataformas = new ArrayList<String>();

            for (Juego juego : OrdenadosPorFecha) {
                if (juego.getPlatform().equals("platform")) {
                } else {
                    if (plataformas.contains(juego.getPlatform())) {
                    } else {
                        plataformas.add(juego.getPlatform());
                    }
                }
            }

            for (int i = 0; i < plataformas.size(); i++) {
                if (Character.isDigit(plataformas.get(i).charAt(0))) {
                    String palabra = plataformas.get(i);
                    palabra = "P_" + palabra;
                    plataformas.set(i, palabra);
                }
            }

            // ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


            for (int i = 0; i < plataformas.size(); i++) {

                //NODO PARA CADA PLATAFORMA
                nodoPlataformas = documento.createElement(plataformas.get(i));
                raiz.appendChild(nodoPlataformas);

                nodoJuegos = documento.createElement("Juegos");
                nodoPlataformas.appendChild(nodoJuegos);

                for (Juego j : OrdenadosPorFecha) {

                    if (j.getPlatform().equals(plataformas.get(i))) {

                        nodoJuego = documento.createElement("Juego");
                        nodoJuegos.appendChild(nodoJuego);

                        nodoNombre = documento.createElement("nombre");
                        nodoJuego.appendChild(nodoNombre);

                        texto = documento.createTextNode(j.getGame());
                        nodoNombre.appendChild(texto);

                        nodoDesarrollador = documento.createElement("desarrollador");
                        nodoJuego.appendChild(nodoDesarrollador);

                        texto = documento.createTextNode(j.getDeveloper());
                        nodoDesarrollador.appendChild(texto);

                    }
                }
            }

            Source source = new DOMSource(documento);
            Result resultado = new StreamResult(new File("src/Files/juegos.xml"));

            // Transformer funciona igual que Document, necesitamos una "f�brica" que cree
            // objetos de tipo Transformer, pero aqu� lo simplifico un poco m�s

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, resultado);

        } catch (
                ParserConfigurationException | TransformerException pce) {
            pce.printStackTrace();
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

        System.out.println("El juego " + nombre + " tiene " + NotaCriticos + " notas positivas de críticos y " + NotaUsuarios + " notas positivas de usuarios");
        System.out.println("El juego " + nombre1 + " tiene " + NotaCriticos1 + " notas positivas de críticos y " + NotaUsuarios1 + " notas positivas de usuarios");

    }
}
