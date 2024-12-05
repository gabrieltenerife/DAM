/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.javafxapptareas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author gamba
 */
public class ConfiguracionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
        @FXML
    private void CambiarPrincipal() throws IOException {
        App.setRoot("Principal");
    }
    
          @FXML
    private void CambiarAñadirTareas() throws IOException {
        App.setRoot("AñadirTareas");
    }
          @FXML
    private void CambiarConfiguracion() throws IOException {
        App.setRoot("Configuracion");
    }
          @FXML
    private void CambiarFiltroTareas() throws IOException {
        App.setRoot("FiltroTareas");
    }
          @FXML
    private void CambiarPanelObjetivos() throws IOException {
        App.setRoot("PanelObjetivos");
    }
          @FXML
    private void CambiarAyuda() throws IOException {
        App.setRoot("Ayuda");
    }
                @FXML
        private void popTema() {
        App.mostrarInformacion("Configuracion", "Tema cambiado correctamente");
    }
                @FXML
        private void popOpciones() {
        App.mostrarConfirmacion("Configuracion", "Esta seguro de que quiere realizar este cambio!?");
    }
                        @FXML
     private void popAyuda() {
       App.mostrarInformacion("Ayuda", "Configura la aplicacion para que se adapte a tus necesidades y realiza cambios en la configuracion de usuario");
    }
}
