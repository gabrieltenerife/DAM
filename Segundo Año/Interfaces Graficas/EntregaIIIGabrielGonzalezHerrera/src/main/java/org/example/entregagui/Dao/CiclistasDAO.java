package org.example.entregagui.Dao;

import org.example.entregagui.Model.Ciclistas;

import java.util.ArrayList;


public interface CiclistasDAO {
    void añadirCiclista(Ciclistas ciclista);
    void borrarCiclista(Ciclistas ciclista);
    void modificarCiclista(Ciclistas ciclista);
    ArrayList<Ciclistas> listarCiclistas();
}