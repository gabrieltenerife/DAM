package org.example.entregagui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.entregagui.Dao.CiclistasDAOImpl;
import org.example.entregagui.Dao.PelotonesDAOImpl;
import org.example.entregagui.Model.Ciclistas;
import org.example.entregagui.Model.Pelotones;

import java.io.IOException;
import java.util.ArrayList;

public class AñadirCiclista_Controller {

    private PelotonesDAOImpl pelotonesDAO = new PelotonesDAOImpl();
    public ArrayList<Pelotones> pelotones = pelotonesDAO.listarPelotones();

    @FXML
    private TextField nombreField;

    @FXML
    private TextField apellidoField;

    @FXML
    private ComboBox<String> lesionesComboBox;

    @FXML
    private Button añadirButton;

    @FXML
    private RadioButton trekRadio;

    @FXML
    private RadioButton meganoRadio;

    @FXML
    private RadioButton otraRadio;

    @FXML
    private CheckBox federacionCheck;

    @FXML
    private ToggleGroup bicicletaGroup;

    @FXML
    public void initialize() {
        // Llenar el ComboBox con los nombres de los ciclistas
        for (Pelotones peloton : pelotones) {
            lesionesComboBox.getItems().add(String.valueOf(peloton.getId()));
        }

        // Crear y asignar el grupo de radio buttons
        bicicletaGroup = new ToggleGroup();
        trekRadio.setToggleGroup(bicicletaGroup);
        meganoRadio.setToggleGroup(bicicletaGroup);
        otraRadio.setToggleGroup(bicicletaGroup);
    }

    // Método que se ejecuta cuando se hace clic en el botón Añadir Ciclista
    @FXML
    private void añadirCiclista() throws IOException {
        // Obtener los datos introducidos en los campos
        String nombre = nombreField.getText();
        String apellido = apellidoField.getText();
        String bicicleta = obtenerBicicletaSeleccionada(); // Obtener la bicicleta seleccionada
        String peloton = lesionesComboBox.getValue();
        String lesiones = lesionesComboBox.getValue();

        // Validar que el usuario haya marcado el check y que todos los campos estén completos
        if (nombre.isEmpty() || apellido.isEmpty() || bicicleta.isEmpty() || peloton == null || lesiones == null || !federacionCheck.isSelected()) {
            System.out.println("Por favor, rellena todos los campos y marca el check para continuar.");
        } else {

            Ciclistas ciclistas = new Ciclistas();

            PelotonesDAOImpl pelotonesDAO = new PelotonesDAOImpl();
            ArrayList<Pelotones> pelotones = pelotonesDAO.listarPelotones();
            for (Pelotones p : pelotones) {
                if (p.getId() == Integer.parseInt(peloton)) {
                    ciclistas.setPelotones(p);
                }
            }

            ciclistas.setNombre(nombre);
            ciclistas.setApellido(apellido);
            ciclistas.setBicicleta(bicicleta);

            CiclistasDAOImpl ciclistasDAO = new CiclistasDAOImpl();
            ciclistasDAO.añadirCiclista(ciclistas);

            salir();
        }
    }

    // Método para obtener la bicicleta seleccionada
    private String obtenerBicicletaSeleccionada() {
        if (trekRadio.isSelected()) {
            return "Trek";
        } else if (meganoRadio.isSelected()) {
            return "Megano";
        } else if (otraRadio.isSelected()) {
            return "Otra";
        } else {
            return ""; // En caso de que no se haya seleccionado ninguna opción
        }
    }

    @FXML
    private void salir() throws IOException {
        Main.setRoot("hello-view");
    }
}
