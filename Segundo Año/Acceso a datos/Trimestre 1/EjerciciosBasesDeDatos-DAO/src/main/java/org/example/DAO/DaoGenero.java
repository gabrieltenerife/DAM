package org.example.DAO;

import org.example.MODELO.Genero;

import java.util.ArrayList;

public interface DaoGenero {

    ArrayList<Genero>verdatos();
    int borrargGenero(int id);
    int modificargenero(int id, String nombre);
    int añadirGenero(Genero g);

}
