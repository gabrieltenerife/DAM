package org.example.entregagui;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.entregagui.Conexion.Conexion;
import org.example.entregagui.Model.Ciclistas;
import org.example.entregagui.Model.Recorridos;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SegundaVentana_Controller implements Initializable {
    private Session session;
    private Transaction tx;

    @FXML
    TextField nombre;

    @FXML
    TextField nivel;

    @FXML
    private TableView<Recorridos> tableView;
    @FXML
    private TableColumn<Recorridos, Integer> idColumn;
    @FXML
    private TableColumn<Recorridos, String> nombreColumn;
    @FXML
    private TableColumn<Recorridos, Integer> distanciaColumn;
    @FXML
    private TableColumn<Recorridos, Integer> desnivelColumn;

    // Método que se ejecuta al cargar la vista
    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        // Configura columnas de la tabla
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        distanciaColumn.setCellValueFactory(new PropertyValueFactory<>("distancia"));
        desnivelColumn.setCellValueFactory(new PropertyValueFactory<>("desnivel"));

        // Llama a RellenarTabla
        RellenarTabla();
    }

    @FXML
    protected void RellenarTabla() {
        try {
            session = Conexion.getConexion();
            tx = session.beginTransaction();

            // Obtener todos los recorridos desde la base de datos
            List<Recorridos> recorridos = session.createQuery("from Recorridos", Recorridos.class).list();
            tx.commit();

            // Verificar que los datos fueron obtenidos
            System.out.println("Datos obtenidos: " + recorridos.size());

            if (recorridos != null && !recorridos.isEmpty()) {
                System.out.println("Datos en la lista: " + recorridos.get(0).getNombre()); // Imprime el primer nombre del recorrido
                tableView.getItems().setAll(recorridos);
            } else {
                System.out.println("No se encontraron recorridos en la base de datos.");
            }
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }


    // Acción del botón de "Volver Atrás"
    @FXML
    protected void VolverAtras() {
        // Código para volver atrás a la pantalla anterior
        System.out.println("Volver Atrás");
    }

    @FXML
    private void salir () throws IOException {
        Main.setRoot("hello-view");
    }

    @FXML
    protected void buscarpornombre () {

        String busqueda = nombre.getText();

        try {
            session = Conexion.getConexion();
            tx = session.beginTransaction();

            ArrayList<Recorridos> recorridos = (ArrayList<Recorridos>) session.createQuery("from Recorridos where nombre = :busqueda")
                    .setParameter("busqueda",busqueda).list();

            // Asigna los datos al TableView
            tableView.getItems().setAll(recorridos);
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

    @FXML
    protected void buscarpornivel () {

        String busqueda = nivel.getText();

        try {
            session = Conexion.getConexion();
            tx = session.beginTransaction();

            ArrayList<Recorridos> recorridos = (ArrayList<Recorridos>) session.createQuery("from Recorridos where desnivel >= :busqueda")
                    .setParameter("busqueda",busqueda).list();

            // Asigna los datos al TableView
            tableView.getItems().setAll(recorridos);
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

}
