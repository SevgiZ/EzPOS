module com.main.ezpos {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;
    requires java.sql;
    requires com.google.zxing;
    requires java.desktop;
    requires com.google.zxing.javase;

    opens com.main.ezpos to javafx.fxml;
    exports com.main.ezpos;
}