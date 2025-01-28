package org.example.entregagui.Dao;

import org.example.entregagui.Model.Lesiones;

import java.util.ArrayList;

public interface LesionesDAO {
    void añadirLesion(Lesiones lesion);
    void borrarLesion(Lesiones lesion);
    void modificarLesion(Lesiones lesion);
    ArrayList<Lesiones> listarLesiones();
}

