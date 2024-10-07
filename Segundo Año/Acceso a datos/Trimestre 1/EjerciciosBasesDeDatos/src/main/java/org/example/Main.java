package org.example;

import java.sql.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/musica", "root", "");

            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery("SELECT nombre, duracion FROM cancion WHERE duracion > 4");

            while(resultado.next()) {
               String nombre = resultado.getString("nombre");
                System.out.println(nombre);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
         */
        GestionDB datos = new GestionDB();
        datos.gruposYDisc();
        datos.albumesPorAño();
        datos.discograficasSinArtistas();
        datos.duracionTotalGrupo(sc);
        datos.updateGrupo(sc);
        //datos.DeleteCancion(sc);



    }
}