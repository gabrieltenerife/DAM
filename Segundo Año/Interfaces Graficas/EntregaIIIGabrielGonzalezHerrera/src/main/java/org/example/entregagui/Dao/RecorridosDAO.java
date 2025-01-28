package org.example.entregagui.Dao;

import org.example.entregagui.Model.Recorridos;

import java.util.ArrayList;

public interface RecorridosDAO {
    void añadirRecorrido(Recorridos recorrido);
    void borrarRecorrido(Recorridos recorrido);
    void modificarRecorrido(Recorridos recorrido);
    ArrayList<Recorridos> listarRecorridos();
}

