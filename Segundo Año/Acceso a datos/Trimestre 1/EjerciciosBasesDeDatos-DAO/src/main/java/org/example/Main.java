package org.example;

import org.example.DAO.DaoGeneroMySQL;
import org.example.MODELO.Genero;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Genero> datos = new ArrayList<Genero>();
        DaoGeneroMySQL dao = new DaoGeneroMySQL();
        datos = dao.verdatos();
        for (Genero genero : datos) {
            System.out.println(genero.getId() + "y" + genero.getNombre());
        }

        Genero genero = new Genero(25,"ola");

        System.out.println(dao.modificargenero(9,"probando"));
        System.out.println(dao.añadirGenero(genero));

    }

}
