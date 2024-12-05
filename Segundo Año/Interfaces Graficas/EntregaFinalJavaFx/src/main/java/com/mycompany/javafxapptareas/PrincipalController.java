package com.mycompany.javafxapptareas;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrincipalController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
     @FXML
    private void switchEncuesta() throws IOException {
        App.setRoot("Encuesta");
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
        private void popAudio() {
        App.mostrarInformacion("Reproductor de audio", "Reproduciendo audio...");
    }
                        @FXML
     private void popAyuda() {
       App.mostrarInformacion("Ayuda", "En esta ventana obserbas todas tus tareas, pendientes, en progreso y terminadas");
    }
}