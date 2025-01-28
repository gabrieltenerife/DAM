package org.example.entregagui;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import org.example.entregagui.Dao.PelotonesDAOImpl;
import org.example.entregagui.Model.Pelotones;
import org.example.entregagui.Model.Recorridos;

import java.io.IOException;

public class AñadirPeloton_Controller {

    @FXML
    private TextField ritmoField;

    @FXML
    private TextField nombre;

    @FXML
    private Button añadirButton;

    // Método que se ejecuta cuando se hace clic en el botón Añadir Pelotón
    @FXML
    private void añadirPeloton() throws IOException {
        // Obtener los datos introducidos en los campos
        String ritmo = ritmoField.getText();
        String name = nombre.getText();

        // Validación de los datos
        if (ritmo.isEmpty() || name == null) {
            System.out.println("Por favor, rellena todos los campos.");
        } else {

            Pelotones pelotones = new Pelotones();
            pelotones.setRitmo(ritmo);
            pelotones.setNombre(name);

            PelotonesDAOImpl pelotonesDAO = new PelotonesDAOImpl();
            pelotonesDAO.añadirPeloton(pelotones);

            salir();

        }
    }

    @FXML
    private void salir () throws IOException {
        Main.setRoot("hello-view");
    }
}

