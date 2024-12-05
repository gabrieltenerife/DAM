package com.mycompany.javafxapptareas;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("Encuesta");
    }
        @FXML
        private void popAyuda() {
        App.mostrarInformacion("Ayuda al loguin", "Introduzca usuario y contraseña y incie secion o crea una cuenta.");
    }
    
            @FXML
        private void popRegistrarse() {
        App.mostrarInformacion("Registro", "Usuario creado correctamente!");
    }
        
            @FXML
        private void popOlvido() {
        App.mostrarInformacion("Olvide mi contraseña", "Porfavor contacte con el administrador del servicio para solucionarlo");
    }
    
    
}
