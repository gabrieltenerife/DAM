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
public class FiltroTareasController implements Initializable {

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
     private void popCambiarPaginaSiguiente() {
       App.mostrarInformacion("Filtro Tareas", "Siguiente pagina");
    }
     
                @FXML
     private void popCambiarPaginaAnterior() {
       App.mostrarInformacion("Filtro Tareas", "Volviendo pagina anterior");
    }
                        @FXML
     private void popAyuda() {
       App.mostrarInformacion("Ayuda", "En esta ventana puedes filtrar tus tareas");
    }
}
