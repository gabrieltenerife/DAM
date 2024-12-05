module com.mycompany.javafxapptareas {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.javafxapptareas to javafx.fxml;
    exports com.mycompany.javafxapptareas;
}
