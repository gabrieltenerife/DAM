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
public class EncuestaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        App.mostrarInformacion("Configuracion", "Bienvenido! Porfavor, complete la encuesta antes de continuar, puede acceder a ella en otro momento en la ventana principal");
    }
    
               @FXML
        private void popTema() {
        App.mostrarInformacion("Configuracion", "Tema cambiado correctamente");
    }    
        
                   @FXML
        private void popDaltonico() {
        App.mostrarInformacion("Configuracion", "Modo para daltonicos activado");
    }
        
                       @FXML
        private void popDictar() {
        App.mostrarInformacion("Configuracion", "Porfavor dicte las respuestas cerca del microfono"
                + " escuchando...");
    }
        
                    @FXML
        private void popEnviar() {
        App.mostrarInformacion("Configuracion", "Gracias por rellenar nuestra encuesta, tomamos en consideracion sus respuestas");
    }
        
        @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("Principal");
    }
    
                       @FXML
        private void popdisminuir() {
        App.mostrarInformacion("Configuracion", "Se ha disminuido el tamaño de letra");
    }
        
                           @FXML
        private void popDaumentar() {
        App.mostrarInformacion("Configuracion", "Se ha aumentado el tamaño de letra");
    }
    
}
