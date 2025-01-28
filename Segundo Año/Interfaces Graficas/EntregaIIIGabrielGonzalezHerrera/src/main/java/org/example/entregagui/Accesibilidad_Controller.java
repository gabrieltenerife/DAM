package org.example.entregagui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.entregagui.Dao.CiclistasDAOImpl;
import org.example.entregagui.Dao.PelotonesDAOImpl;
import org.example.entregagui.Model.Ciclistas;
import org.example.entregagui.Model.Pelotones;

import java.io.IOException;
import java.util.ArrayList;

public class Accesibilidad_Controller {

    @FXML
    private Button Salir;

    @FXML
    private void salir() throws IOException {
        Main.setRoot("hello-view");
    }
}

