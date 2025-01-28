module org.example.entregagui {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires mysql.connector.j;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.logging;
    requires java.desktop;
    requires java.xml;
    requires java.prefs;
    requires static lombok;

    opens org.example.entregagui.Model to org.hibernate.orm.core, javafx.base;

    exports org.example.entregagui;
    exports org.example.entregagui.Conexion;
    opens org.example.entregagui.Conexion to javafx.fxml;
    opens org.example.entregagui to javafx.base, javafx.fxml, org.hibernate.orm.core;
}