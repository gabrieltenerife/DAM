package org.example.DAO;

import org.example.CONEXION.Conectar;
import org.example.MODELO.Genero;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoGeneroMySQL implements DaoGenero{

    Connection con;
    Statement st;
    ResultSet rs;
    int confirm = 0;

    @Override
    public ArrayList<Genero> verdatos() {
        con = Conectar.getConexion();

        ArrayList<Genero> generos = new ArrayList<>();
        String sql = "select id, nombre from genero";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre1 = rs.getString("nombre");
                Genero g = new Genero(id,nombre1);
                generos.add(g);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            Conectar.closeConexion();
        }
        return generos;
    }

    @Override
    public int borrargGenero(int id) {
        con = Conectar.getConexion();

        String sql = "delete from genero where id = " + id;

        try {

            st = con.createStatement();
            confirm = st.executeUpdate(sql);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            Conectar.closeConexion();
        }
        return confirm;
    }

    @Override
    public int modificargenero(int id, String nombre) {
        con = Conectar.getConexion();
        String sql = "UPDATE genero set nombre = '"+nombre+"' WHERE id = "+id+";";

        try {

            st = con.createStatement();
            confirm = st.executeUpdate(sql);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                st.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            Conectar.closeConexion();
        }
        return confirm;
    }

    @Override
    public int añadirGenero(Genero g) {
        con = Conectar.getConexion();
        int id = g.getId();
        String nombre = g.getNombre();
        String sql = "INSERT INTO genero (id,nombre) VALUES ("+id+",'"+nombre+"')";

        try {

            st = con.createStatement();
            confirm = st.executeUpdate(sql);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            Conectar.closeConexion();
        }
        return confirm;
    }
}
