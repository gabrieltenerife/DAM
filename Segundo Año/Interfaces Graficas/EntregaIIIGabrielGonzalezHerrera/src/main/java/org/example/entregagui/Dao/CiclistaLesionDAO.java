package org.example.entregagui.Dao;

import org.example.entregagui.Model.CiclistaLesion;

import java.util.ArrayList;

public interface CiclistaLesionDAO {
    void añadirCiclistaLesion(CiclistaLesion ciclistaLesion);
    void borrarCiclistaLesion(CiclistaLesion ciclistaLesion);
    void modificarCiclistaLesion(CiclistaLesion ciclistaLesion);
    ArrayList<CiclistaLesion> listarCiclistasLesion();
}
