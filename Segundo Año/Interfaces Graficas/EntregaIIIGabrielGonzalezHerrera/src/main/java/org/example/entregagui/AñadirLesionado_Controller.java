package org.example.entregagui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import org.example.entregagui.Dao.CiclistasDAOImpl;
import org.example.entregagui.Dao.LesionesDAOImpl;
import org.example.entregagui.Model.Ciclistas;
import org.example.entregagui.Model.Lesiones;


import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class AñadirLesionado_Controller {

    private CiclistasDAOImpl ciclistasDAO = new CiclistasDAOImpl();
    public ArrayList<Ciclistas> ciclistas = ciclistasDAO.listarCiclistas();

    @FXML
    private DatePicker fechaLesionField;

    @FXML
    private TextField mesesRecuperacionField;

    @FXML
    private ComboBox<String> ciclistasComboBox;

    @FXML
    private Button añadirButton;

    @FXML
    public void initialize() {
        // Llenar el ComboBox con los nombres de los ciclistas
        for (Ciclistas ciclista : ciclistas) {
            ciclistasComboBox.getItems().add(ciclista.getId() + " - " + ciclista.getNombre() + " " + ciclista.getApellido());
        }
    }

    // Método que se ejecuta cuando se hace clic en el botón "Añadir Lesión"
    @FXML
    private void añadirLesion() {
        // Obtener los datos introducidos en los campos
        LocalDate fechaLesion = fechaLesionField.getValue();
        String mesesRecuperacionText = mesesRecuperacionField.getText();
        String ciclistaSeleccionado = ciclistasComboBox.getValue();

        // Validar los datos
        if (fechaLesion == null || mesesRecuperacionText.isEmpty() || ciclistaSeleccionado == null) {
            System.out.println("Por favor, rellena todos los campos.");
            return;
        }

        try {
            int mesesRecuperacion = Integer.parseInt(mesesRecuperacionText);

            // Crear una nueva instancia de Lesiones
            Lesiones lesion = new Lesiones();
            lesion.setFechaLesion(fechaLesion);
            lesion.setMesesRecuperacion(mesesRecuperacion);

            // Asociar la lesión al ciclista seleccionado
            int ciclistaId = Integer.parseInt(ciclistaSeleccionado.split(" - ")[0]);
            for (Ciclistas ciclista : ciclistas) {
                if (ciclista.getId() == ciclistaId) {
                    lesion.setCiclistas(ciclistas);
                    break;
                }
            }

            // Guardar la lesión en la base de datos
            LesionesDAOImpl lesionesDAO = new LesionesDAOImpl();
            lesionesDAO.añadirLesion(lesion);

            System.out.println("Lesión añadida correctamente.");
            salir();

        } catch (NumberFormatException e) {
            System.out.println("El campo de meses de recuperación debe ser un número entero.");
        } catch (Exception e) {
            System.out.println("Error al añadir la lesión: " + e.getMessage());
        }
    }

    @FXML
    private void salir() throws IOException {
        Main.setRoot("hello-view");
    }
}


