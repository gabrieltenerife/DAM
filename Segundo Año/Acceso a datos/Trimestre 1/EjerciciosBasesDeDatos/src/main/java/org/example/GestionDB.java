package org.example;

import java.sql.*;
import java.util.Scanner;

public class GestionDB {
    private Conexion conexion = new Conexion();

    Scanner sc = new Scanner(System.in);
    Connection con;
    Statement st;
    ResultSet resultado;

    public void gruposYDisc (){
        con = conexion.getConnection();

        String sql = "SELECT artista.nombre as artista, discografica.nombre as discografica FROM discografica LEFT JOIN artista USING (id) ORDER BY discografica.id;";

        try {
            st = con.createStatement();
            resultado = st.executeQuery(sql);
            System.out.println(resultado);

            while(resultado.next()) {
                String nombre = resultado.getString("artista");
                String nombre2 = resultado.getString("discografica");
                System.out.println(nombre+ " " +nombre2);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                st.close();
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void albumesPorAño (){
        con = conexion.getConnection();

        String sql = "SELECT album.nombre AS nombrealbum, album.anyo AS año FROM album ORDER BY album.anyo;";

        try {
            st = con.createStatement();
            resultado = st.executeQuery(sql);
            System.out.println(resultado);

            while(resultado.next()) {
                String nombre = resultado.getString("nombrealbum");
                String nombre2 = resultado.getString("año");
                System.out.println(nombre+ " " +nombre2);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                st.close();
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void discograficasSinArtistas (){
        con = conexion.getConnection();

        String sql = "SELECT discografica.nombre as discografica FROM discografica;";

        try {
            st = con.createStatement();
            resultado = st.executeQuery(sql);
            System.out.println(resultado);

            while(resultado.next()) {
                String nombre = resultado.getString("discografica");
                System.out.println(nombre);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                st.close();
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void duracionTotalGrupo(Scanner sc){
        System.out.println("Indica un id");
        int id = sc.nextInt();

        con = conexion.getConnection();

        String sql = "SELECT cancion.duracion FROM cancion WHERE cancion.album_id = "+id+" GROUP BY cancion.album_id;";

        try {
            st = con.createStatement();
            resultado = st.executeQuery(sql);
            System.out.println(resultado);

            while(resultado.next()) {
                String nombre = resultado.getString("duracion");
                System.out.println("La duracion total de todas las canciones es de : " +nombre+ " mins");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                st.close();
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void updateGrupo(Scanner sc){
        System.out.println("Que id de artista deseas cambiar el nombre");
        int numerocol = sc.nextInt();
        System.out.println("Dime un nuevo nombre para el artista");
        String nuevoNombre = sc.next();

        con = conexion.getConnection();

        int confirmar = 0;
        String sql = "UPDATE artista set nombre = '"+nuevoNombre+"' WHERE id = "+numerocol+";";

        try {
            st = con.createStatement();
            confirmar = st.executeUpdate(sql);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                st.close();
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void DeleteCancion(Scanner sc){
        System.out.println("Dime el id del artista que quieres eliminar");
        int numerocol = sc.nextInt();

        con = conexion.getConnection();

        int confirmar = 0;
        String sql = "DELETE FROM artista WHERE id ="+numerocol+";";
        try {
            st = con.createStatement();
            confirmar = st.executeUpdate(sql);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                st.close();
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
