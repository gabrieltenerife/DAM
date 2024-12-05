package org.example;

import org.example.Conexion.ConexionSql;
import org.example.Model.Achievement;
import org.example.Model.Game;
import org.example.Model.Genre;
import org.example.Model.Platform;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.management.monitor.GaugeMonitorMBean;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        boolean exit = false;

        while (!exit) {
            menu();
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    crearJuego(sc);
                    break;

                case 2:
                    eliminarJuego(sc);
                    break;

                case 3:
                    añadirLogroJuego(sc);
                    break;

                case 4:
                    eliminarLogroJuego(sc);
                    break;

                case 5:
                    añadirgenero(sc);
                    break;

                case 6:
                    eliminarGenero(sc);
                    break;

                case 7:
                    añadirplataforma(sc);
                    break;

                case 8:
                    quitarplataforma(sc);
                    break;

                case 9:
                    eliminarlataforma(sc);
                    break;

                case 10:
                    consultas(sc);
                    break;

                case 0:
                    System.out.println("Hasta luego!");
                    exit = true;
                    break;

                default:
                    System.out.println("Debe seleccionar una opccion disponible \n");
            }
        }
    }

    private static void menu() {
        System.out.println("Selecciona una opcion del menu");
        System.out.println("1. Crear un juego");
        System.out.println("2. Eliminar un juego (y sus logros)");
        System.out.println("3. Añadir un logro a un juego");
        System.out.println("4. Eliminar un logro a un juego");
        System.out.println("5. Añadir genero a un juego");
        System.out.println("6. Quitar genero a un juego");
        System.out.println("7. Añadir una plataforma a un juego");
        System.out.println("8. Eliminar una plataforma a un juego");
        System.out.println("9. Eliminar una plataforma");
        System.out.println("10. Acceder a las consultas");
        System.out.println("0. Salir");
    }

    private static void crearJuego(Scanner sc) {
        Session session = ConexionSql.getConexion();
        Transaction tx = session.beginTransaction();

        System.out.println("Introduce un nombre del juego");
        String Nombre = sc.next();
        String Slug = Nombre.toLowerCase();
        System.out.println("Introduce una fecha de salida en formato xxxx-xx-xx");
        LocalDate Fecha = LocalDate.parse(sc.next());
        System.out.println("Introduce rating para el juego");
        Double Rating = sc.nextDouble();

        try {

            Game game = new Game();
            game.setName(Nombre);
            game.setSlug(Slug);
            game.setReleasedDate(Fecha);
            game.setRating(Rating);

            session.save(game);

            tx.commit();
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
    }

    public static void eliminarJuego(Scanner sc) {
        Session session = ConexionSql.getConexion();
        Transaction tx = session.beginTransaction();

        System.out.println("Introduce un id del juego");
        int id = sc.nextInt();

        try {

            Game game = session.get(Game.class, id);
            System.out.println(game.getName());
            session.delete(game);

            tx.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
    }

    public static void añadirLogroJuego(Scanner sc) {
        Session session = ConexionSql.getConexion();
        Transaction tx = session.beginTransaction();

        System.out.println("Introduce un id del juego");
        int id = sc.nextInt();
        Game juego = session.get(Game.class, id);
        if (juego != null) {

            Achievement logro = new Achievement();

            System.out.println("Introduce un nombre para el logro");
            String nombre = sc.next();
            System.out.println("Introduce un descripcion para el logro");
            sc.nextLine();
            String descripcion = sc.nextLine();

            try {

                logro.setName(nombre);
                logro.setDescription(descripcion);
                logro.setGame(juego);


                session.save(logro);

                tx.commit();
            } catch (Exception e) {
                System.out.println("Error" + e.getMessage());
                tx.rollback();
            } finally {
                session.close();
            }

        } else System.out.println("El juego no existe");
    }

    public static void eliminarLogroJuego(Scanner sc) {
        Session session = ConexionSql.getConexion();
        Transaction tx = session.beginTransaction();

        System.out.println("Introduce el id del logro");
        int idlogro = sc.nextInt();

        try {

            Achievement logro = session.get(Achievement.class, idlogro);
            session.remove(logro);

            tx.commit();
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
    }

    public static void añadirgenero(Scanner sc) {
        Session session = ConexionSql.getConexion();
        Transaction tx = session.beginTransaction();

        System.out.println("Introduce el id del juego");
        int idjuego = sc.nextInt();
        System.out.println("Introduce un id de genero para el juego");
        int genero = sc.nextInt();

        try {

            Game juego = session.get(Game.class, idjuego);
            Genre genre = session.get(Genre.class, genero);

            juego.getGenres().add(genre);

            tx.commit();
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
    }

    public static void eliminarGenero(Scanner sc) {
        Session session = ConexionSql.getConexion();
        Transaction tx = session.beginTransaction();

        System.out.println("Introduce el id del juego");
        int idjuego = sc.nextInt();
        System.out.println("Introduce un id de genero para el juego");
        int genero = sc.nextInt();

        try {

            Game juego = session.get(Game.class, idjuego);
            Genre genre = session.get(Genre.class, genero);

            juego.getGenres().remove(genre);

            tx.commit();
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
    }

    public static void añadirplataforma(Scanner sc) {
        Session session = ConexionSql.getConexion();
        Transaction tx = session.beginTransaction();

        System.out.println("Introduce el id del juego");
        int idjuego = sc.nextInt();
        System.out.println("Introduce un id de plataforma");
        int plataforma = sc.nextInt();

        try {

            Game juego = session.get(Game.class, idjuego);
            Platform plataform = session.get(Platform.class, plataforma);

            juego.getPlatforms().add(plataform);

            tx.commit();
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
    }

    public static void quitarplataforma(Scanner sc) {
        Session session = ConexionSql.getConexion();
        Transaction tx = session.beginTransaction();

        System.out.println("Introduce el id del juego");
        int idjuego = sc.nextInt();
        System.out.println("Introduce un id de plataforma");
        int plataforma = sc.nextInt();

        try {

            Game juego = session.get(Game.class, idjuego);
            Platform plataform = session.get(Platform.class, plataforma);

            juego.getPlatforms().add(plataform);

            tx.commit();
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
    }

    public static void eliminarlataforma(Scanner sc) {
        Session session = ConexionSql.getConexion();
        Transaction tx = session.beginTransaction();

        System.out.println("Introduce un id de plataforma");
        int plataforma = sc.nextInt();

        try {


            session.createQuery("delete from Gameplatform where platform.id = " + plataforma).executeUpdate();
            Platform plataform = session.get(Platform.class, plataforma);
            plataform.getGames().clear();


            tx.commit();
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            tx.rollback();
        } finally {
            session.close();
        }
    }

    public static void consultas(Scanner sc) {
        Session session = ConexionSql.getConexion();
        Transaction tx = session.beginTransaction();
        try {

            //Consulta 1:
            System.out.println("Introduce un nombre");
            String nombre = sc.next();
            ArrayList<Game> juegos = (ArrayList<Game>) session.createQuery("from Game").list();
            for (Game juego : juegos) {
                if (juego.getSlug().toLowerCase().contains(nombre.toLowerCase())) {
                    System.out.println(juego.getName());
                }
            }
            System.out.println("\n");

            //Consulta 2:
            System.out.println("Juegos lanzados antes de :");
            System.out.println("Introduce una fecha");
            String fechaleida = sc.next();
            List<Game> antesde = session.createQuery("From Game WHERE YEAR(releasedDate)<:fecha").setParameter("fecha", fechaleida).list();
            for(Game row : antesde) {
                System.out.println(row.getName());
            }
            System.out.println("\n");

            //Consulta 3:
            System.out.println("Cantidad de juegos lanzados por año:");
            List<Object[]> results = session.createQuery(
                    "SELECT year(g.releasedDate), genero.name ,COUNT(*) AS releaseCount " +
                            "FROM Game g join g.genres genero " +
                            "GROUP BY year(g.releasedDate), genero.name " +
                            "ORDER BY releaseCount DESC"
            ).list();

            for (Object[] row : results) {
                // Asumiendo que los resultados están en la forma [fecha, cantidad]
                System.out.println("Año: " + row[0] + ", Cantidad: " + row[1]);
            }
            System.out.println("\n");

            //Consulta 4:
            System.out.println("Juegos entre 2 notas");
            System.out.println("Introduce la nota maxima de los juegos");
            double notamax = sc.nextDouble();
            System.out.println("Introduce la nota minima de los juegos");
            double notamin = sc.nextDouble();

            for(Game juego : juegos) {
                if(juego.getRating()>notamin && juego.getRating()<notamax) {
                    System.out.println(juego.getName());
                }
            }
            System.out.println("\n");

            //Consulta 5
            List<Game> maslogros = session.createQuery("from Game j \n" +
                    "where size(j.achievements) = (\n" +
                    "    select max(size(j2.achievements)) \n" +
                    "    from Game j2\n" +
                    ")").list();

            for(Game row : maslogros) {
                System.out.println("Juego " + row.getName() + " tiene " + row.getAchievements().size() + " logros");
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


}