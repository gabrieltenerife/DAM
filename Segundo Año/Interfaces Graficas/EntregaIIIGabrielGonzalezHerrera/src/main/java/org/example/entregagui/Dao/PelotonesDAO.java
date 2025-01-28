package org.example.entregagui.Dao;

import org.example.entregagui.Model.Pelotones;

import java.util.ArrayList;

public interface PelotonesDAO {
    void añadirPeloton(Pelotones peloton);
    void borrarPeloton(Pelotones peloton);
    void modificarPeloton(Pelotones peloton);
    ArrayList<Pelotones> listarPelotones();
}
