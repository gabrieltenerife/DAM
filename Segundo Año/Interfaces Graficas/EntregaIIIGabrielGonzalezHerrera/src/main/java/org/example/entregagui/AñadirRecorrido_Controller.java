package org.example.entregagui;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import org.example.entregagui.Dao.PelotonesDAOImpl;
import org.example.entregagui.Dao.RecorridosDAOImpl;
import org.example.entregagui.Model.Recorridos;

import java.io.IOException;

public class AñadirRecorrido_Controller {

    @FXML
    private TextField nombreField;

    @FXML
    private TextField distanciaField;

    @FXML
    private TextField desnivelField;

    @FXML
    private Button añadirButton;

    // Método que se ejecuta cuando se hace clic en el botón Añadir Recorrido
    @FXML
    private void añadirRecorrido() throws IOException {
        // Obtener los datos introducidos en los campos
        String nombre = nombreField.getText();
        String distancia = distanciaField.getText();
        String desnivel = desnivelField.getText();

        int dis = Integer.parseInt(distancia);
        int des = Integer.parseInt(desnivel);

        // Validación de los datos
        if (nombre.isEmpty() || distancia.isEmpty() || desnivel.isEmpty()) {
            showAlert("Error", "Por favor, rellena todos los campos.");
        } else {

            Recorridos recorridos = new Recorridos();
            recorridos.setNombre(nombre);
            recorridos.setDistancia(dis);
            recorridos.setDesnivel(des);

            RecorridosDAOImpl recorridosDAO = new RecorridosDAOImpl();
            recorridosDAO.añadirRecorrido(recorridos);

            salir();

        }
    }

    @FXML
    private void salir () throws IOException {
        Main.setRoot("hello-view");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);  // Puedes agregar un encabezado si lo deseas
        alert.setContentText(message);
        alert.showAndWait();
    }
}

