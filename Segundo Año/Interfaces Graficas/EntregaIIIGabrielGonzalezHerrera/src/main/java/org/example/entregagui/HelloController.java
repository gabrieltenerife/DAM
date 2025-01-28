package org.example.entregagui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.entregagui.Conexion.Conexion;
import org.example.entregagui.Model.Ciclistas;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    private Session session;
    private Transaction tx;

    @FXML
    private Slider buscarporidSlider;

    @FXML
    private Label sliderValueLabel;

    @FXML
    private Spinner<Integer> buscarpelotonSpinner;

    @FXML
    private TextField buscarbici;

    @FXML
    private TextField idborrar;

    @FXML
    private Button add;

    // ASIGNANDO COLUMNAS DE LA TABLA
    @FXML
    private TableView<Ciclistas> tableView;
    @FXML
    private TableColumn<Ciclistas, Integer> idColumn;
    @FXML
    private TableColumn<Ciclistas, String> nombreColumn;
    @FXML
    private TableColumn<Ciclistas, String> apellidoColumn;
    @FXML
    private TableColumn<Ciclistas, String> bicicletaColumn;
    @FXML
    private TableColumn<Ciclistas, String> pelotonRitmoColumn;

    @FXML
    protected void onHelloButtonClick() {
        // Acción asociada al botón (puede implementarse según sea necesario)
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Inicialización completada.");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        apellidoColumn.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        bicicletaColumn.setCellValueFactory(new PropertyValueFactory<>("bicicleta"));
        pelotonRitmoColumn.setCellValueFactory(ciclista ->
                new SimpleStringProperty(ciclista.getValue().getPelotones() != null ?
                        ciclista.getValue().getPelotones().getRitmo() : "N/A"));

        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 1000, 1);
        buscarpelotonSpinner.setValueFactory(valueFactory);

        // Listener para actualizar el Label con el valor del Slider
        buscarporidSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                sliderValueLabel.setText(String.valueOf(newValue.intValue()));
            }
        });

        RellenarTabla();
    }

    @FXML
    protected void RellenarTabla() {
        try {
            session = Conexion.getConexion();
            tx = session.beginTransaction();

            ArrayList<Ciclistas> ciclistas = (ArrayList<Ciclistas>) session.createQuery("from Ciclistas").list();
            tx.commit();

            buscarbici.setText("");

            // Asigna los datos al TableView
            tableView.getItems().setAll(ciclistas);
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

    @FXML
    protected void buscarpornombre() {
        int busqueda = (int) buscarporidSlider.getValue();
        System.out.println("Valor del Slider: " + busqueda);

        try {
            session = Conexion.getConexion();
            tx = session.beginTransaction();

            ArrayList<Ciclistas> ciclistas = (ArrayList<Ciclistas>) session.createQuery("from Ciclistas where id = :busqueda")
                    .setParameter("busqueda", busqueda).list();

            // Asigna los datos al TableView
            tableView.getItems().setAll(ciclistas);
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

    @FXML
    protected void buscarporpeloton() {
        int busqueda = buscarpelotonSpinner.getValue();

        try {
            session = Conexion.getConexion();
            tx = session.beginTransaction();

            ArrayList<Ciclistas> ciclistas = (ArrayList<Ciclistas>) session.createQuery("from Ciclistas where pelotones.id = :busqueda")
                    .setParameter("busqueda", busqueda).list();

            // Asigna los datos al TableView
            tableView.getItems().setAll(ciclistas);
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

    @FXML
    protected void buscarporbici() {
        String busqueda = buscarbici.getText();

        try {
            session = Conexion.getConexion();
            tx = session.beginTransaction();

            ArrayList<Ciclistas> ciclistas = (ArrayList<Ciclistas>) session.createQuery("from Ciclistas where bicicleta = :busqueda")
                    .setParameter("busqueda", busqueda).list();

            // Asigna los datos al TableView
            tableView.getItems().setAll(ciclistas);
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

    @FXML
    protected void AñadirCiclista() throws IOException {
        Main.setRoot("AñadirCiclista");
    }

    @FXML
    protected void AñadirLesion() throws IOException {
        Main.setRoot("AñadirLesionado");
    }

    @FXML
    protected void AñadirPeloton() throws IOException {
        Main.setRoot("AñadirPeloton");
    }

    @FXML
    protected void AñadirRecorrido() throws IOException {
        Main.setRoot("AñadirRecorrido");
    }

    @FXML
    protected void Accesibilidad() throws IOException {
        Main.setRoot("Accesibilidad");
    }

    @FXML
    protected void CambiarVentana() throws IOException {
        Main.setRoot("SegundaVentana");
    }
}
