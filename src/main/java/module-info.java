module com.sistemas.quiosque {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.media;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;
    opens com.sistemas.quiosque.Classes to javafx.base;
    opens com.sistemas.quiosque to javafx.fxml;
    exports com.sistemas.quiosque;
}